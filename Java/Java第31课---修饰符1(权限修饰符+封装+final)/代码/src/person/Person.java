package person;

public class Person {

    //属性
    public String name;
    private int age;
    public String sex;

    //方法
    //设计一个方法  用来取得age属性的值
    //   提供条件?不需要   返回值? 获取的age的值
    public int getAge(){
        //if
        return this.age;
    }
    //设计一个方法  用来给age属性赋值
    //   提供条件?  age的值    返回值?void
    public void setAge(int age){
        if(age<0){
            System.out.println("对不起 您还没出生呢 请给正确的年龄范围");
            this.age = -1000;
            //抛出异常
        }else if(age>130){
            System.out.println("对不起 您已经升仙啦 请给正确的年龄范围");
            this.age = -1000;
            //抛出异常
        }else {
            this.age = age;
        }
    }
}
