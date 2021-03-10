package ioc;

public class TestMain {

    public static void main(String[] args){
        //创建一个Question对象 对象的控制权交由别人处理 MySpring类  IOC
        MySpring spring = new MySpring();
        Person person = (Person)spring.getBean("ioc.Person");
        System.out.println(person);

//        Question question = (Question)spring.getBean("ioc.Question");
//        System.out.println(question);
    }
}
