package com.exa.vuespringboot.service.impl;

import com.exa.vuespringboot.dao.IDemoMapper;
import com.exa.vuespringboot.entity.DemoEntity;
import com.exa.vuespringboot.service.IDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements IDemoService {

    @Resource
    private IDemoMapper demoMapper;

    @Override
    public List<DemoEntity> list(Map<String, Object> param) {
        return demoMapper.list(param);
    }

    @Override
    public Integer count(Map<String, Object> param) {
        return demoMapper.count(param);
    }

    @Override
    public Integer insert(DemoEntity demoEntity) {
        return demoMapper.insert(demoEntity);
    }

    @Override
    public void update(DemoEntity demoEntity) {
        demoMapper.update(demoEntity);
    }

    @Override
    public void delete(Integer id) {
        demoMapper.delete(id);
    }
}
