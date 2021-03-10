package myutil;

public class TestUtil {

    public static void main(String[] args){
        new TestUtil().equals(null);
        Integer i1 = 1000;//10自动包装成Integer对象
        Integer i2 = 1000;
        Integer i3 = new Integer(1000);
        Integer i4 = new Integer(1000);
        System.out.println(i1==i2);//true-->false
        System.out.println(i1==i3);//false
        System.out.println(i3==i4);//false
        System.out.println(i1.equals(i2));//true
        System.out.println(i1.equals(i3));//true
        System.out.println(i3.equals(i4));//true

    }

}
