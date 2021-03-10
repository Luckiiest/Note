package testreflect;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args){
        try {
            //通过一个Class对象来操作Person.class类文件
            Class clazz = Class.forName("testreflect.Person");
            Person p = (Person)clazz.newInstance();
            //通过clazz来获取类中的属性
            Field f = clazz.getDeclaredField("name");//name名字
            System.out.println(f.getName());
            f.setAccessible(true);//表示私有属性可以直接被操作
            f.set(p,"郑中拓");
            String value = (String)f.get(p);
            System.out.println(value);

//            Field[] fileds = clazz.getFields();
//            System.out.println(fileds.length);

//            Field nameField = clazz.getField("name");//知道属性名字是什么  属性是公有的
//            //赋值
//            nameField.set(p,"郑中拓");
//            //取值
//            String name = (String)nameField.get(p);
//            System.out.println(name);

            //自己的结构  赋值 取值
//            int modifiers = nameField.getModifiers();//属性的修饰符
//            System.out.println(modifiers);
//            Class fclass = nameField.getType();//获取属性的类型
//            System.out.println(fclass.getName());
//            String fname = nameField.getName();//获取属性名字
//            System.out.println(fname);//name




//            Person p = (Person)clazz.newInstance();//相当于调用person类中的默认无参数构造方法创建对象
//            System.out.println(p);

//            //类自己有结构   权限修饰符  特征修饰符  类名字   继承  实现
//            int modifiers = clazz.getModifiers();
//            System.out.println(modifiers);
//            //类的名字
//            String name = clazz.getName();
//            String simpleName = clazz.getSimpleName();
//            System.out.println(name);//类全名
//            System.out.println(simpleName);//类名
//            //获取类所在的包
//            Package p = clazz.getPackage();
//            System.out.println(p.getName());//获取包名
//            System.out.println("-------------");
//            //获取当前class的父类
//            Class sclass = clazz.getSuperclass();
//            System.out.println(sclass.getName());

//            ArrayList<String> list = new ArrayList<String>();
//            //获取集合对应的那个class
//            Class clazz = ArrayList.class;
//            Class sclazz = clazz.getSuperclass();
//            while(sclazz!=null){
//                System.out.println(sclazz.getName());
//                sclazz = sclazz.getSuperclass();
//            }

//            Class[] classes = clazz.getInterfaces();//获取当前clazz的所有父亲接口
//            for(Class c:classes){
//                System.out.println(c.getName());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
