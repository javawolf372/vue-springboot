package com.exa.vuespringboot.service;

import com.exa.vuespringboot.entity.DemoEntity;

import java.util.List;
import java.util.Map;

public interface IDemoService {

    List<DemoEntity> list(Map<String, Object> param);

    Integer count(Map<String, Object> param);

    Integer insert(DemoEntity demoEntity);

    void update(DemoEntity demoEntity);

    void delete(Integer id);

}
