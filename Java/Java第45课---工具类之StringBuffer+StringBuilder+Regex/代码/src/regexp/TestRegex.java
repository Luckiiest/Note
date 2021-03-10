package regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        System.out.println("请您输入一个字符串");
//        String str = input.nextLine();
        //判断输入的str字符串内容是否满足什么样的格式

        //第一个字母必须是a 第二个字母是abc其中的一个
//        boolean result1 = str.matches("[A-Za-z]{6,10}");
//        System.out.println(result1);

        //第一个字母必须是a 第二个字母是非abc任意的其他一个
//        boolean result2 = str.matches("a[^abc]");
//        System.out.println(result2);

        //第一个字母必须是a 第二个任意范围之内的一个字母
//        boolean result = str.matches(".[a-zA-Z]");
//        System.out.println(result);

        //a-z都可以 不能是b和c
//        boolean result = str.matches("[a-z&&[^bc]]");
//        System.out.println(result);

//        String value = "a,b+c#d";
//        String[] result = value.split(",|\\+|#");
//        System.out.println(result.length);

        //所有的字串中找寻满足如下规则的信息  邮政编码
        String str = "123456abc222333abc654321abc";
        //1.利用Pattern类创建一个模式   理解为是一个正则表达式对象
        Pattern pattern = Pattern.compile("\\d{6}");//邮编
        //2.需要提供一个字符串
        //3.利用pattern模式对象创建一个匹配器
        Matcher matcher = pattern.matcher(str);
        //4.找寻字符串中出现满足上述格式的字串
        while(matcher.find()){
            System.out.println(matcher.group());//找到满足字符串格式的那一串文字
        }
    }
}
