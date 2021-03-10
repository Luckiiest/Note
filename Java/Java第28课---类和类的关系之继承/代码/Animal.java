public class Animal {

    public Animal(){
        System.out.println("animal中无参数的构造方法");
    }
    public Animal(int a){
        System.out.println("animal中的int参数构造方法");
    }

    public void eat(){
        System.out.println("动物的吃饭方法");
    }
    public void sleep(){
        //?动物吃饭   人类重写的吃饭
        //代替是当前调用方法时的那个对象  不一定是当前类
        System.out.println("动物的睡觉方法");
    }
}
