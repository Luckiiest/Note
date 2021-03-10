package bank;

public class Toff extends Person{

    public Toff(){}
    public Toff(String name){
        this.name=name;
    }
    //1.进银行 叫一个号码 排队
    public void callNumber(){
        System.out.println("我是土豪我有钱 不需要叫号排队 直接进入VIP窗口");
    }
    //2.去窗口办理
    public void transact(){
        System.out.println("我是土豪我有钱 甩一张限量黑卡 取1000W 买车");
    }
    //3.办理完毕离开啦
    public void leave(){
        System.out.println("帅气的提着一袋子钱离开啦");
    }
}
