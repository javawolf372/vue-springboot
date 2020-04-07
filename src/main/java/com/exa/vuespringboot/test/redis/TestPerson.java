package com.exa.vuespringboot.test.redis;

import java.io.Serializable;

class TestPerson implements Serializable {
        private String name;
        private Integer age;
        private Double height;
        private String sex;

        //不加这个构造方法  查询的时候会报错
        public TestPerson() {
            super();
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
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    ", sex='" + sex + '\'' +
                    '}';
        }
}