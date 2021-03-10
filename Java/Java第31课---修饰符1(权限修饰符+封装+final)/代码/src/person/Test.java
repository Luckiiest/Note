package person;

public class Test {
    public static void main(String[] args){
        //创建类的过程是在Java中描述的过程
        //1.创建对象
        Person p = new Person();
        //2.对象的引用 . 调用属性
        p.name = "郑中拓";
        p.setAge(18);
        p.sex = "男";

        System.out.println("今年"+p.getAge());

    }
}
