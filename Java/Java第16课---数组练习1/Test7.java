public class Test7{
	//*7.给定一个数组a{1,2,3,0,0,4,5,0,6,0,7} 去掉数组中的0元素 (创建一个新数组 短的 非零元素挑出来)
	public static void main(String[] args){
		//1.需要一个数组
		int[] oldArray = new int[]{1,2,3,0,0,4,5,0,6,0,7};
		//2.找寻原数组中的非零元素个数--->才能确定新数组的长度
		int count = 0;//记录原数组中非零个数
		for(int i=0;i<oldArray.length;i++){
			if(oldArray[i]!=0){
				count++;
			}
		}
		System.out.println("原数组非零元素的个数:"+count);
		//3.创建一个新的数组 装原数组中的非零元素
		int[] newArray = new int[oldArray.length];//扩展思路二--->可以创建一个足够长的数组
		//4.将原数组中非零元素挑出来  存入新数组中
		int index = 0;//控制新数组的索引变化
		for(int i=0;i<oldArray.length;i++){
			if(oldArray[i]!=0){
				newArray[index++] = oldArray[i];
				//index++;
			}
		}
		//5.旧数组我觉得没有用啦  删掉
		oldArray = null;
		//5.验证新数组看一看
		for(int v:newArray){
			System.out.println(v);
		}
	}
}