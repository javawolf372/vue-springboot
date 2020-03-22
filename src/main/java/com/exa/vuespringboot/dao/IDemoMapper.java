package com.exa.vuespringboot.dao;

import com.exa.vuespringboot.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IDemoMapper {

    List<DemoEntity> list(Map<String, Object> param);

    Integer count(Map<String, Object> param);

    Integer insert(DemoEntity demoEntity);

    void update(DemoEntity demoEntity);

    void delete(Integer id);

}
