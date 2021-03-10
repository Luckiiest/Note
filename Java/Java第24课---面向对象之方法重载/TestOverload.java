public class TestOverload {

    public void test(int...x){//本质数组  int[] x = {1,2,3,4,5,6};
        System.out.println("执行了test方法携带动态列表");
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
//    public void test(){
//        System.out.println("执行了test方法没有携带参数");
//    }
//    public void test(boolean b){
//        System.out.println("执行了test方法带boolean参数"+b);
//    }
//    public void test(char c){
//        System.out.println("执行了test方法带char参数"+c);
//    }
//    public void test(int i){
//        System.out.println("执行了test方法带int参数"+i);
//    }
//    public void test(String s){
//        System.out.println("执行了test方法带String参数"+s);
//    }


    public static void main(String[] args){
        //1.创建对象
        TestOverload to = new TestOverload();
        to.test(1,2,3,4);

//        to.test((char)99);//方法参数传递  类型之间的转化问题
        //通过对象.方法名字  调用方法   可以直接通过方法名字定位方法
        //如果方法名字一致   通过方法的参数列表类型 来定位方法
        //2.通过对象调用方法  方法执行一遍
        //to.test(true);//不传参数 不行     传参数 参数类型不匹配  不行

    }

}
