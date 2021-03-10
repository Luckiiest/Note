package testreflect;

import java.lang.reflect.Field;

public class ChangeStringValue {

    public static void main(String[] args) throws Exception {
        String str = new String("abc");
        System.out.println(str);
        //反射的技术可以获取私有属性  可以操作私有属性  虽然很不合理
        //1.获取String类对应的那个class
        Class clazz = str.getClass();
        //2.通过clazz获取类中的value属性
        Field field = clazz.getDeclaredField("value");
        //3.直接操作属性的值不可以  设置私有属性可以被操作
        field.setAccessible(true);
        //4.获取value属性里面的值(内存地址)
        //private final char[] value = {'a','b','c'};
        char[] temp = (char[])field.get(str);
        //通过temp的地址引用 找到真实String对象中的数组 修改数组内每一个元素
        temp[0]='郑';temp[1]='中';temp[2]='拓';
        //最终输出一个str的值
        System.out.println(str);
    }
}
