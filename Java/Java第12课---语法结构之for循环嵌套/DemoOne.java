public class DemoOne{
	public static void main(String[] args){
		//可读性  健壮性(严谨)  优化(结构 冗余 效率 内存 复用性 可扩展性)
		for(int x =45;x<95;x++){
			if((x-10) + (x+20) + (x/2) + (x*2) == 370){
				System.out.println("甲加工的零件数为:"+(x-10));
				System.out.println("乙加工的零件数为:"+(x+20));
				System.out.println("丙加工的零件数为:"+(x/2));
				System.out.println("丁加工的零件数为:"+(x*2));
			}
		}
	}
}