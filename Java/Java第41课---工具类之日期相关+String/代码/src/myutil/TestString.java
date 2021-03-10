package myutil;

public class TestString {

    public static void main(String[] args){
        //String类  "abc"对象  常量区
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s3==s4);//false
        System.out.println(s1.equals(s2));//true   String类将继承自Object中的equals方法重写啦
        System.out.println(s1.equals(s3));//true   将原有比较==的方式改为比较字符值
        System.out.println(s3.equals(s4));//true

    }
}
