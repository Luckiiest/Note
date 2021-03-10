package bufferandbuilder;

public class TestStringBuilder {

    public static void main(String[] args){
//        //无参数构造方法  构建一个默认长度16个空间的对象  char[]
//        StringBuilder builder = new StringBuilder();
//        //利用给定的参数 构建一个自定义长度空间的对象 char[]
//        StringBuilder builder = new StringBuilder(20);
        //利用带String参数的构造方法  默认数组长度字符串长度+16个
        //StringBuilder builder = new StringBuilder("abc");

//        String str = "a";
//        long time1 = System.currentTimeMillis();
//        for(int i=1;i<=200000;i++){
//            //str+="a";//利用+拼接  10030
//            str = str.concat("a"); //5320
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);

//        StringBuilder builder = new StringBuilder("a");//17
//        long time1 = System.currentTimeMillis();
//        for(int i=1;i<=200000;i++){
//            builder = builder.append("a");//7毫秒
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);

//        StringBuilder builder = new StringBuilder("abcdefg");//7+16 capacity
//        System.out.println(builder.capacity());//底层那个数组的容量
//        System.out.println(builder.length());//长度  有效元素的个数

//        StringBuffer buffer = new StringBuffer();
//        buffer.append("");
//
//        StringBuilder builder = new StringBuilder("abcdefg");// 7+16
//        builder.append("");
//
//        System.out.println(builder.length());//7
//        System.out.println(builder.capacity());//23
//        builder.setLength(15);//length--15
//        builder.trimToSize();
//        System.out.println(builder.length());//15
//        System.out.println(builder.capacity());//15




//        System.out.println(builder.length());//7
//        System.out.println(builder.capacity());//23
//        builder.setLength(20);
//        System.out.println(builder.length());//20
//        System.out.println(builder.capacity());//23
//        builder.toString();//将一个StringBuilder对象 转化成String对象



        //builder.setCharAt(2,'z');
        //System.out.println(builder);

        //builder.reverse();
        //System.out.println(builder);


//        builder.replace(2,5,"zzt");
//        System.out.println(builder);


//        builder.append("m");//abcdefgm
//        System.out.println(builder);
//        builder.insert(1,"n");
//        System.out.println(builder);

        //builder.deleteCharAt(2);
        //System.out.println(builder);
        //builder.delete(2,5);
        //System.out.println(builder);

//        String value= builder.substring(2,5);//2索引开始5索引结束
//        System.out.println(value);


    }
}
