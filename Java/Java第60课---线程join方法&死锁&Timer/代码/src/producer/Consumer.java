package producer;

public class Consumer extends Thread{

    //为了保证生产者 和消费者使用同一个仓库对象  添加一个属性
    private Warehouse house;
    public Consumer(Warehouse house){
        this.house=house;
    }

    //消费者的方法  一直从仓库内获取元素
    public void run(){
        while(true){
            house.get();
            System.out.println("消费者拿走了一件货物");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
