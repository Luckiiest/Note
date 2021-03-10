import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args){
        //利用数组实现用户的登录
        //1.有小数组来充当数据库
        //2.利用Scanner让用户输入
        Scanner input = new Scanner(System.in);
        //input这个小人在计算机中的消息队列内等着读取
        System.out.println("请输入密码");
        String password = input.nextLine();//阻塞效果
        //1.利用nextLine方法读取一个空回车符
        //input.nextLine();// ""
        //2.利用next方法读取字符串  next方法读取方式与nextInt一样 不读取回车符
        //3.将账号和密码都统一的用nextLine来读取
        //  String---->int
        //  int--->String   5+""
        //  数据类型转化的问题   前提 同种大数据类型一致 基本-基本  引用-引用
        //  基本<--包装类-->引用 int--Integer  char--Character  byte--Byte  float--Float
        int value = Integer.parseInt(password);//NumberFormatException
        System.out.println("请输入账号:");
        String name = input.nextLine();//阻塞效果 如果没有阻塞证明读取到东西了
        //  ""
        //3.比较
        System.out.println("接收到了账号:"+name);
        System.out.println("接收到了密码:"+value);

        System.out.println("10555");//10555
    }
}
