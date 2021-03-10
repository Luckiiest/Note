package teststream;

import java.io.*;

public class TestFileOutputStream {

    public static void main(String[] args){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D://test//bbb.txt",true);
            //创建一个数组  带着信息
            //byte[] b = new byte[]{97,98,99};
            String str = "1+1=2";//String-->byte[]
            byte[] b = str.getBytes();
            fos.write(b);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        try {
//            //创建一个字节型文件输出流
//            File file = new File("D://test//aaa.txt");
//            //创建的是文件输入流  若文件路径有问题  则抛出异常  FileNotFoundException
//            //创建的是文件输出流  若文件路径有问题  则直接帮我们创建一个新的文件
//            //将内容写入文件
//            FileOutputStream fos = new FileOutputStream(file,true);
//            fos.write(49);//a   a是写入在哪里了?  1+1=2
//            fos.write('+');
//            fos.write(49);
//            fos.write('=');
//            fos.write(50);
//            fos.flush();//刷新  将管道中的字节 推入文件中
//            System.out.println("写入完毕");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
