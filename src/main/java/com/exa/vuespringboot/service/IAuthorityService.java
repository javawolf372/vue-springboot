package com.exa.vuespringboot.service;

import com.exa.vuespringboot.entity.AbstractTreeEntity;
import com.exa.vuespringboot.entity.AreaEntity;
import com.exa.vuespringboot.entity.AuthorityEntity;

import java.util.List;

public interface IAuthorityService {
    /**
     * 通过权限id查询菜单权限
     *
     * @param id
     * @return
     */
    public List<AbstractTreeEntity> getAuthorityTreeData(int id);

    /**
     * 通过用户id和父级id查询用户系统权限
     *
     * @param userid
     * @param pid
     * @return
     */
    List<AuthorityEntity> getAuthorityDataById(long userid, long pid);

    /**
     * 根据id查询权限数据
     *
     * @param id
     * @return
     */
    public AuthorityEntity queryAuthorityById(Long id);

    /**
     * 查询权限集合排序
     *
     * @return
     * @throws Exception
     */
    List<AuthorityEntity> getAuthorityData() throws Exception;

    /**
     * 添加权限
     *
     * @param entity
     * @return
     */
    boolean insert(AuthorityEntity entity);

    /**
     * 修改权限
     *
     * @param entity
     */
    void update(AuthorityEntity entity);

    /**
     * 根据父类id删除权限
     *
     * @param longID
     * @return
     */
    boolean delete(long longID);

    /**
     * 权限集合变为权限树
     *
     * @param typeLong
     * @return
     */
    List<AbstractTreeEntity> getAuthorityTreeData(long typeLong);

    /**
     * 根据角色id查询该角色权限id
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Long> getAuthorityIdsByRole(Long roleId) throws Exception;

    /**
     * 删除角色的全部权限
     *
     * @param roleId
     * @throws Exception
     */
    void delAuthorityByRole(Long roleId) throws Exception;

    /**
     * 增加角色权限
     *
     * @param roleId
     * @param authorityIds
     * @throws Exception
     */
    void batchInsertRoleAuthority(Long roleId, String authorityIds) throws Exception;

    /**
     * 根据id查询rootid
     *
     * @param parentId
     * @return
     */
    List<AuthorityEntity> queryRootid(Long parentId);

    /**
     * 根据id删除单个权限
     *
     * @param longID
     * @return
     */
    boolean deleteSelf(long longID);

    /**
     * 根据权限id删除角色权限
     *
     * @param longID
     */
    void deleteRoleAuthority(long longID);

    /**
     * 根据用户标识，获取所有类型为0(即：系统)的权限
     *
     * @param userid
     * @return
     */
    List<AuthorityEntity> getlistMenu(Integer userid);

    /**
     * 根据用户标识，获取所有的权限
     *
     * @param userid
     * @return
     */
    List<AuthorityEntity> getAuthorityDataById1(long userid);

    /**
     * 添加页面查询树结构
     *
     * @param typeLong
     * @return
     */
    List<AbstractTreeEntity> getAuthorityTreeData1(long typeLong);

    /**
     * 查询root最大权限
     *
     * @return
     */
    int queryMaxRootId();

    /**
     * 根据父类id查下面所有的办案中心
     *
     * @param parent_org_id
     * @return
     */
    String getALLAreaByParentOrg(Integer parent_org_id);

    /**
     * 根据上级部门id获取下级所有部门信息
     *
     * @param parent_org_id
     * @return
     */
    String getALLOrgByParentOrg(Integer parent_org_id);

    /**
     * 根据父类id查下面所有的办案中心
     *
     * @param parent_org_id
     * @return
     */
    List<AreaEntity> getALLArea(Integer parent_org_id);

    /**
     * 根据用户id获取其上级部门
     *
     * @param userId
     * @return
     */
    Integer getParentOrgByUserId(Integer userId);

    /**
     * 获取父类下的所有民警
     *
     * @param orgId
     * @return
     */
    String getALLPoliceByParentOrg(Integer orgId);

    /**
     * @return
     * @throws Exception
     */
    List<AbstractTreeEntity> getAuthorityTree() throws Exception;

    List<AbstractTreeEntity> getCsAuthorityTree();

    void delAuthorityCsByRole(Long roleId);

    void batchInsertRoleAuthorityCs(Long roleId, String authorityIds);

    List<Long> getAuthorityCsIdsByRole(Long id);
}
