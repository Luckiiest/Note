public class ForDemoOne{
	public static void main(String[] args){
		for(int x = 100;x<200;x++){
			if(x%3==1 && x%4==2 && x%5==2){
				System.out.println("操场上的人数为:"+x);
			}
		}
	}
}