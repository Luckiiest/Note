import java.util.Scanner;

public class Test10{
	public static void main(String[] args){
		//1.需要数组来存储 所有的账号和密码(相当于小数据库)
		String[] userBox = {"郑中拓","渡一教育","Java"};
		int[] passwordBox = {123,666,888};
		//2.需要用户输入
		Scanner input = new Scanner(System.in);
		System.out.println("请输入账号:");
		String user = input.nextLine();//郑中拓
		System.out.println("请输入密码:");
		int password = input.nextInt();
		//3.比较
		boolean b = false;//标记
		for(int i=0;i<userBox.length;i++){
			if(userBox[i].equals(user)){//账号存在的
				if(passwordBox[i]==password){//密码正确的
					System.out.println("登录成功");//登录  登陆
					b = true;
				}
				break;
			}
		}
		if(!b){
			//用户名 或 密码 有一个不正确 需要输出
			//b标记的值与最初的一样不能改
			System.out.println("用户名或密码错误");
		}
	}
}





