
import java.util.Scanner;

public class DiceGame{
	public static void main(String[] args){
		//1.随机摇骰子的过程   随机产生一个骰子点数  1-6整数
		//Math--->Scanner(1.import 2.new 3.input.next();)
		double value = Math.random();//有范围[0.0-1.0)  0.0----0.99999999
		int number = (int)(value*6+1);
		//2.让玩家猜测大小     大 小
		Scanner input = new Scanner(System.in);
		System.out.println("买大买小 买定离手");
		String choose = input.nextLine();//帮我们读取输入的文字
		//3.比较点数与猜测结果
		System.out.println("本次摇出的点数为:"+number);
		//   (点数1 2 3 同时 小) 或者 (点数4 5 6 同时 大)
		//   (number<=3 && choose.equals("小")) || (number>3 && choose.equals("大"))
		//   ==  equals();区别
		//   "a"=="b"   "a".equals("b");
		if((number<=3 && choose.equals("小")) || (number>3 && choose.equals("大"))){
			System.out.println("恭喜您 猜对啦");
		}else{
			System.out.println("对不起 猜错啦 给2块钱");
		}
	}
}