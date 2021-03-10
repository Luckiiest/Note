public class Test {

    public static void main(String[] args){
        //隐藏的过程  加载类
        //0.创建一个对象
        TestFunctions tf = new TestFunctions();

        int[] x = tf.findPrimeNum(100,10);
        for(int v:x){
            System.out.println(v);
        }


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
