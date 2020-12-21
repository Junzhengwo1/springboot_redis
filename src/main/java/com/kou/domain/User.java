package com.kou.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author JIAJUN KOU
 * 实体类必须序列化；否则无法传输
 *
 */
@Component
public class User implements Serializable {

    private String userName;
    private Integer age;

    public User() {
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
