public class Test5{
	//5.给定两个数组a{1,2,3}  b{4,5} 合并两个数组 (创建一个新的数组5长度)
	public static void main(String[] args){
		//1.创建两个数组
		int[] a = {1,2,3};
		int[] b = {4,5};
		//2.因为数组长度一旦确定 不能再次改变  需要创建一个新的数组
		int[] newArray = new int[a.length+b.length];//只有长度 元素默认值0
		//3.思路二:想要将新数组填满
		for(int i=0;i<newArray.length;i++){
			if(i<a.length){//新数组的索引位置还没有a数组长度以外的范围
				newArray[i] = a[i];
			}else{
				newArray[i] = b[i-a.length];
			}
		}
		//3.思路一:分别将a和b数组中的元素存入新数组内
		/*
		for(int i=0;i<a.length;i++){//将所有a数组元素存入新数组内 
			newArray[i] = a[i];
		}//  newArray--->{1,2,3,0,0}
		for(int i=0;i<b.length;i++){//将b数组元素取出来 存入新数组后面位置
			newArray[a.length+i] = b[i];
		}//  newArray--->{1,2,3,4,5}
		*/
		//4.验证一下看一看
		for(int v:newArray){
			System.out.println(v);
		}
	}
}