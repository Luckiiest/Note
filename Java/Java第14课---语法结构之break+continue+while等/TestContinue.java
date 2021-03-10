public class TestContinue{
	public static void main(String[] args){
		int i=1;
		int j=1;
		for(;i<=5;i++){
			for(;j<=5;j++){
				if(j==3){
					continue;
				}
				System.out.println("拓哥真的很帅");
			}//i==1 j==6 输出4次  i==2   j==?开始数6  i==3 j==6
		}
		System.out.println(i);
		System.out.println(j);
		//循环执行过程中输出多少次  20 
		//循环执行完毕后   i6  j6







		/*
		for(int i=1;i<=5;i++){
			if(i==3){
				continue;//终断本次循环  继续执行下一次循环
			}
			System.out.println(i);
		}
		//执行过程中i输出  1245
		//执行循环完毕 最终i  6
		*/
	}
}