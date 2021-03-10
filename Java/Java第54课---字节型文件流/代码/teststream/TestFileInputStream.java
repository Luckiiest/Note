package teststream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {

    public static void main(String[] args){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("D://test//Test.txt"));
            fis.skip(5);
            int code = fis.read();
            System.out.println((char)code);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null) {
                    fis.close();//关闭的是流通道  不是file对象   关闭这件事情必须要做
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        try {//流---管道
//            FileInputStream fis = new FileInputStream("D://test//Test.txt");
//            int v = fis.available();//流管道中有多少缓存的字节  读取网络数据的数据可能会有问题
//            System.out.println(v);
//            //创建一个空的数组--->小推车
//            byte[] b = new byte[5];
//            int count = fis.read(b);//去文件里读东西 装入数组内   读取到的有效字节个数
//            while(count!=-1){
//                String value = new String(b,0,count);//第一次  a b c d e
//                System.out.print(value);     //第二次  f g \r\n h
//                count = fis.read(b);         //第三次  i j k l m
//            }                                //第四次  n \r \n o p
//        } catch (IOException e) {            //第五次  q \r \n o p  count--->1  此时的数组 5个元素
//            e.printStackTrace();
//        }


//        try {//理解为 文件是一个仓库  fis对象搬运工   推一个平板车
//            //创建一个字节型的文件输入流   读取一个文件中的内容
//            File file = new File("D://test//Test.txt");
//            FileInputStream fis = new FileInputStream(file);//真实去读文件
//            int code = fis.read();//读取一个字节   -1
//            while(code!=-1) {
//                System.out.print((char)code);//读取的字节对应的Unicode码   0---65535
//                code = fis.read();//读取一个字节   -1
//            }
//        } catch (FileNotFoundException e) {//编译时异常
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
