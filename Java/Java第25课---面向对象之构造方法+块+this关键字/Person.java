public class Person {

    public String name;
    public int age;
    public String sex;

    public Person(){
        System.out.println("我是无参数的默认的构造方法");
    }
    public Person(String name,int age,String sex){
        this();
        System.out.println("我是带参数的构造方法");
        //创建了一个对象(开辟空间)
        this.name = name;//如果属性与变量重名?
        this.age = age;
        this.sex = sex;
        //返回了创建的这个对象空间的引用
    }

    {
        System.out.println("我也是一个块 哈哈");
    }
    {
        System.out.println("我是一个普通的程序块");
    }
    {
        System.out.println("我又是一个块");
    }

    // 权限修饰符 类名一致的方法名(参数列表)[异常]{方法体}
    // 只有这么一个特殊的方法 名字是大写字母
    // 少了结构 特征修饰符(没有) 返回值类型(结构没有)
//    public Person(){
//        System.out.println("我是Person类的构造方法");
//    }
//    public Person(String x){
//        System.out.println("我是带String参数的构造方法");
//    }

    public void est(){
        System.out.println("人类的吃饭方法");
    }
    public String tellName(){
        return "";
    }

}
