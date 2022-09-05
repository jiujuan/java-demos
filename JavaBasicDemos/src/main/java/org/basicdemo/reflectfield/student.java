package org.basicdemo.reflectfield;

public class student {
    private String name = "Tom";
    private int age;

    public String address;

    public int grade;

    protected String email;

    String phone;

    student(String name) {
        System.out.println("default constructor method: "+ name);
    }

    public student(){
        System.out.println("no args");
    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private student(int age) {
        System.out.println("(student)private construct-age: "+age);
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

    public String getName() {
        return name;
    }
}
