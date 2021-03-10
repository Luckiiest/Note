public class Test1{
	//*1.给定两个数组a{1,2,3,4}  b{5,6,7,8} 将两个数组内的元素对应位置互换
	public static void main(String[] args){
		//1.创建两个数组
		int[] a = {1,2,3,4};
		int[] b = {5,6,7,8,9,0};
		//2.元素对应位置的互换  ----  每一次交换两个数字  换四次
		//方式二  直接交换变量a和b中的数组引用(地址) 没有循环一次搞定啦 不受长度限制
		int[] temp = a;
		a = b;
		b = temp;
		//方式一  交换数组中对应的元素(循环次数好多次 受长度的限制)
		/*for(int i=0;i<a.length;i++){//为了控制四次
			int x = a[i];
			a[i] = b[i];
			b[i] = x;
		}*/
		//3.分别输出两个数组元素看一看
		for(int v:a){
			System.out.println(v);
		}
		System.out.println("--------");
		for(int v:b){
			System.out.println(v);
		}
	}
}