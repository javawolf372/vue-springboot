package com.exa.vuespringboot.test.mongodb;

import com.exa.vuespringboot.VueSpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VueSpringbootApplication.class)
@WebAppConfiguration
public class TestMain {

    @Resource
    TestPersonDao testPersonDao;

    @Resource
    TestMapDao testMapDao;

    /**
     * ======================实现针对对象的CRUD操作===========================
     */
    @Test
    public void testObject(){
        //先删除所有
        testPersonDao.deleteAll();
        //新增一个人员
        TestPerson tp = new TestPerson("张三", 18, 198.2, "男");
        TestPerson addedPerson = testPersonDao.save(tp);
        System.out.println("返回添加成功的对象：" + addedPerson);
        //批量新增
        List<TestPerson> tempList = Arrays.asList(new TestPerson("赵六", 12, 18.9, "女"),
                                                  new TestPerson("王五", 19, 19.9, "女"));
        List<TestPerson> addedPsersons = testPersonDao.batchToSave(tempList);
        System.out.println("批量添加后返回的数据：");
        addedPsersons.forEach(System.out::println);
        //将添加的数据姓名改成李四
        TestPerson updatePerson = new TestPerson();
        updatePerson.setName("李四");
        testPersonDao.updateMulti(addedPerson, updatePerson);
        //将所有sex='女'的年龄改为16
        TestPerson sPerson = new TestPerson();
        sPerson.setSex("女");
        TestPerson uPerson = new TestPerson();
        uPerson.setAge(16);
        testPersonDao.updateMulti(sPerson, uPerson);
        //根据id删除
        testPersonDao.deleteById(addedPerson.getId());
        //根据条件删除  删除年龄16的文档
        TestPerson dPerson = new TestPerson();
        dPerson.setAge(16);
        testPersonDao.delete(dPerson);
        System.out.println("查看所有：");
        testPersonDao.queryAll().forEach(System.out::println);
    }

    /**
     * ======================实现针对Map的CRUD操作===========================
     */
    @Test
    public void testMap(){
        //先删除所有
        testMapDao.deleteAll();
        //新增一个人员
        Map<String, Object> map = new HashMap<>();
        map.put("name", "我是map");
        map.put("status", 1);
        Map result = testMapDao.save(map);
        System.out.println("返回添加成功的对象：" + result);
        //批量新增
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "我是map1");
        map1.put("status", 2);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "我是map2");
        map2.put("status", 1);
        List<Map> tempMapList = Arrays.asList(map1, map2);
        List<Map> addedMaps = testMapDao.batchToSave(tempMapList);
        System.out.println("批量添加后返回的数据：");
        addedMaps.forEach(System.out::println);
        //将添加的数据姓名改成我是修改后的map2
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "我是修改后的map2");
        testMapDao.updateMulti(map, map3);
        //将所有status=1的状态改为3
        Map<String, Object> map4 = new HashMap<>();
        map4.put("status", 1);
        Map<String, Object> map5 = new HashMap<>();
        map5.put("status", 3);
        testMapDao.updateMulti(map4, map5);
        //根据id删除
        testMapDao.deleteById(map.get("_id")+"");
        //根据条件删除  删除状态为2的文档
        Map<String, Object> map6 = new HashMap<>();
        map6.put("status", 2);
        testMapDao.delete(map6);
        System.out.println("查看所有：");
        testMapDao.queryAll().forEach(System.out::println);
    }

    /**
     * ======================各种查询操作（此处以Map为例，对象类似）===========================
     */
    @Test
    public void testQuery(){
        //先删除所有
        testMapDao.deleteAll();
        List<Map> tempMapList = initData();
        System.out.println("初始化后的数据为：");
        tempMapList.forEach(System.out::println);
        List<Map> result = testMapDao.batchToSave(tempMapList);
        //根据id查询结果
        Map queryByIdResult = testMapDao.queryById(result.get(0).get("_id")+"");
        System.out.println("根据id=["+result.get(0).get("_id")+"]，查询的结果为："+queryByIdResult);
        //查询状态为1的数据
        Map param = new HashMap();
        param.put("status", 1);
        List<Map> queryByMapResult = testMapDao.queryList(param);
        System.out.println("查询状态为1的数据：");
        queryByMapResult.forEach(System.out::println);
        //对状态为2的数据进行，分页条件查询 默认排序
        param.clear();
        param.put("status", 2); //如果查询所有 此行删除
        int currPage = 2; //当前页数
        int pageSize = 3; //每页的条数
        List<Map> queryByPageAndSizeNotOrderResult = testMapDao.getPage(param, (currPage-1)*pageSize, pageSize);
        System.out.println("状态为2的总条数["+testMapDao.getCount(param)+"]分页查询的未排序数据：");
        queryByPageAndSizeNotOrderResult.forEach(System.out::println);
        //对所有数据进行，分页条件查询  自定义排序
        param.clear();
        currPage = 2; //当前页数
        pageSize = 5; //每页的条数
        Map<String, Sort.Direction> orderMap = new LinkedHashMap<>();
        orderMap.put("status", Sort.Direction.ASC);
        orderMap.put("age", Sort.Direction.DESC);
        List<Map> queryByPageAndSizeOrderResult = testMapDao.getPage(param, (currPage-1)*pageSize, pageSize, orderMap);
        System.out.println("总条数["+testMapDao.getCount(param)+"]分页查询的排序后数据：");
        queryByPageAndSizeOrderResult.forEach(System.out::println);
        //自定义高级查询  ---该方式解决封装方式满足不了条件的情况 比如模糊查询，比如大于小于条件查询  比如多条件混合查询
        currPage = 1; //当前页数
        pageSize = 5; //每页的条数
        Query query = new Query();
        Pattern pattern=Pattern.compile("^.*map1.*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("name").regex(pattern));//包含map1字符串
        query.addCriteria(Criteria.where("age").gte(18).lt(60));//大于等于18 并且小于60  !!!注意当对同一个属性进行操作时必须写在一起
        query.addCriteria(new Criteria().orOperator(Criteria.where("status").is(1), Criteria.where("status").is(2)));//状态等于2 或者 等于3
        query.with(Sort.by(new Sort.Order(Sort.Direction.DESC, "age"))); //按照age从大到小排
        Long count = testMapDao.queryByConditionsCount(query);
        query.skip((currPage-1 * pageSize));
        query.limit(pageSize);
        List<Map> queryByConditionResult = testMapDao.queryByConditions(query);
        System.out.println("高级查询结果总条数["+count+"]分页查询的排序后数据：");
        queryByConditionResult.forEach(System.out::println);
    }

    private List<Map> initData(){
        //准备测试数据
        List<Map> tempMapList = IntStream.range(0, 28).mapToObj(i -> {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("name", "我是map"+i);
            map1.put("age", 1 + (int)(Math.random()*100));
            map1.put("status", 1 + (int)(Math.random()*3));
            return map1;
        }).collect(Collectors.toList());
        return tempMapList;
    }
}

