package testannotation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class TestMain {

    public static void main(String[] args){
        //java.util包  HashMap子类  集合--内存  读取文件信息
        //读取配置文件的信息   文件.properties
        //key=value     BufferedReader  br.readLine();  split("=");
        //key:value
        //key value
        //分隔符  = : 空格
        try {
            //创建时更像是一个高级流
            Properties pro = new Properties();
            pro.load(new FileReader("src//test.properties"));
            //使用的时候更像是map集合  value = get(key)
            //String value1 = pro.getProperty("key1");
            //System.out.println(value1);
            //获取全部的key  keySet()  entrySet()
            Enumeration en = pro.propertyNames();//获取全部的key
            //Enumeration类型的使用像是迭代器  hasNext()  next()
            while(en.hasMoreElements()){
                String key = (String)en.nextElement();
                String value = pro.getProperty(key);
                System.out.println(key+"--"+value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
