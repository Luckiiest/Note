package test;

public class Person extends Animal{

    public String name = "person的name属性";

    public void eat(){
        System.out.println("person的吃饭方法");
    }
    public void sleep(){
        System.out.println("人类的睡觉方法");
    }
    public void talk(){
        System.out.println("人类的说话方法");
    }
}
