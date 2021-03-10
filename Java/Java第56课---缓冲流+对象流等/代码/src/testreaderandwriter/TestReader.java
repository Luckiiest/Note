package testreaderandwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

    public static void main(String[] args){
        try {
            //创建一个字符型文件输入流----> 一个字符
            FileReader fr = new FileReader(new File("D://test//Test.txt"));
            int code = fr.read();
            while(code!=-1) {
                System.out.println(code);//25105
                System.out.println((char) code);
                code = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
