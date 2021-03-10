public class Test2{
	//2.给定一个数组a{1,2,3,4,5,6} 将这个数组中的元素头尾对应互换位置
	public static void main(String[] args){
		int[] array = {1,2,3,4};
		for(int i=0;i<array.length/2;i++){//控制交换的次数 数组长度的一半
			int x = array[i];
			array[i] = array[(array.length-1)-i];
			array[(array.length-1)-i] = x;
		}
		for(int v:array){
			System.out.println(v);
		}
	}
}