package myutil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class TestMath {

    //设计一个方法  用来计算给定数字的阶乘
    //参数   返回值
    public BigInteger factorial(int num){
        BigInteger result = new BigInteger("1");
        for(int i=1;i<=num;i++){
            result = result.multiply(new BigInteger(i+""));
        }
        return result;
    }

    public static void main(String[] args){
//        System.out.println(Math.ceil(1.4));//1.0
//        System.out.println(Math.floor(1.4));//1.0
//        System.out.println(Math.rint(1.4));//1.0
//        System.out.println(Math.round(1.4));//1
//        System.out.println(Math.sqrt(16));
//
//        Random r = new Random();
//        int value = r.nextInt();//随机产生一个整数
//        System.out.println(value);// -2147483648 ~  2147483647
//
//        int result = r.nextInt(10);
//        System.out.println(result);//  [0--10)
//
//        float f = r.nextFloat();
//        System.out.println(f);//  [0.0---1.0)
//
//        //5.0---10.9范围
//        float x = (r.nextInt(6)+5 + r.nextFloat());
//
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid.toString());//数据库表格主键 primary key
//
//        BigInteger  bi1 = new BigInteger("123");
//        BigInteger  bi2 = new BigInteger("456");
//        bi1.add(bi2);
//        bi1.subtract(bi2);
//        bi1.multiply(bi2);
//        bi1.divide(bi2);


        //创建对象 调用计算阶乘的方法
        TestMath tm = new TestMath();
        BigInteger result = tm.factorial(25);
        System.out.println(result);

        BigDecimal decimal = new BigDecimal("123.456");
        //小数点之后保留两位  按照向下取整的方式进行截取
        decimal = decimal.setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println(decimal);

        DecimalFormat df = new DecimalFormat("000.###");// 0 #
        String value = df.format(12.45);
        System.out.println(value);
    }
}
