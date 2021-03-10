package testlist;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args){
        //泛型不能使用基本类型---如果想要使用基本类型 需要使用其对应的包装类
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        list1.add(60);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(10);
        list2.add(20);
        list2.add(90);

        //事先准备好一个空的数组--->接受返回值
        Integer[] x = new Integer[list1.size()];
        list1.toArray(x);//参数
        System.out.println(x.length);

        //list1.addAll(list2);//并集
        //list1.removeAll(list2);//差集
        //list1.retainAll(list2);//交集
        //int value = list1.set(2,300);
        //System.out.println(list1);
        //System.out.println(value);
//        List<Integer> newList = list1.subList(2,4);
//        System.out.println(newList);

        //list2集合中的所有元素添加的到list1中
        //list1.addAll(2,list2);
        //list1.addAll(Collection<? extends E> list2)
        //将list2集合中的全部元素存入list1集合中
        //list1集合存在泛型  Integer
        //list2集合存在泛型  String
        //System.out.println(list1);

//        int index = list1.indexOf(100);
//        System.out.println(index);

        //ArrayList<String> --->"a" "b" "c";
        //String value = list.remove("a");
        //ArrayList<Integer> --> 1 2 3
        //   list.remove(1);--->  index==1    obj==1
        //   1参数默认看起来是一个基本类型   list.remove(new Integer(1))

//        boolean b = list1.contains("sss");
//        System.out.println(b);
//        list1.clear();
//        System.out.println(list1);






        //ArrayList 有序可重复
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
////        System.out.println(list);//list底层重写了toString方法
//        //集合的元素全部删掉
//        int size = list.size();//5
//        for(int i=0;i<size;i++){
//            list.remove(0);
//        }
        //i==0  size==5  abcde  //i==0  size==5  abcde
        //      bcde            //     bcde
        //i==1  size==4  bcde   //i==1  size==4  bcde
        //      bde             //     cde
        //i==2  size==3  bde    //i==2  size==3  cde
        //      bd              //     de
        //i==3  size==2         //i==3  size==2
//        System.out.println(list);//bd



//        System.out.println(list.size());//有效元素个数
////        System.out.println(list.get(6));//IndexOutOfBoundsException
//        for(int i=0;i<list.size();i++){
//            String value = list.get(i);
//            System.out.println(value);
//        }
    }
}
