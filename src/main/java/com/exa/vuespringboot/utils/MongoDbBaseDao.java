package com.exa.vuespringboot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Description: mongoDB基础方法封装
 */
public abstract class MongoDbBaseDao<T> {

    protected Logger logger = LoggerFactory.getLogger(MongoDbBaseDao.class);

    private static final String COLLECTION_NAME = "myCollection";

    /**
     * 反射获取泛型类型
     *
     * @return
     */
    protected abstract Class<T> getEntityClass();

    /**
     * 获取操作的collection名称
     *
     * @return
     */
    public String getConllectionName(){
        return COLLECTION_NAME;
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 删除所有
     */
    public void deleteAll(){
        this.mongoTemplate.dropCollection(getConllectionName());
    }

    /***
     * 新增
     * @param t
     */
    public T save(T t) {
        logger.info("-------------->MongoDB save start");
        return this.mongoTemplate.save(t, getConllectionName());
    }

    /**
     * 批量新增
     * @param list
     * @return
     */
    public List<T> batchToSave(List<T> list){
        return (List<T>) this.mongoTemplate.insert(list, getConllectionName());
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<T> queryAll() {
        logger.info("-------------->MongoDB findAll start");
        return mongoTemplate.findAll(this.getEntityClass(), getConllectionName());
    }


    /***
     * 根据id从集合中查询对象
     * @param id
     * @return
     */
    public T queryById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        logger.info("-------------->MongoDB find start");
        return this.mongoTemplate.findOne(query, this.getEntityClass(), getConllectionName());
    }

    /**
     * 根据条件查询集合
     *
     * @param object
     * @return
     */
    public List<T> queryList(T object) {
        Query query = getQueryByObject(object);
        logger.info("-------------->MongoDB find start");
        return mongoTemplate.find(query, this.getEntityClass(), getConllectionName());
    }

    /**
     * 根据自定义条件进行高级查询
     * @return
     */
    public List<T> queryByConditions(Query query){
        return mongoTemplate.find(query, this.getEntityClass(), getConllectionName());
    }

    /**
     * 根据自定义条件进行高级查询 返回集合总数
     * @return
     */
    public Long queryByConditionsCount(Query query){
        return mongoTemplate.count(query, this.getEntityClass(), getConllectionName());
    }

    /**
     * 根据条件查询只返回一个文档
     *
     * @param object
     * @return
     */
    public T queryOne(T object) {
        Query query = getQueryByObject(object);
        logger.info("-------------->MongoDB find start");
        return mongoTemplate.findOne(query, this.getEntityClass(), getConllectionName());
    }

    /***
     * 根据条件分页查询
     * @param object
     * @param start 查询起始值
     * @param size  查询大小
     * @return
     */
    public List<T> getPage(T object, int start, int size) {
        Query query = getQueryByObject(object);
        query.skip(start);
        query.limit(size);
        logger.info("-------------->MongoDB queryPage start");
        return this.mongoTemplate.find(query, this.getEntityClass(), getConllectionName());
    }

    /***
     * 根据条件分页查询
     * @param object
     * @param start 查询起始值
     * @param size  查询大小
     * @param sortMap key：排序字段  value: 排序类型
     * @return
     */
    public List<T> getPage(T object, int start, int size, Map<String, Sort.Direction> sortMap) {
        Query query = getQueryByObject(object);
        query.skip(start);
        query.limit(size);
        if (Objects.nonNull(sortMap)){
           query.with(getSort(sortMap));
        }
        logger.info("-------------->MongoDB queryPage start");
        return this.mongoTemplate.find(query, this.getEntityClass(), getConllectionName());
    }

    /***
     * 根据条件查询库中符合条件的记录数量
     * @param object
     * @return
     */
    public Long getCount(T object) {
        Query query = getQueryByObject(object);
        logger.info("-------------->MongoDB Count start");
        return this.mongoTemplate.count(query, this.getEntityClass(), getConllectionName());
    }

    /***
     * 删除对象
     * @param t
     * @return
     */
    public int delete(T t) {
        logger.info("-------------->MongoDB delete start");
        Query query = getQueryByObject(t);
        return (int) this.mongoTemplate.remove(query, getConllectionName()).getDeletedCount();
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    public void deleteById(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        if (null != criteria) {
            Query query = new Query(criteria);
            T obj = this.mongoTemplate.findOne(query, this.getEntityClass(), getConllectionName());
            logger.info("-------------->MongoDB deleteById start");
            if (obj != null) {
                this.delete(obj);
            }
        }
    }

    /*MongoDB中更新操作分为三种
    * 1：updateFirst     修改第一条
    * 2：updateMulti     修改所有匹配的记录
    * 3：upsert  修改时如果不存在则进行添加操作
    * */

    /**
     * 修改匹配到的第一条记录
     * @param srcObj
     * @param targetObj
     */
    public void updateFirst(T srcObj, T targetObj){
        Query query = getQueryByObject(srcObj);
        Update update = getUpdateByObject(targetObj);
        logger.info("-------------->MongoDB updateFirst start");
        this.mongoTemplate.updateFirst(query,update,this.getEntityClass(), getConllectionName());
    }

    /***
     * 修改匹配到的所有记录
     * @param srcObj  源数据
     * @param targetObj  需要修改的数据
     */
    public void updateMulti(T srcObj, T targetObj){
        Query query = getQueryByObject(srcObj);
        Update update = getUpdateByObject(targetObj);
        logger.info("-------------->MongoDB updateFirst start query["+query+"]，update["+update+"]");
        this.mongoTemplate.updateMulti(query,update,this.getEntityClass(), getConllectionName());
    }

    /***
     * 修改匹配到的记录，若不存在该记录则进行添加
     * @param srcObj
     * @param targetObj
     */
    public void updateInsert(T srcObj, T targetObj){
        Query query = getQueryByObject(srcObj);
        Update update = getUpdateByObject(targetObj);
        logger.info("-------------->MongoDB updateInsert start");
        this.mongoTemplate.upsert(query,update,this.getEntityClass(), getConllectionName());
    }

    /**
     * 将查询条件对象转换为query
     *
     * @param object
     * @return
     * @author Jason
     */
    private Query getQueryByObject(T object) {
        Query query = new Query();
        String[] fileds = (object instanceof Map) ? getMapFiledName((Map) object) : getFiledName(object);
        Criteria criteria = new Criteria();
        for (int i = 0; i < fileds.length; i++) {
            String filedName = (String) fileds[i];
            Object filedValue = (object instanceof Map) ? getFieldValueByKey(filedName, (Map) object) : getFieldValueByName(filedName, object);
            if (filedValue != null) {
                criteria.and(filedName).is(filedValue);
            }
        }
        query.addCriteria(criteria);
        return query;
    }

    /**
     * 将查询条件对象转换为update
     *
     * @param object
     * @return
     * @author Jason
     */
    private Update getUpdateByObject(T object) {
        Update update = new Update();
        String[] fileds = (object instanceof Map) ? getMapFiledName((Map) object) : getFiledName(object);
        for (int i = 0; i < fileds.length; i++) {
            String filedName = (String) fileds[i];
            Object filedValue = (object instanceof Map) ? getFieldValueByKey(filedName, (Map) object) : getFieldValueByName(filedName, object);
            if (filedValue != null) {
                update.set(filedName, filedValue);
            }
        }
        return update;
    }

    /***
     * 获取Map属性返回字符串数组
     * @param o
     * @return
     */
    private static String[] getMapFiledName(Map o) {
        return (String[]) o.keySet().stream().toArray(l -> new String[l]);
    }

    /***
     * 获取对象属性返回字符串数组
     * @param o
     * @return
     */
    private static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        Set<String> filedSet = Arrays.stream(fields).map(Field::getName).collect(Collectors.toSet());
        return filedSet.stream().toArray(l -> new String[l]);
    }

    /***
     * 根据属性获取对象属性值
     * @param fieldName
     * @param o
     * @return
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String e = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + e + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[0]);
            return method.invoke(o, new Object[0]);
        } catch (Exception var6) {
            return null;
        }
    }

    /***
     * 根据属性获取对象属性值
     * @param fieldName
     * @param o
     * @return
     */
    private static Object getFieldValueByKey(String fieldName, Map o) {
        try {
            return o.get(fieldName);
        } catch (Exception var6) {
            return null;
        }
    }

    private static Sort getSort(Map<String, Sort.Direction> sortMap){
        List<Sort.Order> orders = new ArrayList<>();
        for (String key: sortMap.keySet()){
            Sort.Order order = new Sort.Order(sortMap.get(key), key);
            orders.add(order);
        }
        return Sort.by(orders);
    }
}




















































































































































































































































