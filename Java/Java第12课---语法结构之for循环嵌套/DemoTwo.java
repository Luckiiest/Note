public class DemoTwo{
	public static void main(String[] args){
		for(int x=1;x<50;x++){
			if(x*2+(50-x)*4 ==160){
				System.out.println("小鸡的个数为:"+x);
				System.out.println("小兔子个数为:"+(50-x));
			}
		}
	}
}