package com.exa.vuespringboot.dao;

import com.exa.vuespringboot.entity.RoleAuthorityEntity;
import com.exa.vuespringboot.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface IRoleMapper {
	/**
	 * 根据用户id获取用户角色信息
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	Collection<RoleEntity> getUserRolesByUserID(Integer userID) throws Exception;

	/**
	 * 计算查询结果大小
	 * @param params
	 * @return
	 * @throws Exception
	 */
	int count(Map<String, Object> params) throws Exception;

	/**
	 * 查询所有用户的权限
	 * @return
	 * @throws Exception
	 */
    Collection<RoleAuthorityEntity> getAllRoleAuthority() throws Exception;
	/**
	 * 根据用户id获取角色信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	Collection<RoleEntity> getUserRolesByUserIDMap(Map<String, Object> params) throws Exception;

	/**
	 * 获取所有用户信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	Collection<RoleEntity> getAllRolesByMap(Map<String, Object> params) throws Exception;

	/**
	 * 获取所有用户信息
	 * @return
	 * @throws Exception
	 */
	Collection<RoleEntity> getAllRoles() throws Exception;

	/**
	 * 模糊匹配查询角色
	 * @param params
	 * @return
	 * @throws Exception
	 */
	Collection<RoleEntity> getRolesByLike(Map<String, Object> params) throws Exception;

	/**
	 * 删除角色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteRoleByID(Integer id) throws Exception;

	/**
	 * 添加角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	int insertRole(RoleEntity role) throws Exception;

	/**
	 * updateRoleByID
	 * @param role
	 * @return
	 * @throws Exception
	 */
	int updateRoleByID(RoleEntity role) throws Exception;

	/**
	 * 判空添加角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	int insertSelectiveRole(RoleEntity role) throws Exception;

	/**
	 * 判空根据id更新角色信息
	 * @param role
	 * @return
	 * @throws Exception
	 */
	int updateSelectiveRoleByID(RoleEntity role) throws Exception;

	/**
	 * 根据id查询角色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	RoleEntity getRoleByID(Integer id) throws Exception;

	List<RoleEntity> getAllRoleImport(Map<String, Object> param);
}