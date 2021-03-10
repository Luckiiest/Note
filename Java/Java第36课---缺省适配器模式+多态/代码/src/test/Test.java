package test;

public class Test {
    public static void main(String[] args){
        //1.创建对象
        //这个真是的老师 体现出来的身份是一个人的身份
//        Person p = new Teacher();//自动向上转型  Teacher--->Person
//        p.eat();
//        p.sleep();
//        p.talk();
//        //如果想要调用子类独有的属性或方法
//        //需要将类型还原会真实类型    强制类型转化  造型  向上转型  向下转型
//        Teacher t = (Teacher)p;
//        t.eat();
//        t.sleep();
//        t.talk();
//        t.teach();

        Object o = new Teacher();
        o.hashCode();
        o.toString();
        System.out.println("------------------------");
        Animal a = (Animal)o;
        a.hashCode();
        a.toString();
        System.out.println(a.name);//animal的name属性
        a.sleep();//没有重写  person重写了 person的sleep
        a.eat();//执行teacher的eat方法
        System.out.println("-----------------------");
        Person p = (Person)o;
        p.hashCode();
        System.out.println(p.name);//person的name属性
        p.sleep();//人类的睡觉
        p.eat();//老师的吃饭
        p.talk();//人类的说话
        System.out.println("----------------------");
        Teacher t = (Teacher)o;
        System.out.println(t.name);//老师的name
        t.eat();//老师的吃饭
        t.sleep();//人类睡觉
        t.talk();//人类说话
        t.teach();//老师的独有方法
        System.out.println("-------------------");
        if(o instanceof Person){//对象是否属于后面类型
            System.out.println("类型匹配  可以造型");
//            Student s = (Student)o;//运行时异常 ClassCastException
//            s.study();
        }else{
            System.out.println("对不起 类型不匹配 不帮您造型啦 否则会出问题");
        }

    }
}
