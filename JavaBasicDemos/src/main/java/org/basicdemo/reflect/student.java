package org.basicdemo.reflect;

public class student {
    private String name = "Tom";
    private int age;

    public  student(){}

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
