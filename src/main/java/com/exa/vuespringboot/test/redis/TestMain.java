package com.exa.vuespringboot.test.redis;

import com.exa.vuespringboot.VueSpringbootApplication;
import com.exa.vuespringboot.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VueSpringbootApplication.class)
@WebAppConfiguration
public class TestMain {

    @Resource
    RedisUtil redisUtil;

    @Test
    public void test(){
        /* ===================操作String========================*/
        //增加
        redisUtil.set("name", "狼腾");
        //修改
        redisUtil.set("name", "狼腾2");
        //查询
        System.out.println("获取key为'name'字符串：" + redisUtil.get("name"));
        //判断是否存在
        System.out.println("删除前判断是否存在：" + redisUtil.hasKey("name"));
        //删除  支持一次删除多个  redisUtil.del(new String[]{"k1", "k2"}) 或者 redisUtil.del("k1", "k2")
        redisUtil.del("name");
        System.out.println("删除后判断是否存在：" + redisUtil.hasKey("name"));

        /* ===================操作Hash========================*/
        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("name", "狼腾2");
        tempMap.put("age", 18);
        Map<String, Object> tempMap2 = new HashMap<>();
        tempMap2.put("name", "狼腾");
        tempMap2.put("sex", '男');
        //新建 key - hash值
        redisUtil.hmset("person", tempMap);
        //如果key存在会覆盖、合并前面的值
        redisUtil.hmset("person", tempMap2);
        //增加参数
        redisUtil.hset("person", "height", 1.88);
        //修改
        redisUtil.hset("person", "height", 1.99);
        //查询
        System.out.println("获取到人员身高："+redisUtil.hget("person", "height"));
        System.out.println("获取到人员全部信息："+redisUtil.hmget("person"));
        //判断key-hash里面是否存在某个参数
        System.out.println("删除前，判断person里面是否存在height参数："+redisUtil.hHasKey("person", "height"));
        //删除key-hash里面的值 支持一次删除多个  redisUtil.hdel("k", new String[]{"k1", "k2"}) 或者 redisUtil.del("k", "k1", "k2")
        redisUtil.hdel("person", "height");
        System.out.println("删除后，判断person里面是否存在height参数："+redisUtil.hHasKey("person", "height"));
        //删除所有
        redisUtil.del("person");

        /* ===================操作list======================== */
        List<TestPerson> tempList = new ArrayList<>();
        tempList.add(new TestPerson("张三", 18, 18.9, "男"));
        tempList.add(new TestPerson("李四", 19, 19.9, "女"));
        List<TestPerson> tempList2 = new ArrayList<>();
        tempList2.add(new TestPerson("张三", 12, 18.9, "女"));
        tempList2.add(new TestPerson("王五", 19, 19.9, "女"));
        //由于list的新增是累加操作 测试前先删除前面的类型
        redisUtil.del("persons");
        //新建 key-list值
        redisUtil.lSet("persons", tempList);
        //当key存在是，累加
        redisUtil.lSet("persons", tempList2);
        //直接增加对象
        redisUtil.lSet("persons", new TestPerson("赵六", 11, 11.9, "男"));
        //查询
        System.out.println("获取索引0-2的值：" + redisUtil.lGet("persons", 0, 2));
        System.out.println("获取list最后一个值："+ redisUtil.lGetIndex("persons", redisUtil.lGetListSize("persons")-1));
    }

}

