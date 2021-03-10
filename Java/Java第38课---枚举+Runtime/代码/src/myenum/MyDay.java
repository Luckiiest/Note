package myenum;

public class MyDay {//描述星期  7个

    //类似单例模式的想法
    //构造方法私有
    private MyDay(){}
    //所有对象都是属性
    public static final MyDay monday = new MyDay();
    public static final MyDay tuesday = new MyDay();
    public static final MyDay wednesday = new MyDay();
    public static final MyDay thursday = new MyDay();
    public static final MyDay firday = new MyDay();
    public static final MyDay saturday = new MyDay();
    public static final MyDay sunday = new MyDay();

    //一般属性 一般方法随便设计
}
