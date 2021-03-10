public class TestArray{
	public static void main(String[] args){

		System.out.println(args.length);//长度
		for(String value : args){
			System.out.println(value);
		}


		/*
		int[][] array = new int[3][2];
		array[0][0] = 10;
		array[0][1] = 20;
		array[1] = array[0];
		array[0] = new int[4];
		array[0][0] = 100;
		System.out.println(array[1][0]);//?   10
		*/
		
		//二维数组的动态初始化
		//int[][] array = new int[3][];//{{0,0},{0,0},{0,0}}
		//array[0] = new int[2];
		//array[0][0] = 10;
		//array[0][1] = 20;
		//array[0][2] = 30;//运行时异常ArrayIndexOutOfBoundsException

		/*
		//声明----初始化(静态)
		int[][] array = new int[][]{{1,2},{3,4,5,6},{7,8,9}};
		//访问数组内的元素---index
		//int value = array[0][0];//前面表示小数组位置  后面表示小数组中元素的位置
		//System.out.println(value);//1   array[1][2];//5   array[2][2];//9
		//数组的遍历/轮询
		for(int i=0;i<array.length;i++){//遍历大数组中的小数组
			for(int j=0;j<array[i].length;j++){//遍历每一个小数组中的元素
				int value = array[i][j];
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		System.out.println("-------------");
		for(int[] arr : array){
			for(int value : arr){
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		*/
	}
}