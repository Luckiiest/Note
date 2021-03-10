public class Test8{
	//8.创建一个数组 存储2-100之间的素数(质数)
	public static void main(String[] args){
		//思路一:空间占用小  执行效率慢
		//0.通过一个几千次循环找寻一个---count
		//1.创建一个数组  长度(刚好的 没有一个空间多余)
		//2.通过一个几千次循环找寻素数  将素数存入数组内

		//思路二:执行效率高 空间占用大
		//0.创建一个足够长的数组
		//1.通过几千次循环找素数  将素数存入数组内
		//2.将存入素数的数组  后面部分0元素去掉


		int[] primeNumberArray = new int[50];
		int index = 0;//记录素数数组索引变化   同时记录素数的个数
		for(int num=2;num<=100;num++){
			boolean b = false;//标识  用来记录最初的状态
			for(int i=2;i<=num/2;i++){//从2--8之间找寻还有没有其他可以整出的数字
				if(num%i==0){//如果还有能整出的数字 证明num不是素数
					//System.out.println(num+"不是素数");
					b = true;//如果满足条件(找到整除 证明不是素数 改变标识)
					break;
				}
			}
			if(!b){//如果标识与最初的一致 证明循环内的if从来没有执行过  !b <===> b==false
				//System.out.println(num+"是素数");
				primeNumberArray[index++] = num;				
			}
		}//{2,3,5,7,11,13,17,19,23,29...........0,0,0,0,0,0,0,0,0}
		int[] newArray = new int[index];
		for(int i=0;i<newArray.length;i++){
			newArray[i] = primeNumberArray[i];
		}
		primeNumberArray = null;//
		for(int v:newArray){
			System.out.println(v);
		}

		/*
		//0.找寻2-100之间素数的个数--->确定数组的长度
		int count = 0;//用来记录素数的个数
		for(int num=2;num<=100;num++){
			boolean b = false;//标识  用来记录最初的状态
			for(int i=2;i<=num/2;i++){//从2--8之间找寻还有没有其他可以整出的数字
				if(num%i==0){//如果还有能整出的数字 证明num不是素数
					//System.out.println(num+"不是素数");
					b = true;//如果满足条件(找到整除 证明不是素数 改变标识)
					break;
				}
			}
			if(!b){//如果标识与最初的一致 证明循环内的if从来没有执行过  !b <===> b==false
				//System.out.println(num+"是素数");
				count++;
				
			}
		}
		System.out.println("经过找寻,2-100之间素数的个数为:"+count);
		//1.创建一个数组  存素数
		int[] primeNumberArray = new int[count];
		//2.找寻2-100之间的素数  将找到的素数存入数组内
		int index = 0;//创建一个新的变量  记录素数数组的索引变化
		for(int num=2;num<=100;num++){
			boolean b = false;//标识  用来记录最初的状态
			for(int i=2;i<=num/2;i++){//从2--8之间找寻还有没有其他可以整出的数字
				if(num%i==0){//如果还有能整出的数字 证明num不是素数
					//System.out.println(num+"不是素数");
					b = true;//如果满足条件(找到整除 证明不是素数 改变标识)
					break;
				}
			}
			if(!b){//如果标识与最初的一致 证明循环内的if从来没有执行过  !b <===> b==false
				//System.out.println(num+"是素数");
				primeNumberArray[index++] = num;
			}
		}
		//3.输出最终的数组验证一下
		for(int v:primeNumberArray){
			System.out.println(v);
		}

		*/
	}
}