import java.util.Scanner;

public class TestSwitch{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入一个数字，我来帮您输出对应的星期");
		int day = input.nextInt();
		switch(day){
		case 1:
			System.out.println("monday");
			break;
		case 2:
			System.out.println("tuesday");
			break;
		case 3:
			System.out.println("wednesday");
			break;
		case 4:
			System.out.println("thursday");
			break;
		case 5:
			System.out.println("friday");
			break;
		case 6:
			System.out.println("saturday");
			break;
		case 7:
			System.out.println("sunday");
			break;
		default:
			System.out.println("error");
			break;
		}
	}
}