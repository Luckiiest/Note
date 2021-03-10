package myenum;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
//        MyDay myDay = MyDay.monday;//day类中访问了一个对象  7个
//
//        Day day = Day.monday;
        //day--->枚举类型的对象   默认继承Object
        //除了继承自Object类的方法外 还有一些  证明我们自己创建的enum类型 默认继承Enum
        //我们自己定义的每一个enum类型 都会默认继承Enum 间接继承Object

//        Day d = Day.valueOf("monday");
//        System.out.println(d.name()+"--"+d.ordinal());
//        Day[] days = Day.values();//获取所有的枚举对象
//        for(Day d:days){
//            System.out.println(d.name()+"--"+d.ordinal());
//        }

        //输入一个字符串monday  输出对应的信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个星期的英文单词:");
        String key = input.nextLine();
        Day day = Day.valueOf(key);//通过输入的英文单词找到了对应的枚举对象
        switch(day){
            case monday:
                System.out.println("您输入的是星期1");
                break;
            case tuesday:
                System.out.println("您输入的是星期2");
                break;
            case wednesday:
                System.out.println("您输入的是星期3");
                break;
            case thursday:
                System.out.println("您输入的是星期4");
                break;
            case friday:
                System.out.println("您输入的是星期5");
                break;
            case saturday:
                System.out.println("您输入的是星期6");
                break;
            case sunday:
                System.out.println("您输入的是星期7");
                break;
            default:
                System.out.println("出现错误");
        }

    }
}
