package testmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LoginService {

    //设计一个方法  用来登录认证  一维数组
//    private String[] userBox = new String[]{"郑中拓","渡一教育","Java"};
//    private int[] passwordBox = new int[]{123,666,888};
//    public String loingForArray(String name,String password){
//        for(int i=0;i<userBox.length;i++){
//            if(userBox[i].equals(name)){
//                if(passwordBox[i]==Integer.parseInt(password)){
//                    return "登录成功";
//                }
//                break;
//            }
//        }
//        return "用户名或密码错误";
//    }

    //设计一个方法  用来登录认证---ArrayList
//    private ArrayList<String> userBox = new ArrayList<String>();
//    {
//        userBox.add("郑中拓-123");
//        userBox.add("渡一教育-666");
//        userBox.add("Java-888");
//    }
//    public String loginForList(String name,String password){
//        for(int i=0;i<userBox.size();i++){
//            String[] value = userBox.get(i).split("-");//一个人的信息 v[0] v[1]
//            if(value[0].equals(name)){
//                if(value[1].equals(password)){
//                    return "登录成功";
//                }
//                break;
//            }
//        }
//        return "用户名或密码错误";
//    }

    //设计一个方法  用来登录认证-----Set
//    private HashSet<String> userBox = new HashSet<String>();
//    {
//        userBox.add("郑中拓-123");
//        userBox.add("渡一教育-666");
//        userBox.add("Java-888");
//    }
//    public String loginForSet(String name,String password){
//        Iterator<String> it = userBox.iterator();
//        while(it.hasNext()){
//            String[] value = it.next().split("-");
//            if(value[0].equals(name)){
//                if(value[1].equals(password)){
//                    return "登录成功";
//                }
//                break;
//            }
//        }
//        return "用户名或密码错误";
//    }


    //设计一个方法   用来登录认证---map     name(唯一)  pass
    private HashMap<String,Integer> userBox = new HashMap<String,Integer>();
    {
        userBox.put("郑中拓",123);
        userBox.put("渡一教育",666);
        userBox.put("Java",888);
    }
    public String loginForMap(String name,String password){
        Integer realPassword = userBox.get(name);//null
        if(realPassword!=null && realPassword.equals(Integer.parseInt(password))){//人名存在
                return "登录成功";
        }
        return "用户名或密码错误";
    }


}
