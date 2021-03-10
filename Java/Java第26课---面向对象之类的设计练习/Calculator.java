import java.util.Scanner;

public class Calculator {

    //设计一个方法  加法运算   是否需要提供条件  两个元素  是否需要结果  计算结果
    public float add(float a,float b){
        return a+b;
    }
    //设计一个方法  减法运算
    public float substact(float a,float b){
        return a-b;
    }
    //设计一个方法  乘法运算
    public float multiply(float a,float b){
        return a*b;
    }
    //设计一个方法  除法运算
    public float divide(float a,float b){
        return a/b;
    }

    //设计一个方法  控制计算器计算的流程
    public void calculate(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        String one = input.nextLine();//1
        float a = Float.parseFloat(one);//可能会产生NumberFormatException 1
        //需要一个死循环 while(true){}
        while(true) {
            System.out.println("请输入符号");
            String symbol = input.nextLine();//+ - =
            if(symbol.equals("=")){
                System.out.println("执行完毕");
                break;
            }
            if(!(symbol.equals("+")||symbol.equals("-")||symbol.equals("*")||symbol.equals("/"))){
                System.out.println("输入的符号有误,只能是[ + - * / = ]其中的一个");
                continue;
            }
            System.out.println("请输入第二个数字");
            String two = input.nextLine();//2 3
            //String--->float   Float
            float b = Float.parseFloat(two);
            switch (symbol) {
                case "+":
                    a = this.add(a, b);//第一次运行完毕的结果 存起来 当作第二次开始的a数字//3
                    break;
                case "-":
                    a = this.substact(a, b);
                    break;
                case "*":
                    a = this.multiply(a, b);
                    break;
                case "/":
                    a = this.divide(a, b);
                    break;
            }
            System.out.println(a);
        }
    }
}
