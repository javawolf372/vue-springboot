package com.exa.vuespringboot.dao;

import com.exa.vuespringboot.entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IAreaMapper {

	void deleteArea(Long id);

	void deleteAreaOnly(Long id);

	int count(Map<String, Object> params);

	void insertArea(AreaEntity entity);

	void updateArea(AreaEntity entity);

	List<AreaEntity> listAllArea(Map<String, Object> map);

	List<AreaEntity> listAreaByOrgStr(Map<String, Object> map);
	
	AreaEntity getAreaById(Long id);

	AreaEntity get(Map<String, Object> map);

}