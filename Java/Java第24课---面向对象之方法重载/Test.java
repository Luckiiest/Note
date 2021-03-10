import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        //隐藏的过程  加载类
        //0.创建一个对象
        TestFunctions tf = new TestFunctions();
        //实现一个用户的登录认证
        //2.用户输入自己登录的账号和密码
        Scanner input = new Scanner(System.in);
        //3.提示用户输入账号和密码
        System.out.println("请输入账号:");
        String user = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        //4.tf对象调用方法  方法执行登录判断
        String result = tf.login(user,password);
        System.out.println(result);


        //冒泡排序算法 (从数组的底端每一次冒出一个值)
//        int[] x = new int[]{5,3,4,2,1,8,7,6,9,0,2,3,4,5};
//        //调用刚才定义好的排序方法  执行一遍
//        tf.orderArray(x,false);
//        for(int v:x){
//            System.out.println(v);
//        }

        //找素数
//        int[] x = tf.findPrimeNum(100,10);
//        for(int v:x){
//            System.out.println(v);
//        }


        //找寻给定元素是否在数组中存在
//        int[] x = new int[]{1,2,3,4,5,6};
//        String result = tf.isExist(x,14);
//        System.out.println(result);

        //找寻最大值或最小值
//        //1.有一个数组
//        int[] array = new int[]{1,3,5,7,9,0,8,6,4,2};
//        //2.调用tf中的方法  做事
//        int result = tf.findMaxOrMinNum(array,false);//array数组中找寻最大值
//        //4.验证一下
//        System.out.println("数组中的最大值为:"+result);


        //交换数组内部元素
//        //1.有一个数组
//        int[] x = new int[]{1,2,3,4,5,6,7,8,9};
//        //2.利用tf对象调用方法执行操作
//        tf.changeArrayElements(x);//x--->array
//        //3.验证看一看结果
//        for(int v:x){
//            System.out.println(v);
//        }
    }

}
