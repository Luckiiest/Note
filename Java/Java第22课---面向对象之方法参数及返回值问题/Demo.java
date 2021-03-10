/*这个类中所有的方法都是小练习*/
public class Demo {

    //设计一个方法  用来交换两个数组的元素
    //  方法本身是否需要参数及返回值   需要参数 提供两个数组  返回值 不要
    public int[][] changeTwoArray(int[] a,int[] b){
        //方式二  将两个数组的地址引用直接互换
        int[] temp = a;
        a = b;
        b = temp;
        int[][] result = {a,b};
        return result;
        //2.交换数组中的元素
        //方式一  将两个数组内的元素对应位置互换
//        for(int i=0;i<a.length;i++){//每一次找到一个数组中的元素 跟另一个数组对应位置
//            int x = a[i];
//            a[i] = b[i];
//            b[i] = x;
//        }
        //方式一的设计问题在于
        // 用循环的方式挨个交换数组内的元素 性能比较慢
        // 交换的时候需要保证两个数组的长度是一致的

    }


    public static void main(String[] args){
        //创建一个Demo对象
        Demo d = new Demo();
        //用来交换两个数组元素 a{1,2,3,4}  b{5,6,7,8}
        //1.先有两个数组
        int[] x = {1,2,3,4};
        int[] y = {5,6,7,8};
        //2.调用demo中的changeTwoArray方法
        int[][] value = d.changeTwoArray(x,y);
        x = value[0];
        y = value[1];
        //3.验证一下看一看
        for(int v:x){
            System.out.println(v);
        }
        System.out.println("-----------");
        for(int v:y){
            System.out.println(v);
        }
    }
}
