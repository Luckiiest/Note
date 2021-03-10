package singleton;

public class TestMain {
    public static void main(String[] args){
        SingleTon s1 = SingleTon.getSingleTon();
        SingleTon s2 = SingleTon.getSingleTon();
        System.out.println(s1==s2);//true 比较地址
        System.out.println(s1.equals(s2));//true Object类继承过来的 默认也比地址
        System.out.println(s1);//类全名@hashCode--->16进制的整数
        System.out.println(s2);
    }
}
