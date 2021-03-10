public class Test {

    public static void main(String[] args){
        //调用Person类中的构造方法
        //建议大家 以后若自己定义带参数的构造方法
        //         将系统提供的默认无参数构造方法也一起写出来 构成 构造方法的重载
        Person p = new Person("郑中拓",18,"男");//结构上没有返回值类型  有返回值 对象
        System.out.println(p.name+"今年"+p.age+"性别是"+p.sex);
    }
}
