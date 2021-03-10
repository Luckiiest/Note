package gc;

public class Test {
    public static void main(String[] args){
//        Person p = new Person();
//        try {
//            Thread.sleep(2000);
//        }catch(Exception e){
//
//        }
//        p = null;
//        System.gc();

        //1.抽象类 或者 接口  2.无参数的构造方法没有  3.构造方法私有(单例)
        Runtime r = Runtime.getRuntime();
        long max1 = r.maxMemory();
        long total1 = r.totalMemory();
        long free1 = r.freeMemory();
        System.out.println(max1);
        System.out.println(total1);
        System.out.println(free1);
        System.out.println("------------------");
        byte[] b = new byte[(int)(max1/2)];
        byte[] b2 = new byte[(int)(max1/2)];
        long max2 = r.maxMemory();
        long total2 = r.totalMemory();
        long free2 = r.freeMemory();
        System.out.println(max2);
        System.out.println(total2);
        System.out.println(free2);

    }
}
