public class TestFor{
	public static void main(String[] args){
		int round=1;
		for( ; round<=5 ; round+=2){
			System.out.println("跑到第"+ round +"圈啦");//2 4 6
		}
		//循环执行完毕 round===6
		System.out.println("循环执行完毕:"+round);
		//变量的生命周期问题(变量 栈内存空间 从声明开始创建出来 用完及回收)
	}
}