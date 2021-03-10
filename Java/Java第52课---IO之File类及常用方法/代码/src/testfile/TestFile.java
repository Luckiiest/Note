package testfile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {

    public static void main(String[] args){
        File file = new File("D://test/bbb");
        boolean value = file.delete();
        System.out.println(value);

//        File file = new File("D://test//aaa");
//        //数组对象为空         证明当前的file是一个文件
//        //数组对象不为空       证明当前的file是一个文件夹
//        //数组对象的长度不为0  证明当前的file是一个不为空的文件夹  文件夹内有元素
//        File[] files = file.listFiles();
//        System.out.println(files.length);
//        //递归算法---遍历文件夹


        //遍历当前file的所有父目录
//        File file = new File("D:\\test\\bbb\\inner\\InnerTest.txt");
//        File pfile = file.getParentFile();
//        while(pfile!=null){
//            System.out.println(pfile.getAbsolutePath());
//            pfile = pfile.getParentFile();//再找一遍
//        }

//        String pname = file.getParent();//当前file的父亲名字  test
//        System.out.println(pname);
//        File pfile = file.getParentFile();//当前file的父亲对象  file-->D://test
//        System.out.println(pfile.getAbsolutePath());







        //创建一个file对象
//        File file = new File("D://test//xyz");
//        //通过这个对象  回头在硬盘上 创建文件
//        try {
//            boolean value = file.createNewFile();//编译时异常
//            System.out.println(value);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //创建一个新的file对象
//        File file = new File("D://test//bbb/inner");
//        //在硬盘上 创建一个新的文件夹
//        //boolean value = file.mkdir();//外层(父元素)需要真实存在
//        boolean value = file.mkdirs();//可以创建文件夹  如果外层没有  也会同时创建
//        System.out.println(value);

//        File file = new File("E:\\test\\Test.txt");
//        String name = file.getName();//文件的名字  Test.txt
//        String path = file.getAbsolutePath();//文件的绝对路径  D://test//Test.txt
//        System.out.println(name);
//        System.out.println(path);

        //file对象 是真正的文件么?   不是
        //file对象 堆内存中 创建出来的一个对象空间
        //路径是看创建的对象 是否能与硬盘中的一个真实文件产生对应映射关系
        //通过文件流去读取文件的内容
        //硬盘上的文件名字是不区分大小写  内存中File对象 变量名字区分大小写
        //文件本身的一些属性---->
//        System.out.println(file.canExecute());
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());
//        System.out.println(file.isHidden());
//        System.out.println(file.isFile());//判断当前的file是否是一个文件
//        System.out.println(file.isDirectory());//判断当前的file是否是一个目录(文件)
//        long l = file.length();
//        System.out.println(l);
//        long time = file.lastModified();//获取文件最后修改时间
//        Date date = new Date(time);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss");
//        System.out.println(sdf.format(date));
//
//        file.setLastModified(time);//修改文件的时间
    }
}
