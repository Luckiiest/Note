import java.util.Scanner;

public class DemoTwo{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入一个星期，我来帮您指定学习计划");
		int day = input.nextInt();
		switch(day){
		case 1:
		case 3:
		case 5:
			System.out.println("应该学习编程");
			break;
		case 2:
		case 4:
		case 6:
			System.out.println("应该学习英文");
			break;
		case 7:
			System.out.println("玩儿?想得美，用英文编程序");
			break;
		default:
			System.out.println("想要逃离这七天么?不存在的，好好学习");
			break;
		}
	}
}