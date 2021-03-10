package atmsystem;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class FileLoaderAndCommit {

    private String fileName = null;
    public FileLoaderAndCommit(String fileName){
        this.fileName=fileName;
    }

    //程序块的目的在对象创建之前 给集合进行赋值操作
    public HashMap<String,User> loadFile(){
        HashMap<String,User> userBox = new HashMap<String,User>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            //创建一个输入流  读取真实文件的记录
            File file = new File(fileName);
            fileReader  = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String value = bufferedReader.readLine();
            while(value!=null){
                //value的信息拆分成三段  构建一个User对象  三个属性刚好存储  对象存入集合
                String[] userValue = value.split("-");
                User user = new User(userValue[0],userValue[1],Float.parseFloat(userValue[2]));
                userBox.put(user.getAname(),user);//put(账号,User对象)
                value = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedReader!=null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userBox;
    }

    //设计一个方法 目的是为了将集合内的所有数据写入文件
    public void commit(HashMap<String,User> userBox){//数据库--->commit提交--->事务
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            //创建一个字符型文件输出流
            File file = new File(fileName);
            fileWriter  = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Iterator<String> names = userBox.keySet().iterator();
            while(names.hasNext()){
                String name = names.next();//集合内获取的某一个人名
                User user = userBox.get(name);//记录一个人的真实数据
                //将user对象中的真实数据拼接成一行字符串
                StringBuilder builder = new StringBuilder(user.getAname());
                builder.append("-");
                builder.append(user.getApassword());
                builder.append("-");
                builder.append(user.getAbalance());
                //字符型文件输出流将拼接好的builder写入文件
                bufferedWriter.write(builder.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(fileWriter!=null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedWriter!=null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
