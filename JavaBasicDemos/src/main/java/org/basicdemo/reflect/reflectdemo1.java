package org.basicdemo.reflect;

public class reflectdemo1 {
    public static void main(String[] args) {
        try {
            Class<?> stuclz1 = Class.forName("org.basicdemo.reflect.student");
            System.out.println("Class.forName: " + stuclz1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        student stu = new student();
        Class stuclz2 = stu.getClass();
        System.out.println("对象.getClass(): " + stuclz2);

        Class stuclz3 = student.class;
        System.out.println("类名.class: " + stuclz3);
    }
}
