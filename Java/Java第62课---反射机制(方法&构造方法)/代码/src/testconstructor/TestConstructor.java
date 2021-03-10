package testconstructor;

import java.lang.reflect.Constructor;

public class TestConstructor {

    public static void main(String[] args){
        try {
            //找到person对应的class
            Class clazz = Person.class;

//            Constructor[] cons = clazz.getConstructors();
//            clazz.getDeclaredConstructor();
//            clazz.getDeclaredConstructors();

//            clazz.newInstance();
            //找寻clazz中的无参数构造方法
            Constructor con = clazz.getConstructor(String.class);
            con.setAccessible(true);
//
//            con.getModifiers();
//            con.getName();
//            con.getParameterTypes();
//            con.getExceptionTypes();
//
//            //执行构造方法
//            Person p = (Person)con.newInstance("name");
//            System.out.println(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
