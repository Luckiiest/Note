public class Test {
    //这个类没有什么现实意义
    //只是为了将主方法写在这里

    public static void main(String[] args){
        //想要在这里使用一个人 来执行操作
        //创建一个人类的对象  找一个空间来存储
        Person p = new Person();//p的小人 也有自己的名字 年龄 性别 有没有值???
        //通过对象. 去调用属性  存值/取值
        //属性是有默认值   name==null  age==0   sex==null
//        p.name = "郑中拓";
//        p.age = 18;
//        p.sex = "男";
//        Person p1 = p;//p1另外的一个小人  也有自己的 名字 年龄 性别
//        p1.name = "姬成小姐姐";
//        p1.age = 16;
//        p1.sex = "女";
        System.out.println(p.name+"今年"+p.age+"岁,性别是"+p.sex);
        //System.out.println(p1.name+"今年"+p1.age+"岁,性别是"+p1.sex);



    }
}
