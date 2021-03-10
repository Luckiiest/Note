public class TestBreakAndContinue{
	public static void main(String[] args){
		int i=1;
		int j=1;
		ok:for(;i<=5;i++){
			ko:for(;j<=5;j++){
				if(j==3){
					continue ok;
				}//j==3停住一次 继续下一次i++  i=2
				System.out.println("拓哥再帅一次");
			}
		}
		//执行输出多少次10   执行完毕 i6  j3?
		System.out.println(i);
		System.out.println(j);



		/*
		int i=1;
		int j=1;
		ok:for(;i<=5;i++){
			ko:for(;j<=5;j++){
				if(j==3){
					break ok;
				}
				System.out.println("拓哥就是很帅");
			}
		}
		System.out.println(i);
		System.out.println(j);
		//输出几次2    i j分别是几?1  3
		//break为什么终断是里层循环?    不看层次问题    两个循环一模一样
		//如果j==3时候   break终断外面的循环----???   给循环起名字  循环标记
		*/
	}
}