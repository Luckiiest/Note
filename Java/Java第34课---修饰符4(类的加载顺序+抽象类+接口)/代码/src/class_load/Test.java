package class_load;

public class Test {
    public static void main(String[] args){
        //加载类的过程---静态元素已经加载
        Person p = new Person();
        p.hashCode();
        //1.加载父类
        //2.父类会产生自己的静态空间   属性 方法 块
        //      执行静态块
        //3.加载子类
        //4.子类会产生自己的静态空间   属性 方法 块
        //      执行静态块
        //--------------------------------------------------
        //5.开辟对象空间
        //6.加载父类的非静态成员   属性 方法 块 构造方法
        //7.    执行块  执行父类构造方法
        //8.加载子类的非静态成员   属性 方法 块 构造方法
        //9.    执行块  执行子类构造方法
        //10.将对象空间的地址引用交给 变量来存储
    }
}
