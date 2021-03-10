package test_final;

public class TestFinal {

    private final String name = "";
    public void testNum(final int[] a){
        a[0] = 10;
    }

    public static void main(String[] args){
        Person p = new Person();
        p.eat();

//        TestFinal tf = new TestFinal();

        //final int a;//声明变量   内存开辟栈内存空间
        //a = 1;//赋值   常量区取得一个常量  复制一份存入a空间内
        //a = 10;//改变变量的值

        /*
        final int[] x;
        x = new int[]{1,2,3};
        x = new int[5];
        x[0] = 10;
        x[0] = 100;
        */
    }

}
