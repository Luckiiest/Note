package class_load;

public class Animal {
    public String test = "AnimalField";
    public static String testStatic = "AnimalStaticField";

    public Animal(){
        System.out.println("我是animal中默认无参数的构造方法");
    }

    {
        this.test();
        System.out.println("我是animal中的普通代码块"+test);
    }
    static{
        Animal.testStatic();
        System.out.println("我是animal中的静态代码块"+testStatic);
    }

    public void test(){
        System.out.println("我是animal类中的普通方法");
    }
    public static void testStatic(){
        System.out.println("我是animal类中的静态方法");
    }
}
