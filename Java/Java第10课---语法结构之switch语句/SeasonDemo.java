import java.util.Scanner;

public class SeasonDemo{
	public static void main(String[] args){
		//1.创建一个month变量 用来存储一个月份值(Scanner)
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个月份，我来帮您判断所属的季节");
		int month = input.nextInt();//帮我们读取输入的数字   input.nextLine();读取字符串
		//2.通过month存储的值 进行季节的判断
		if(month<1 || month>12){
			System.out.println("您输入的数字不符合月份 数据有误");
		}else if(month>=3 && month<=5){
			System.out.println("春天");
		}else if(month>=9 && month<=11){
			System.out.println("秋天");
		}else if(month>=6 && month<=8){
			System.out.println("夏天");
		}else{
			System.out.println("冬天");
		}
	}
}
