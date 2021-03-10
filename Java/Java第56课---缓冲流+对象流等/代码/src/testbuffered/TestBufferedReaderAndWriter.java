package testbuffered;

import java.io.*;

public class TestBufferedReaderAndWriter {

    //设计一个方法  用来用户登录认证
    public String login(String username,String password){
        //真实的名字和密码 永久的存在数据库---->数据持久化
        //文件我们采用.txt形式的纯文本   文本中的内容  以行为单位  每一行记录一个人的信息
        try {
            BufferedReader br = new BufferedReader(new FileReader("D://test//User.txt"));
            String user = br.readLine();//user表示一行记录  记录着账号和密码 郑中拓-123
            while(user!=null){
                System.out.println("找到信息了么");
                //将user的信息 按照-拆分  分别与方法的参数进行比较
                String[] value = user.split("-");//value[0]账号  value[1]密码
                System.out.println(value.length);
                System.out.println(value[0]+"---"+username);
                if(value[0].equals(username)){
                    System.out.println("名字对啦");
                    if(value[1].equals(password)){
                        return "登录成功";
                    }
                }
                user = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "用户名或密码错误";
    }

    public static void main(String[] args){
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("D://test//User.txt",true));
//            bw.newLine();
//            bw.write("Java-888");
//            bw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        TestBufferedReaderAndWriter test = new TestBufferedReaderAndWriter();
//        String result = test.login("渡一教育","666");
//        System.out.println(result);

//        try {
//            //创建一个字符形式的缓冲流  输入流  读取文件
//            FileReader fr  = new FileReader("D://test//User.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String value = br.readLine();//读取文件中一行的信息   read  int
//            while(value!=null){
//                System.out.println(value);
//                value = br.readLine();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }





        try {
            //创建字符输入流  file  String
            File file = new File("D://test//Test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int code = br.read();
            System.out.println(code);//65279
//            while(code!=-1) {
//                System.out.print((char)code);
//                code = br.read();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
