package computer;

public class Computer {

    //属性---表示电脑的编号
    private int number;
    //属性---自己的状态 开着的或者关着的
    private boolean used = false;//true开着的  false关着的

    //设计构造方法
    public Computer(){}
    public Computer(int number){
        this.number=number;
    }
    //设计两个方法 获取电脑的编号 电脑的状态
    public int getNumber(){
        return this.number;
    }
    public boolean isUsed(){//获取电脑状态
        return this.used;
    }

    //设计普通方法---被打开 使用 关闭
    public void beOpen(){
        this.used = true;//状态切换成开着的
        System.out.println(this.number+"号电脑被打开啦");
    }
    public void beUsing(){
        System.out.println(this.number+"号电脑正在被使用中。。。");
    }
    public void beClose(){
        this.used = false;//状态切换成关着的
        System.out.println(this.number+"号电脑被关闭啦");
    }
}
