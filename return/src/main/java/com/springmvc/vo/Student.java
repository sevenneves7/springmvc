package com.springmvc.vo;

//保存请求参数值的一个普通类
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("Student无参数构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName"+name);
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("setAge"+age);
    }
}
