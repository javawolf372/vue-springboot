package com.exa.vuespringboot.test.mongodb;

import com.exa.vuespringboot.utils.MongoDbBaseDao;
import org.springframework.stereotype.Component;

@Component
public class TestPersonDao extends MongoDbBaseDao<TestPerson> {

    @Override
    protected Class<TestPerson> getEntityClass() {
        return TestPerson.class;
    }

}
