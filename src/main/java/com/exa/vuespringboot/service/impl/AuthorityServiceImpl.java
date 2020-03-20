package com.exa.vuespringboot.service.impl;

import com.exa.vuespringboot.dao.IAuthorityMapper;
import com.exa.vuespringboot.dao.IOrganizationMapper;
import com.exa.vuespringboot.entity.*;
import com.exa.vuespringboot.service.IAuthorityService;
import com.exa.vuespringboot.utils.PowerCacheUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AuthorityServiceImpl implements IAuthorityService {

    @Resource
    private IAuthorityMapper authorityMapper;

    @Resource
    private PowerCacheUtil powerCacheUtil;

    @Resource
    private IOrganizationMapper organizationMapper;

    /**
     * 通过用户id和父级id查询用户系统权限
     *
     * @param userid
     * @param pid
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List<AuthorityEntity> getAuthorityDataById(long userid, long pid) {
        return powerCacheUtil.getUserSysMenuAutontity(userid, pid);
    }

    /**
     * 通过权限id查询菜单权限
     *
     * @param id
     * @return
     */
    @Override
    public List<AbstractTreeEntity> getAuthorityTreeData(int id) {
        List<AuthorityEntity> list = authorityMapper.listAuthorityData(id);
        List<AbstractTreeEntity> treeList = shortTree(list, false);
        return treeList;
    }

    /**
     * 集合转化树形结构
     *
     * @param list
     * @param rootZero
     * @return
     */
    private List<AbstractTreeEntity> shortTree(List<AuthorityEntity> list, boolean rootZero) {
        List<AbstractTreeEntity> treeList = new ArrayList<AbstractTreeEntity>();
        Map<Long, AuthorityEntity> map = new LinkedHashMap<Long, AuthorityEntity>();
        for (AuthorityEntity entity : list) {
            map.put(entity.getId(), entity);
        }
        if (rootZero) {
            AuthorityEntity zero = map.get(1L);
            if (zero != null) {
                treeList.add(getAbstractTree(zero, map));
            }
        } else {
            for (AuthorityEntity entity : map.values()) {
                if (entity.getParentId() == null) {
                    treeList.add(getAbstractTree(entity, map));
                }
            }
        }
        return treeList;
    }

    /**
     * 树转化
     *
     * @param entity
     * @param map
     * @return
     */
    private AbstractTreeEntity getAbstractTree(AuthorityEntity entity, Map<Long, AuthorityEntity> map) {
        AbstractTreeEntity tree = new AbstractTreeEntity();
        tree.setId(entity.getId());
        tree.setText(entity.getTitle());
        tree.setType(entity.getType());
        for (Long key : map.keySet()) {
            AuthorityEntity c = map.get(key);
            if (c != null && c.getParentId() != null && c.getParentId().longValue() == entity.getId().longValue()) {
                AbstractTreeEntity ct = getAbstractTree(c, map);
                tree.addChildren(ct);
            }
        }
        return tree;
    }

    /**
     * 添加树结构
     *
     * @param entitys
     * @return
     */
    private List<AbstractTreeEntity> AuthorityToTreeData(List<AuthorityEntity> entitys) {
        List<AbstractTreeEntity> result = new ArrayList<>();
        if (entitys != null) {
            for (AuthorityEntity entity : entitys) {
                result.add(recursionData(entity));
            }
        }
        return result;
    }

    /**
     * 树添加子集
     *
     * @param entity
     * @return
     */
    private AbstractTreeEntity recursionData(AuthorityEntity entity) {
        AbstractTreeEntity tree = new AbstractTreeEntity();
        tree.setId(entity.getId());
        tree.setText(entity.getTitle());
        for (AuthorityEntity c : entity.getChildren()) {
            tree.addChildren(recursionData(c));
        }
        return tree;
    }

    private List<AuthorityEntity> shortList(List<AuthorityEntity> list, boolean rootZero) {
        if (list == null) return new ArrayList<>();
        List<AuthorityEntity> retList = new ArrayList<AuthorityEntity>();
        Map<Long, AuthorityEntity> map = new LinkedHashMap<Long, AuthorityEntity>();
        for (AuthorityEntity entity : list) {
            map.put(entity.getId(), entity);
        }
        for (AuthorityEntity entity : list) {
            if (entity.getParentId() != null && entity.getParentId()!=0) {
                AuthorityEntity p = map.get(entity.getParentId());
                if (p != null) {
                    p.addChildren(entity);
                }
            }
        }
        if (rootZero) {
            AuthorityEntity zero = map.get(1L);
            if (zero != null) {
                retList.add(zero);
            }
        } else {
            for (AuthorityEntity entity : map.values()) {
                if (entity.getParentId() == null || entity.getParentId() ==0 ) {
                    retList.add(entity);
                }
            }
        }
        return retList;
    }

    /**
     * 查询树结构并排序
     *
     * @param typeLong
     * @return
     */
    @Override
    public List<AbstractTreeEntity> getAuthorityTreeData(long typeLong) {
        List<AuthorityEntity> list = authorityMapper.listAuthorityData((int) typeLong);
        List<AbstractTreeEntity> treeList = shortTree(list, false);
        return treeList;
    }

    /**
     * 添加页面查询树结构
     *
     * @param typeLong
     * @return
     */
    @Override
    public List<AbstractTreeEntity> getAuthorityTreeData1(long typeLong) {
        List<AuthorityEntity> list = authorityMapper.listAuthorityData((int) typeLong);
        List<AbstractTreeEntity> treeList = AuthorityToTreeData(list);
        return treeList;
    }

    /**
     * 根据id查询rootid
     *
     * @param parentId
     * @return
     */
    @Override
    public List<AuthorityEntity> queryRootid(Long parentId) {
        return authorityMapper.queryRootid(parentId);
    }

    /**
     * 根据id删除单个权限
     *
     * @param longID
     * @return
     */
    @Override
    public boolean deleteSelf(long longID) {
        int tiao = authorityMapper.deleteSelf(longID);
        if (tiao > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据权限id删除角色权限
     *
     * @param longID
     */
    @Override
    public void deleteRoleAuthority(long longID) {
        authorityMapper.deleteRoleAuthority(longID);
    }

    /**
     * 根据id查询权限数据
     *
     * @param id
     * @return
     */
    @Override
    public AuthorityEntity queryAuthorityById(Long id) {
        return authorityMapper.queryAuthorityById(id);
    }

    /**
     * 根据用户标识，获取所有类型为0(即：系统)的权限
     *
     * @param userid
     * @return
     */
    @Override
    public List<AuthorityEntity> getlistMenu(Integer userid) {
        List list = new ArrayList();
        if (userid != null) {
            list = powerCacheUtil.getUserAllSysAutontity(userid.longValue());
        }
        return list;
    }

    /**
     * 根据用户标识，获取所有的权限
     *
     * @param userid
     * @return
     */
    @Override
    public List<AuthorityEntity> getAuthorityDataById1(long userid) {
        List list = new ArrayList();
        list = powerCacheUtil.getUserMenuAutontity(userid);
        return list;
    }

    /**
     * 查询root最大权限
     *
     * @return
     */
    @Override
    public int queryMaxRootId() {
        return authorityMapper.queryMaxRootId();
    }


    /**
     * 查询上级部门及下级所有办案中心
     *
     * @param parent_org_id
     * @return
     */
    @Override
    public String getALLAreaByParentOrg(Integer parent_org_id) {
        List<AreaEntity> list = authorityMapper.getALLAreaByParentOrg(parent_org_id);
        StringBuffer sb = new StringBuffer();
        if (list != null) {
            sb.append(" in (");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).getId());
                if (i < (list.size() - 1)) {
                    sb.append(",");
                }
            }
            sb.append(")");
            return sb.toString();
        }
        return sb.toString();
    }

    /**
     * 根据上级部门id获取下级所有部门信息
     *
     * @param parent_org_id
     * @return
     */
    @Override
    public String getALLOrgByParentOrg(Integer parent_org_id) {
        StringBuffer sb = new StringBuffer();
        List<OrganizationEntity> list = authorityMapper.getALLOrgByParentOrg(parent_org_id);
        if (list != null) {
            sb.append(" in (");
            sb.append(parent_org_id + ",");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).getId());
                if (i < (list.size() - 1)) {
                    sb.append(",");
                }
                List<OrganizationEntity> list2 = authorityMapper.getALLOrgByParentOrg(list.get(i).getId());
                if (list2 != null) {
                    for (int j = 0; j < list2.size(); j++) {
                        sb.append(list2.get(j).getId());
                        if (i < (list2.size() - 1)) {
                            sb.append(",");
                        }
                        List<OrganizationEntity> list3 = authorityMapper.getALLOrgByParentOrg(list.get(i).getId());
                        if (list3 != null) {
                            for (int k = 0; k < list3.size(); k++) {
                                sb.append(list3.get(k).getId());
                                if (i < (list3.size() - 1)) {
                                    sb.append(",");
                                }
                            }
                        }
                    }
                }
            }
            sb.append(")");
            return sb.toString();
        }
        return sb.toString();
    }

    /**
     * 根据用户id获取其上级部门
     *
     * @param userId
     * @return
     */
    @Override
    public Integer getParentOrgByUserId(Integer userId) {
        Integer orgId = authorityMapper.getParentOrgByUserId(userId);
        return orgId;
    }

    /**
     * 获取父类下的所有民警
     *
     * @param orgId
     * @return
     */
    @Override
    public String getALLPoliceByParentOrg(Integer orgId) {
        List<OrganizationEntity> org = organizationMapper.listChild(orgId);
        if (org == null || org.size() == 0) {
            return null;
        }
        StringBuilder s = new StringBuilder();
        s.append(" in(");
        s.append(orgId + ",");
        int sizes = org.size();
        for (int i = 0; i < sizes; i++) {
            s.append(org.get(i).getId());
            if (i < sizes - 1) {
                s.append(",");
            }
        }
        s.append(") ");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("orgId", s.toString());
        List<UserEntity> user = authorityMapper.getALLPoliceByParentOrg(map);
        if (user == null || user.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" in(");
        int size = user.size();
        for (int i = 0; i < size; i++) {
            sb.append(user.get(i).getId());
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append(") ");
        return sb.toString();
    }

    /**
     * 根据父类id查下面所有的办案中心
     *
     * @param parent_org_id
     * @return
     */
    @Override
    public List<AreaEntity> getALLArea(Integer parent_org_id) {
        List<AreaEntity> list = authorityMapper.getALLAreaByParentOrg(parent_org_id);
        return list;
    }

    /**
     * 增加角色权限
     *
     * @param roleId
     * @param authorityIds
     * @throws Exception
     */
    @Override
    public void batchInsertRoleAuthority(Long roleId, String authorityIds) throws Exception {
        List<Map<String, Object>> param = new ArrayList<>();
        if (authorityIds != null && !"".equals(authorityIds.trim())) {
            for (String authorityId : authorityIds.split(",")) {
                Map map = new HashMap();
                map.put("roleId", roleId);
                map.put("authorityId", authorityId);
                param.add(map);
            }
            authorityMapper.batchInsertRoleAuthortity(param);
        }
    }

    /**
     * 删除角色的全部权限
     *
     * @param roleId
     * @throws Exception
     */
    @Override
    public void delAuthorityByRole(Long roleId) throws Exception {
        authorityMapper.delAuthorityByRole(roleId);
    }

    /**
     * 根据角色id查询该角色权限id
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Long> getAuthorityIdsByRole(Long roleId) throws Exception {
        return authorityMapper.queryAuthorityIdsByRole(roleId);
    }

    /**
     * 权限集合变为权限树
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<AbstractTreeEntity> getAuthorityTree() throws Exception {
        List<AuthorityEntity> list = authorityMapper.listAuthorityNotHide();
        List<AuthorityEntity> shortList = shortList(list, false);
        List<AbstractTreeEntity> treeList = AuthorityToTreeData(shortList);
        return treeList;
    }

    @Override
    public List<AbstractTreeEntity> getCsAuthorityTree() {
        List<AuthorityEntity> list = authorityMapper.listCsAuthorityNotHide();
        List<AuthorityEntity> shortList = shortList(list, false);
        List<AbstractTreeEntity> treeList = AuthorityToTreeData(shortList);
        return treeList;
    }

    @Override
    public void delAuthorityCsByRole(Long roleId) {
        authorityMapper.delAuthorityCsByRole(roleId);
    }

    @Override
    public void batchInsertRoleAuthorityCs(Long roleId, String authorityIds) {
        List<Map<String, Object>> param = new ArrayList<>();
        if (authorityIds != null && !"".equals(authorityIds.trim())) {
            for (String authorityId : authorityIds.split(",")) {
                Map map = new HashMap();
                map.put("roleId", roleId);
                map.put("authorityId", authorityId);
                param.add(map);
            }
            authorityMapper.batchInsertRoleAuthorityCs(param);
        }
    }

    @Override
    public List<Long> getAuthorityCsIdsByRole(Long id) {
        return authorityMapper.queryAuthorityCsIdsByRole(id);
    }

    /**
     * 查询权限集合排序
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<AuthorityEntity> getAuthorityData() throws Exception {
        List<AuthorityEntity> list = authorityMapper.listAuthority();
        List<AuthorityEntity> shortList = shortList(list, false);
        return shortList;
    }

    /**
     * 根据父类id删除权限
     *
     * @param longID
     * @return
     */
    @Override
    public boolean delete(long longID) {
        int tiao = authorityMapper.delete(longID);
        if (tiao > 0) {
            return true;
        }
        return false;
    }

    /**
     * 修改权限
     *
     * @param entity
     */
    @Override
    public void update(AuthorityEntity entity) {
        this.authorityMapper.updateByPrimaryKeySelective(entity);

    }

    /**
     * 添加权限
     *
     * @param entity
     * @return
     */
    @Override
    public boolean insert(AuthorityEntity entity) {
        int tiao = authorityMapper.insertSelective(entity);
        if (tiao > 0) {
            return true;
        }
        return false;

    }
}
