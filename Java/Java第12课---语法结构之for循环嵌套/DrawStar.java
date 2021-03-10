import java.util.Scanner;

public class DrawStar{
	public static void main(String[] args){
		for(int i=1;i<=4;i++){//控制四行
			//画占位符
			for(int j=1;j<=4-i;j++){
				System.out.print(" ");
			}
			//画星星
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			//换行
			System.out.println();
		}
		




		/*for(int i=1;i<=4;i++){//控制四行
			//画星星
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			//换行
			System.out.println();
		}*/
		//i==5  5<=4  
		//	j==1  j<=3
		//	*
		//	**
		//	***
		//	****
		//	|



		/*
		int count = 4;//每一行星星的个数随意
		for(int i=1;i<=4;i++){
			for(int j=1;j<=count;j++){
				System.out.print("*");
			}
			System.out.println();
		}//让计算机帮我们做4次一样的事情
		//i j分别控制着什么?    i控制的是行数  j控制的是每一行星星的个数
		//双层循环嵌套执行的次数是乘机的关系
		//   i==5   5<=4 false
		//           j==5  5<=4 true
		//	****
		//             ****
		//             ****
		//             ****
		//             |
		*/


		//复用性
		/*System.out.println("尊敬的客户,您到底要画几个?");
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		for(int i=1;i<=count;i++){
			System.out.print("*");
		}*/
	}
}