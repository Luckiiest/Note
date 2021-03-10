package myselfannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MySpring {

    //设计一个方法  给一个类名字  返回一个对象  对象内的属性值存在着
    public Object getBean(String className){
        Object obj = null;//变量接收最终的对象
        try {
            //1.通过传递的className来获取对应的类Class
            Class clazz = Class.forName(className);//要求参数是一个类全名
            //2.通过clazz创建一个空的对象
            //obj = clazz.newInstance();
            Constructor con = clazz.getConstructor();//找到的是无参数的构造方法
            obj = con.newInstance();
            //3.创建对象以后 将对象内的所有属性自动赋值DI
            //  值-->文件  好处在于代码包装起来.jar不能修改 文件还可以修改
            //    .xml     不好在于开发的时候  源代码和配置文件不在一起  读取/修改比较麻烦
            //  值-->注解  好处在于开发的时候方便  源代码和注解在一起  读取/调整时候比较容易
            //     @       不好在于代码包装起来后  注解内携带的信息不能修改
            //4.首先获取属性的值---->类的无参数构造方法之上
            Annotation a = con.getAnnotation(MyAnnotation.class);
            //5.获取a注解对象内携带的信息--->person对象所有的属性值
            Class aclazz = a.getClass();
            Method amethod = aclazz.getMethod("value");
            String[] values = (String[])amethod.invoke(a);
            //6.将values中的每一个值 对应的赋给属性
            //  找寻属性对应的set方法赋值
            Field[] fields = clazz.getDeclaredFields();//获取全部的私有属性
            for(int i=0;i<fields.length;i++){
                //获取属性的名字
                String fieldName = fields[i].getName();
                //处理set方法的字符串
                String firstLetter = fieldName.substring(0,1).toUpperCase();
                String otherLetter = fieldName.substring(1);
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(firstLetter);
                setMethodName.append(otherLetter);
                //通过处理好的set方法名字找到对应的set方法
                Class fieldType = fields[i].getType();
                Method setMethod = clazz.getMethod(setMethodName.toString(),fieldType);
                //执行找到的set方法 给对应的属性赋值
                //需要将注解内读取到的String类型的值 转化成属性类型对应的值
                setMethod.invoke(obj,fieldType.getConstructor(String.class).newInstance(values[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
