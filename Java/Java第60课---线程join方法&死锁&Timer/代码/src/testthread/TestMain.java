package testthread;

public class TestMain {

    public static void main(String[] args){
        //1.创建一个线程对象
        RunningMan r1 = new RunningMan("苏炳添");
        RunningMan r2 = new RunningMan("博尔特");
        RunningMan r3 = new RunningMan("加特林");
        //2.调用start方法  让线程进入就绪状态  按顺序逐个执行
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
//        r1.start();//从Thread类中继承过来的方法
//        r2.start();
//        r3.start();
    }
}
