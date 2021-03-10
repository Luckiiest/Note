package test;

public class Student extends Person {

    public String name = "student的name属性";

    public void talk(){
        System.out.println("学生遵守礼貌 应该好好说话");
    }
    public void study(){
        System.out.println("好好学习 天天向上");
    }
}
