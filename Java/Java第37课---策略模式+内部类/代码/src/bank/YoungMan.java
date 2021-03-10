package bank;

public class YoungMan extends Person{

    public YoungMan(){}
    public YoungMan(String name){
        this.name=name;
    }
    //1.进银行 叫一个号码 排队
    public void callNumber(){
        System.out.println("自己知道在门口按按钮 拿到号码小票");
    }
    //2.去窗口办理
    public void transact(){
        System.out.println("去窗口 汇款");
    }
    //3.办理完毕离开啦
    public void leave(){
        System.out.println("办理完迅速离开啦");
    }
}
