package com.jj.testDataBinding.data;

public class User {

    private static int idIndex = 0;

    public int id;
    private String name;
    private int age;

    public User() {
        id = idIndex ++;
    }

    public User(String name, int age) {
        id = idIndex ++;
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
