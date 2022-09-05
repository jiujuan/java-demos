package org.basicdemo.reflectfield;

import java.lang.reflect.Field;

public class reflectfielddemo1 {
    public static void main(String[] args) throws Exception {
        // 获取 Class 对象
        Class stuClz = Class.forName("org.basicdemo.reflectfield.student");

        // 获取所有 public 权限的字段
        System.out.println("==========获取所有 public 权限的字段===========");
        Field[] fieldArr = stuClz.getFields();
        for(Field f : fieldArr) {
            System.out.println(f+" - ("+f.getDeclaringClass() +") - ("+f.getName()+":"+f.getType()+")");
        }

        // 获取所有权限的字段，包括private
        System.out.println("==========获取所有权限的字段，包括private===========");
        Field[] fieldsArr = stuClz.getDeclaredFields();
        for(Field f : fieldsArr) {
            System.out.println(f);
        }

        // 根据名字获取单个public字段
        System.out.println("===========根据名字获取public字段============");
        Field addressField = stuClz.getField("address");
        System.out.println(addressField);
        // 根据反射来设置下这个字段
        Object obj = stuClz.getConstructor().newInstance();
        // 用 set 方法来设置字段的值
        addressField.set(obj, "setTestValue");
        // 打印设置的值
        student stu = (student) obj;
        System.out.println("print address value: " + stu.address);

        // 根据名字获取某个字段，字段权限包括所有，也包括private
        System.out.println("=========根据名字获取某个字段，字段权限包括所有，也包括private=======");
        // 来获取一个 private 字段
        Field nameField = stuClz.getDeclaredField("name");
        System.out.println(nameField);
        // 没有设置前的name值
        System.out.println("name value before setting: "+stu.getName());
        // 来设置值
        nameField.setAccessible(true); // 因为是private，所以先要设置可写。相当于打开一个开关，原本是不可以写的。
        nameField.set(obj, "jimmy");
        System.out.println("name value after setting: " + stu.getName());
    }
}
