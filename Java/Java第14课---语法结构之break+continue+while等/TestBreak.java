public class TestBreak{
	public static void main(String[] args){
		int i = 1;
		int j = 1;
		for(;i<=5;i++){
			for(;j<=5;j++){
				if(j==3){
					break;
				}
				System.out.println("拓哥很帅");
			}//i==1   j==3  执行两次输出   i==2  j==?从几开始数?3  i==3  j==3
		}
		System.out.println(i);//6
		System.out.println(j);//3
		//循环执行了多少次10   拓哥很帅输出了多少次
		//循环执行完毕   i6   j3分别是几?

		/*
		for(int i=1;i<=5;i++){
			if(i==3){
				break;//终止 终断 //当满足if条件的时候 终断循环
			}
			System.out.println(i);
		}
		//执行的结果是什么?  12
		//执行完毕后   i的值应该是几? 3
		*/
	}
}