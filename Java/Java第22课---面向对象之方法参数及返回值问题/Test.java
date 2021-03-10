public class Test {

    public int changeNum(int x){
        System.out.println("方法执行开始:"+x);//1
        x = 10;//修改传递进来的值
        System.out.println("方法执行最终:"+x);//10
        return x ;//返回值 将x临时的变量空间内的值(值 引用)返回出来
    }
    public void changeArray(int[] x){
        System.out.println("方法执行开始:"+x[0]);//1
        x[0] = 10;//修改数组x的第一个位置元素
        System.out.println("方法执行最终:"+x[0]);//10
    }

    //每一个类中不是必须包含主方法的
    //主方法不属于任何一个类--主方法属于虚拟机
    public static void main(String[] args){
        //0.加载类模板的过程
        Test t = new Test();
        int[] a = new int[]{1,2,3};
        t.changeArray(a);
        //方法存在堆内存的对象空间里 方法执行在栈内存中的临时空间
        //调用方法时将a的值传递给了x    int[] x = a;  传递过来的就是一个 引用
        System.out.println("方法执行完毕,main方法中a数组的第一个值:"+a[0]);//10

        //形参和实参
        //形参可以理解为是方法执行时的临时变量空间  x
        //实参可以理解为是方法调用时传递进去的参数  a
        //方法调用时会将实参的内容传递给形参
        //如果内容是基本类型  传递的 是值    形参改变  实参不变
        //如果内容是引用类型  传递的 是引用  形参改变  实参跟着改变

//        //创建一个对象---前提 有一个类模型
//        //0.加载类模板的过程
//        Test t = new Test();//堆内存中开辟空间
//        int a = 1;
//        a = t.changeNum(a);//需要一个int的条件  int x = a;
//        //调用方法  让方法执行一遍
//        //1.方法存在哪里?  堆内存的对象空间内
//        //2.方法在哪里执行的?  栈内存中开辟一块临时的方法执行空间
//        System.out.println("方法执行完毕,main方法中a的值:"+a);//1
//        //形参 与 实参
//        //想要让a的值 跟着方法内部的形参改变
    }

}
