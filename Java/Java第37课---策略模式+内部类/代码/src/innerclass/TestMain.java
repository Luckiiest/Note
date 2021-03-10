package innerclass;
import innerclass.Demo.InnerDemo;
import innerclass.Demo.InnerDemoStatic;

public class TestMain {
    public static void main(String[] args){
        //内部类属于外部类的(相当于是一个成员) 需要外部类对象才能操作
        //创建内部类的对象---调用内部类的方法
        Demo demo = new Demo();
        InnerDemo innerDemo = demo.new InnerDemo();
        //调用内部类的方法
        innerDemo.testInnerDemo();

        //静态的成员内部类
        InnerDemoStatic ids = new InnerDemoStatic();
    }
}
