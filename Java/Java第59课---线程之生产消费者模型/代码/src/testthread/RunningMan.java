package testthread;

public class RunningMan implements Runnable {

    private String name;

    public RunningMan(){}
    public RunningMan(String name){
        this.name=name;
    }

    //重写run方法
    public void run(){
        for(int i=1;i<=100;i++){
            System.out.println(this.name+"跑到第"+i+"米啦");
        }
    }

}
