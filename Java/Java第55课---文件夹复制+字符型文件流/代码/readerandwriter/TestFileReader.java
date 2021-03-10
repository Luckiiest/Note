package readerandwriter;

import java.io.*;

public class TestFileReader {
    public static void main(String[] args){
        try {
            //字符型文件输入流
            File file = new File("D://test//Test.txt");
            FileReader fr = new FileReader(file);
            String str = "abc";
            char[] c = str.toCharArray();
            FileWriter fw = new FileWriter(file);
            fw.write(97);
            fw.write(c);
            fw.write(str);
            fw.flush();

//            int code = fr.read();
//            System.out.println(code);
//            char[] c = new char[1024];
//            int count = fr.read(c);
//            while(count!=-1){
//                System.out.print(new String(c,0,count));
//                count = fr.read(c);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            //演示字节型文件输入流 读取中文可能会产生问题
//            //字节流好处在于什么类型的文件都可以处理  不好在于处理纯文本的文件可能会产生乱码的问题
//            FileInputStream fis = new FileInputStream("D://test//Test.txt");
//            byte[] b = new byte[5];
//            int count = fis.read(b);// 16bit
//            while(count!=-1){
//                System.out.print(new String(b,0,count,"GBK"));
//                count = fis.read(b);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
