package testlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestLinked {

    public static void main(String[] args){
        //LinkedList  200000次为例
        //向后追加元素  4
        //向前插入元素  4
        //遍历轮询元素  4
//        LinkedList<String> linkeList = new LinkedList<String>();
//        for(int i=1;i<=200000;i++){
//            linkeList.addFirst("a");
//        }
//        long time1 = System.currentTimeMillis();
//        for(int i=1;i<=200000;i++){
//            linkeList.removeFirst();
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);


        //ArrayList  200000次为例
        //向后追加元素5
        //向前插入元素4005
        //遍历轮询元素3
        //删除元素时间4037
//        ArrayList<String> arrayList = new ArrayList<String>();
//        for(int i=1;i<=200000;i++){
//            arrayList.add("a");
//        }//有200000个
//        long time1 = System.currentTimeMillis();
//        for(int i=0;i<200000;i++){
//            arrayList.remove(0);
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println("arraylist向前插入元素时间"+(time2-time1));


    }
}
