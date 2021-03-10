package newtestfile;

import java.io.File;

public class NewTestFile {

    //设计一个方法  用来展示(遍历)文件夹
    //  参数-->file(代表文件或文件夹)
    public void showFile(File file){//D://test文件夹
        //判断如果file是一个文件夹 文件夹内有元素 找一个人先做
        //获取file的子元素  files==null是个文件 files!=null是个文件夹 files.length!=0是一个带元素的文件夹
        File[] files = file.listFiles();//test文件夹所有子元素
        if(files!=null && files.length!=0){
            for(File f:files){//每一个子元素都找人遍历
                this.showFile(f);//循环第一次 test文件夹中的aaa 循环第二次 test->bbb 循环第三次 Test.txt
            }
        }
        //做自己的显示(file是文件或file是一个空的文件夹)
        System.out.println(file.getAbsolutePath());
    }

    //设计一个方法 删除文件夹
    //  参数 file
    public void deleteFile(File file){
        //判断file不是空文件夹 找人先做事
        File[] files = file.listFiles();
        if(files!=null && files.length!=0){
            for(File f:files){
                this.deleteFile(f);
            }
        }
        //删除file (file是个文件或file是一个空文件夹)
        file.delete();
    }

    public static void main(String[] args){
        NewTestFile ntf = new NewTestFile();
        File file = new File("D://test");
        ntf.deleteFile(file);
        //ntf.showFile(file);
    }
}
