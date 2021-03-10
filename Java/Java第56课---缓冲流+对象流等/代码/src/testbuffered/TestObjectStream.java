package testbuffered;

import java.io.*;

public class TestObjectStream {

    public static void main(String[] args){
//        try {
//            //将对象直接记录在文件中
//            //对象的序列化
//            Person p1 = new Person("郑中拓",18);
//            //对象输出流
//            FileOutputStream fos = new FileOutputStream("D://test//Person.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);//高级流
//            oos.writeObject(p1);//将对象拆分成字节碎片  序列化到文件里
//            oos.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //需要一个对象输入流
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://test//Person.txt"));
            Person p = (Person)ois.readObject();
            System.out.println(p);
            p.eat();//EOFException说明没有对象  通常会将所有记录的对象存在一个集合
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
