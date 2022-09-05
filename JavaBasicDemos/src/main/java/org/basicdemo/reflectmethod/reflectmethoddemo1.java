package org.basicdemo.reflectmethod;

import java.lang.reflect.Method;

public class reflectmethoddemo1 {
    public static void main(String[] args) throws Exception {
        // 获取 Class 对象
        Class stuClz = Class.forName("org.basicdemo.reflectmethod.TomStudent");

        // 获取所有public method方法
        System.out.println("=============获取所有public method方法，包括继承父类的===============");
        Method[] methodArr = stuClz.getMethods();
        for(Method m:methodArr) {
            System.out.println(m); // 不仅打印出了 TomStudent 所有 public 方法，它继承的方法也打印出来
        }

        // 获取所有的方法包括private，但是此方法无法获取继承父类的method
        System.out.println("=======获取所有的方法包括private，但是此方法无法获取继承父类的method======");
        Method[]  methodsArr = stuClz.getDeclaredMethods();
        for(Method m:methodsArr) {
            System.out.println(m);
        }
        //输出：
        //=======获取所有的方法包括private，但是此方法无法获取继承父类的method======
        //private void org.basicdemo.reflectmethod.TomStudent.printName()
        //public int org.basicdemo.reflectmethod.TomStudent.getTomAge()

        // 根据参数获取public的方法，包含继承自父类的方法
        System.out.println("=======根据参数获取public的方法，包含继承自父类的方法======");
        Method method = stuClz.getMethod("setAge", int.class);
        System.out.println(method);
        // 反射调用方法
        Object obj = stuClz.newInstance();
        method.invoke(obj, 12);
        student stu = (student)obj;
        System.out.println(stu.getAge());

        // 根据参数获取方法，包括private，但是此方法无法获取继承父类的method
        System.out.println("=======根据参数获取方法，包括private，但是此方法无法获取继承父类的method======");
        Method method1 = stuClz.getDeclaredMethod("setTomAge", int.class);
        System.out.println(method);

        System.out.println("========用 invoke 调用 private 方法====");
        // 用 invoke 调用 private 方法
        Method privateMethod = stuClz.getDeclaredMethod("printName");
        System.out.println(privateMethod);
        privateMethod.setAccessible(true);
        privateMethod.invoke(obj);
    }
}
