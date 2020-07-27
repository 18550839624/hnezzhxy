package com.iflytek.edu.model;

/**
 * @author 叶清
 * @create 2020-07-10-23:44
 **/
public class User {
    private Integer id;
    private String name;
    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public User(Integer id, String name, Integer sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public User() {
    }
}
