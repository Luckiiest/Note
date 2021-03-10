public class Test{
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		//方式一 利用第三方空间
		//int c = a;
		//a = b;
		//b = c;
		//方式二  利用两个数字的和
		//a = a+b;
		//b = a-b;
		//a = a-b;
		//方式三  利用两个数字异或的中间值
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a);//2
		System.out.println(b);//1
	}
}