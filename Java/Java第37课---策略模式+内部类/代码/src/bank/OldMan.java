package bank;

public class OldMan extends Person{

    public OldMan(){}
    public OldMan(String name){
        this.name=name;
    }
    //1.进银行 叫一个号码 排队
    public void callNumber(){
        System.out.println("年事已高 不知道在哪儿叫号 请求大堂经理的帮忙");
    }
    //2.去窗口办理
    public void transact(){
        System.out.println("到窗口 掏出手绢儿 拿出存折 取钱");
    }
    //3.办理完毕离开啦
    public void leave(){
        System.out.println("办理完毕 慢慢的离开啦");
    }

}
