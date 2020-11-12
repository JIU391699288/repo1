package com.zl.bean;

import java.io.Serializable;


    public class User implements Serializable {
        private int id;
        private String name;
        private String sex;
        private int age;
        private String address;
        private String qq;
        private String email;

        public User() {
        }

        public User(int id, String name, String sex, int age, String address, String qq, String email) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.address = address;
            this.qq = qq;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", qq='" + qq + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
