public class Person extends Animal{

    public Person(){
        //隐藏一行代码 super();
        this(10);
        System.out.println("person中的无参数构造方法");
    }
    public Person(int a){
        super();
        System.out.println("person中的int参数构造方法");
    }

    //方法重写
    public void eat(){
        super.eat();
        this.study();
        System.out.println("人类的吃饭方法 讲究色香味俱全");
    }

    //添加一些独有的属性 或 方法
    public void study(){
        System.out.println("good good study,day day up");
    }
}
