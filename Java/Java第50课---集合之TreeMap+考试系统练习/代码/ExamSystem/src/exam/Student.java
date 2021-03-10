package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    //属性
    private String username;
    private String password;

    public Student(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    //学生需要考试---方法
    //      参数---是一套试卷   返回值---学生作答的所有选项String[] "A"  "D"  "B"  "C"  "D"
    public String[] exam(ArrayList<Question> paper){
        String[] answers = new String[paper.size()];
        Scanner input = new Scanner(System.in);
        for(int i=0;i<paper.size();i++){
            Question question = paper.get(i);//题干 真实答案
            System.out.println((i+1)+"."+question.getTitle());
            System.out.println("请输入您认为正确的选项?");
            answers[i] = input.nextLine();//接受学生输入的选项
        }
        return answers;
    }
}
