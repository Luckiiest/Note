public class Person {

    public String name;
    public int age;
    public String sex;

    public Person(){
        System.out.println("我是人类的构造方法");
    }
    public Person(int a){
        System.out.println("我是人类带int参数的构造方法");
    }


    public void eat(){
        this.sleep();
        System.out.println("这是人类的吃饭方法");
    }
    public void sleep(){
        this.eat();
        System.out.println("这是人类的睡觉方法");
    }

}
