package com.exa.vuespringboot.dao;

import com.exa.vuespringboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface IUserMapper {

	List<UserEntity> getAllUsers();

	UserEntity getUserByLoginNameAndPassword(Map<String, Object> params) throws Exception;

	List<UserEntity> getUsersByOrgId(Long organizationId) throws Exception;

	Collection<UserEntity> getUserInfo(Map<String, Object> map)  ;

	int count(Map<String, Object> map);

	void insertUser(UserEntity entity);

	void updateUserByID(UserEntity entity);

	void deleteUserByID(Integer id);

	void updateUserRoles(UserEntity entity);

	List<UserEntity> searchAllUserByGmxxId(Map<String, Object> map);

	List<UserEntity> searchAllUser(Map<String, Object> map);

	UserEntity selectInfo(String dd);
	
	void updateMobileNo(UserEntity entity);

	UserEntity getUserByCertificateNo(String certificateNo) throws Exception;

	UserEntity queryUserNoById(Long pid);

	UserEntity getUserByID(Integer id) throws Exception;

    Collection<UserEntity> getUsersByLike(Map<String, Object> map);

	int getUsersByLikeCount(Map<String, Object> map);

	//获取协办民警
	List<UserEntity> getXbUserInfo(Map<String, Object> parm) throws Exception;

	Collection<UserEntity> getUserInfonoJurisdiction(Map<String, Object> map);

	int noJurisdictionCount(Map<String, Object> map);

	 void updatePsw(UserEntity entity);

	List<UserEntity> queryUserByGlzongdui();
}