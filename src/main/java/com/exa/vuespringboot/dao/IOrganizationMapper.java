package com.exa.vuespringboot.dao;


import com.exa.vuespringboot.entity.OrganizationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface IOrganizationMapper {
    
	public OrganizationEntity load(Integer id);
	
	public List<OrganizationEntity> list(Map<String, Object> map);
	
	public List<OrganizationEntity> listChild(Integer parentId);

	public List<OrganizationEntity> listByIds(Map<String, Object> map);

	public int count(Map<String, Object> map);

	Collection<OrganizationEntity> getOrganizationByUserId(Integer userId) throws Exception;

	public void insertOrganization(OrganizationEntity entity);

	public int insert(OrganizationEntity record);

	public void update(OrganizationEntity record);

	public void delete(int id);

	public void deleteRela(Map<String, Object> map);

	public List<OrganizationEntity> listChild(Map<String, Object> map);

	public int childCount(Map<String, Object> map);

	public List<OrganizationEntity> listChildOrg(Map<String, Object> map);

	public void updateParentId(OrganizationEntity record);

	List<OrganizationEntity> getOrgByUserId(Integer userId) throws Exception;

	OrganizationEntity getOrganizationByUserId2(Integer userId) throws Exception;

	public List<OrganizationEntity> listOrgByRegionCode(Long regionCode);


}