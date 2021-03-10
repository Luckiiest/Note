public class SaveNum{
	public static void main(String[] args){
		//1.需要创建一个数组
		int[] array = new int[50];//有长度  元素没有(默认值)
		//2.需要将1-100之间的偶数存入数组内
		for(int i=0;i<array.length;i++){//执行50次  从几数都可以  觉得从0开始数比较方便
			array[i] = 2*i+2;
		}
		//3.输出验证看一看
		for(int v:array){
			System.out.println(v);
		}
	}
}