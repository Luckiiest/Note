public class Demo3{
	public static void main(String[] args){
		//打印输出9*9乘法表
		//1*1=1		表达式当做--?
		//1*2=2  2*2=4
		//1*3=3  2*3=6  3*3=9
		//   j  + "*" +   i + "=" +     j*i
		//被乘数  *  乘数  =  乘积
		//在一行之中  被乘数发生变化 j  乘数固定  i
		for(int i=1;i<=9;i++){//控制行数
			//画一个?
			for(int j=1;j<=i;j++){//控制每一行表达式的个数
				System.out.print(j+"*"+i+"="+(j*i)+"\t");
			}
			//换行
			System.out.println();
		}
	}
}