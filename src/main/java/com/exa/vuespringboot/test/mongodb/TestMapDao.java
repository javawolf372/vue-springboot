package com.exa.vuespringboot.test.mongodb;

import com.exa.vuespringboot.utils.MongoDbBaseDao;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestMapDao extends MongoDbBaseDao<Map> {
    @Override
    protected Class<Map> getEntityClass() {
        return Map.class;
    }

    @Override
    public String getConllectionName() {
        return "my-map";
    }
}
