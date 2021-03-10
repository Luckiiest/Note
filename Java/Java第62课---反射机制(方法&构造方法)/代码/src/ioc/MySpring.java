package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpring {

    //设计一个方法  帮我控制对象的创建
    //      是否需要参数? String 类全名
    //      是否需要返回值?  对象Object
    public Object getBean(String className){
        Object obj = null;
        Scanner input = new Scanner(System.in);
        System.out.println("请给"+className+"类的对象赋值");
        try {
            //获取方法传递进来的参数对应的类
            Class clazz = Class.forName(className);
            //通过clazz创建一个对象
            obj = clazz.newInstance();
            //在这里做一个自动DI注入  对象中的所有属性值  set
            //找到每一个不同对象中的所有set方法   给属性赋值
            //自己通过拼接字符串的方式处理名字
            //1.通过clazz找寻类中的所有私有属性--->获取每一个属性的名字--->set属性
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                //获取属性名
                String fieldName = field.getName();
                //2.手动的拼串儿  拼接属性对应的set方法名   setTitle  setAnswer
                String firstLetter = fieldName.substring(0,1).toUpperCase();//属性首字母变大写
                String otherLetters = fieldName.substring(1);//属性除了首字母之外的其他字母
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(firstLetter);
                setMethodName.append(otherLetters);
                //3.获取field对应的属性类型--->找寻set方法时候传递参数用
                Class fieldClass = field.getType();
                //4.通过处理好的set方法名 找寻类中的set方法
                Method setMethod = clazz.getMethod(setMethodName.toString(),fieldClass);
                //5.找到的setMethod一执行  属性就赋值成功
                System.out.println("请给"+fieldName+"属性提供值");
                String value = input.nextLine();
                //需要执行属性对应的set方法 给属性赋值 方法就结束啦
                //属性的值现在接收过来 (Scanner 文件内读取) 全都是String类型
                //执行set方法的时候 方法需要的值不一定都是String类型  Integer Float ... 属性类型的值
                //如何将所有的String类型的值--->转化成属性类型的值
                //Integer包装类  八个包装类有七个都含有带String的构造方法
                //  new Integer(String) new Float(String)  new String(String)
                //可以利用包装类带String的构造方法处理  属性类型对应的带String参数的构造方法
                Constructor con = fieldClass.getConstructor(String.class);
                setMethod.invoke(obj,con.newInstance(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
