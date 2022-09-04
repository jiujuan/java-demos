package org.basicdemo.reflectconstructor;

import java.lang.reflect.Constructor;

public class reflectconstructdemo1 {
    public static void main(String[] args) throws Exception {
        // 首先加载 Class 对象
        Class stuclz = Class.forName("org.basicdemo.reflectconstructor.student");

        // 获取所有公有(public)构造方法
        System.out.println("===========获取所有公有构造方法=========");
        Constructor[] consarr = stuclz.getConstructors();
        for(Constructor c : consarr) {
            System.out.println(c);
        }

        // 获取所有的权限(public,protected,private,default)的构造函数方法
        System.out.println("===========获取所有的构造方法=========");
        Constructor[] consall = stuclz.getDeclaredConstructors();
        for(Constructor c : consall) {
            System.out.println(c);
        }

        // 获取单个构造方法，公有无参的构造方法
        System.out.println("===========获取单个公有、无参数的构造方法=========");
        try {
            Constructor con = stuclz.getConstructor(null);
            System.out.println("con: " + con);

            // 调用
            //  Object obj = con.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 获取单个私有private构造方法
        System.out.println("===========获取单个私有private构造方法=========");
        Constructor con = stuclz.getDeclaredConstructor(int.class);
        System.out.println(con);
        // 调用设置能访问
        con.setAccessible(true); // 因为是私有，所以必须设置能访问
        // 创建 student 对象
        student stu = (student) con.newInstance(12);
        stu.setAge(13);
        System.out.println("age: "+stu.getAge());
    }
}
