public class TestArray{
	public static void main(String[] args){
		int a = 10;
		int b = a;
		b = 100;
		System.out.println(a);//?  10

		int[] x = new int[]{10,20,30};//拓哥x 记录一个教室号码  3个同学  小拓y  教室里第一个同学罚站
		//栈内存中的小容器  类型定义了只能存储这种东西  容器中只能存一份
		//见到new关键字  相当于 在堆内存中申请开辟一块新的空间
		//数组在堆内存的空间形态  是一串连续的地址
		//基本类型变量空间存储的是值  传递的就是值   一个改变 另一个不变
		//引用类型变量空间存储的是地址(引用)  传递的就是引用  一个改变 另一个跟着改变
		int[] y = x;
		y[0] = 100;
		System.out.println(x[0]);//?   100



		/*
		//NegativeArraySizeException 运行时异常 创建数组的时候长度给了负数 数组的长度不合法
		int[] array = new int[5];
		array[0] = 10;
		array[1] = 20;
		array[5] = 100;//ArrayIndexOutOfBoundsException
		*/

		//int[] array = new int[]{10,20,30,40,50};
		//通过元素在数组中的位置index(索引 下标)来访问
		//array[index];
		//从数组内取得某一个位置的元素
		//int value = array[4];
		//System.out.println(value);
		//向数组内的某一个位置存入元素
		//array[3] = 400;
		//索引有范围的

		//int value = array[5];
		//System.out.println(value);
		//异常---运行时异常
		//ArrayIndexOutOfBoundsException  数组索引越界
		//index索引    0开始-----数组(长度-1)结束

		//将数组中的每一个元素都拿出来看一看
		/*
		for(int index=0;index<5;index++){//每一次做一样的事情  取数组的值  5次
			int value = array[index];
			System.out.println(value);
		}
		System.out.println("-----我是一个华丽的分隔符-----");
		for(int value : array){
			value = 100;
			System.out.println(value);
		}
		*/
	}
}