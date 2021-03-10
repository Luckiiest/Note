public class Test9{
	public static void main(String[] args){
		//int[] array = {5,2,3,1,4};
		//升序排列 --> {1,2,3,4,5} 本质元素位置互换  交换位置的条件
		//冒泡排序的算法
		int[] array = {5,2,3,1,4};
		for(int i=1;i<5;i++){//控制比较轮次  每一轮冒出来一个最小值
			for(int j=4;j>=i;j--){//从数组底端  一直比到顶端  4次
				if(array[j]<array[j-1]){
					int x = array[j];
					array[j] = array[j-1];
					array[j-1] = x;
				}
			}
		}
		for(int v:array){
			System.out.println(v);
		}
	}
}