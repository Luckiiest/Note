package testbuffered;

import java.io.*;

public class TestBufferedStream {

    public static void main(String[] args){
        try {
            //创建一个流  string  file
            File file = new File("D://test//Test.txt");
            FileInputStream fis = new FileInputStream(file);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            bis.read(int);
//            bis.read(byte[])
//            bis.available();
//            bis.skip(long);
//            bis.close();

//            FileOutputStream fos = new FileOutputStream("",true);
//            BufferedOutputStream bos = new BufferedOutputStream(fos);
//            bos.write(int);
//            bos.write(byte[]);
//            bos.flush();
//            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
