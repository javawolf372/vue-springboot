package com.exa.vuespringboot.dao;

import com.exa.vuespringboot.entity.*;
import com.exa.vuespringboot.form.AuthorityForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IAuthorityMapper {
    /**
     * 根据父类id查询所有权限
     * @return
     * @throws Exception
     */
    List<AuthorityEntity> listAuthority() throws Exception;

    /**
     * 添加页面查询树结构
     * @param id
     * @return
     */
    List<AuthorityEntity> listAuthorityData(Integer id);

    /**
     * 根据id查询所有权限
     * @param id
     * @return
     */
    AuthorityEntity queryAuthorityById(Long id);

    /**
     * 查询非代办事项的所有权限
     * @return
     */
    List<AuthorityEntity> listAuthorityNotHide();

    /**
     * 根据角色id查询该角色权限id
     * @param roleId
     * @return
     */
    List<Long> queryAuthorityIdsByRole(Long roleId);

    /**
     * 删除角色的权限
     * @param roleId
     */
    void delAuthorityByRole(Long roleId);

    /**
     * 增加角色权限
     * @param param
     */
    void batchInsertRoleAuthortity(List<Map<String, Object>> param);

    /**
     * 添加权限
     * @param entity
     * @return
     */
    int insertSelective(AuthorityEntity entity);

    /**
     * 添加页面查询树结构
     * @param form
     * @return
     */
    List<AuthorityEntity> listAuthorityDataByForm(AuthorityForm form);

    /**
     * 根据id查询rootid
     * @param parentId
     * @return
     */
    List<AuthorityEntity> queryRootid(Long parentId);

    /**
     * 根据父类id删除权限
     * @param longID
     * @return
     */
    int delete(long longID);

    /**
     * 根据id删除单个权限
     * @param longID
     * @return
     */
    int deleteSelf(long longID);

    /**
     * 根据权限id删除角色权限
     * @param longID
     */
    void deleteRoleAuthority(long longID);

    /**
     * 修改权限
     * @param entity
     */
    void updateByPrimaryKeySelective(AuthorityEntity entity);

    /**
     * 查询非代办事项的单个用户权限
     * @param userId
     * @return
     */
    List<AuthorityEntity> queryByUserId(Long userId);

    /**
     * 查询菜单
     * @param userid
     * @return
     */
    List<AuthorityEntity> getlistMenu(Integer userid);

    /**
     * 根据父类id和rootid查询权限
     * @param pid
     * @return
     */
    List<AuthorityEntity> listAuthorityById(long pid);

    /**
     * 查询代办事项
     */
    /*List<String> listHideUrlByPid(Long pid);*/

    /**
     * 查询所有用户id和权限id
     *
     * @return
     */
    List<UserAuthorityEntity> listAllUserAuth();

    /**
     * 查询root最大权限
     * @return
     */
    int queryMaxRootId();

    /**
     * 查询权限附加菜单
     *
     * @return
     */
    List<AuthorityEntity> listAuthorityExtraMenu();

    /**
     * 根据父类id查下面所有的办案中心
     *
     * @param parent_org_id
     * @return
     */
    List<AreaEntity> getALLAreaByParentOrg(Integer parent_org_id);

    /**
     * 查询上级部门及下级所有部门
     * @param parent_org_id
     * @return
     */
    List<OrganizationEntity> getALLOrgByParentOrg(Integer parent_org_id);

    /**
     * 查询上级部门
     *
     * @param userId
     * @return
     */
    Integer getParentOrgByUserId(Integer userId);

    /**
     * 根据父类id查下面所有的民警
     *
     * @param map
     * @return
     */
    List<UserEntity> getALLPoliceByParentOrg(Map<String, String> map);

    List<AuthorityEntity> listCsAuthorityNotHide();

    void delAuthorityCsByRole(Long roleId);

    void batchInsertRoleAuthorityCs(List<Map<String, Object>> param);

    List<Long> queryAuthorityCsIdsByRole(Long id);
}
