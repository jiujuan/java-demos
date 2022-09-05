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
            System.out.println(f);
        }
    }
}
