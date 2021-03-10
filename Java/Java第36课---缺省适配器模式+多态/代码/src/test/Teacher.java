package test;

public class Teacher extends Person{

    public String name = "teacher的name属性";
    public void eat(){
        System.out.println("做老师的通常不按时吃饭");
    }

    public void teach(){
        System.out.println("做老师的独有方法 一般人不会讲课 我会");
    }
}
