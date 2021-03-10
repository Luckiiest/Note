package testlist;

import java.util.Stack;
import java.util.Vector;

public class TestVector {
    public static void main(String[] args){
//        Vector<String> vector = new Vector<String>(4,4);
//        for(int i=1;i<=22;i++){
//            vector.add("a");
//            System.out.println(vector.size()+"--"+vector.capacity());
//            //有效元素个数       底层真实数组的容量
//        }

        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
        System.out.println(stack.peek());//c
        System.out.println(stack);
        System.out.println(stack.search("b"));//不是索引 是第几个
    }
}
