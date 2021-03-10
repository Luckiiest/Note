public class Demo2{
	public static void main(String[] args){
		//数字金字塔                         空格   左边   右边
		//       1		i==1	3    1-1    0
		//     12  1	i==2	2    1-2    1-1
		//   123  21	i==3	1    1-3    2-1
		// 1234  321	i==4	0    1-4    3-1
		for(int i=1;i<=4;i++){//控制行数
			//空格占位
			for(int j=1;j<=4-i;j++){
				System.out.print(" ");
			}
			//左边数字   改变--利用变量  利用循环里层的变量j来控制  j++
			for(int j=1;j<=i;j++){
				System.out.print(j);
			}
			//右边数字   改变--利用j变量   j--
			for(int j=i-1;j>=1;j--){
				System.out.print(j);
			}
			//换行
			System.out.println();
		}
	}
}