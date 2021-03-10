package producer;

import java.util.ArrayList;

public class Warehouse {

    //单例设计模式

    //仓库里面的集合  存放元素
    private ArrayList<String> list = new ArrayList<>();
    //向集合内添加元素的方法
    public synchronized void add(){
        if(list.size()<20) {
            list.add("a");
        }else{
            //return;//让方法执行到这里就结束方法
            try {
                this.notifyAll();
                this.wait();//仓库调用wait 不是仓库对象等待  访问仓库的生产者线程进入等待状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //从集合内获取元素的方法
    public synchronized void get(){
        if(list.size()>0) {
            list.remove(0);//集合越界的问题
        }else{
            //return;
            try {
                this.notifyAll();
                this.wait();//仓库对象调用wait  不是仓库对象等待  访问仓库的消费者线程进入等待状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
