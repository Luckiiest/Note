public class TestWhile{
	public static void main(String[] args){
		int i = 1;
		while(i<=4){
			//画空格占位
			int j = 1;
			while(j<=4-i){
				System.out.print(" ");
				j++;
			}
			//画星星
			int k = 1;
			while(k<=2*i-1){
				System.out.print("*");
				k++;
			}
			//换行
			System.out.println();
			i++;
		}














		/*
		int sum = 120;//表示水池中的水
		int hour = 0;//记录经过小时数 ?
		while(sum>0){
			sum+=18;
			sum-=30;
			hour++;//记录一次小时数
			System.out.println("本次循环完毕:"+sum);
		} 
		System.out.println("经过"+hour+"小时排水完毕");
		/*

		/*
		int i = 10;
		do{
			System.out.println("执行ing:"+i);//12345
			i++;
		}while(i<=5);
		*/

		/*
		int i = 10;
		while(i<=5){
			System.out.println("执行ing:"+i);//12345
			i++;
		}
		System.out.println("执行完毕:"+i);
		//执行输出什么? 执行完毕后 i==？
		*/
	}
}