import java.util.Scanner;

public class DemoOne{
	public static void main(String[] args){
		//1.创建一个变量 score 用来存储学生成绩
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个学生成绩,我来帮您判断区间");
		int score = input.nextInt();
		//2.利用成绩的值 来进行判断所在区间
		switch(score/10){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("悲催啦 不及格");
			break;
		case 6:
			System.out.println("欧耶 及格万岁");
			break;
		case 7:
			System.out.println("考得还行吧");
			break;
		case 8:
			System.out.println("就比较好啦 也拿不到奖学金");
			break;
		case 9:
			System.out.println("可以拿奖学金啦 请大家吃饭");
			break;
		case 10:
			if(score==100){
				System.out.println("学霸本ba");
				break;
			}
		default:
			System.out.println("没你这号人~~");
			break;
		}
	}
}