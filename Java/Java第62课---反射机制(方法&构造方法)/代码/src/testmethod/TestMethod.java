package testmethod;

import java.lang.reflect.Method;

public class TestMethod {

    public static void main(String[] args){
        try {
            //获取Person对应的Class
            Class clazz = Person.class;
            Person p = (Person)clazz.newInstance();
            //通过clazz获取其中的方法
            Method m = clazz.getDeclaredMethod("testPrivate");
            System.out.println(m.getName());
            m.setAccessible(true);
            m.invoke(p);

//            Method m = clazz.getMethod("sleep");//找不到抛出异常
//            m.invoke(p);
//            Method[] ms = clazz.getMethods();//获取所有公有的方法(自己类+父类)

            //     通过方法名字定位方法   通过方法参数类型对应的Class来找寻
//            Method m = clazz.getMethod("eat",String.class);
//            String result = (String)m.invoke(p,"测试参数");
//            System.out.println(result);

//            int mm = m.getModifiers();//获取方法的修饰符(权限+特征)
//            Class mrt = m.getReturnType();//获取返回值数据类型
//            String mn = m.getName();//获取方法的名字
//            Class[] mpts = m.getParameterTypes();//获取方法参数列表的类型
//            Class[] mets = m.getExceptionTypes();//获取方法抛出异常的类型


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
