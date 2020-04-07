package com.exa.vuespringboot.test.mongodb;

import java.io.Serializable;

public class TestPerson implements Serializable {

    private String id;
    private String name;
    private Integer age;
    private Double height;
    private String sex;

    public TestPerson() {
        super();
    }

    public TestPerson(String id){
        this.id = id;
    }

    public TestPerson(String name, Integer age, Double height, String sex) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "TestPerson{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}