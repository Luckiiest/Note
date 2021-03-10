import java.util.Scanner;

public class Demo1{
	public static void main(String[] args){
		//*******	画星星 换行		i==1        4-->7    5-->9
		//*** ***  画星星  画空格  画星星  换行	i==2    3   1   3
		//**    **  画星星  画空格  画星星  换行	i==3    2   3   2
		//*       *  画星星  画空格  画星星  换行	i==4    1   5   1
		//可读性 健壮性(严谨) 优化(结构 冗余 性能 内存 复用 扩展)  2*i-3
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入行数:");
		int line = input.nextInt();
		for(int i=1;i<=line;i++){//控制行数
			if(i==1){//第一行规则
				//画星星
				for(int j=1;j<=2*line-1;j++){
					System.out.print("*");
				}
			}else{//后三行规则
				//画星星
				for(int j=1;j<=(line+1)-i;j++){
					System.out.print("*");
				}
				//画空格
				for(int j=1;j<=2*i-3;j++){
					System.out.print(" ");
				}
				//画星星
				for(int j=1;j<=(line+1)-i;j++){
					System.out.print("*");
				}
			}
			//换行
			System.out.println();
		}
	}
}