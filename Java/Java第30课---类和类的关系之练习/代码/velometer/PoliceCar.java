package velometer;

public class PoliceCar {

    //属性---警车自己的速度
    private int speed;
    //构造方法
    public PoliceCar(){}
    public PoliceCar(int speed){
        this.speed=speed;
    }

    //警车追击小汽车   依赖关系
    public void chase(Car car){
        //获取小气车速度
        int carSpeed = car.getSpeed();
        //比较两车速度
        if(this.speed>carSpeed){//可以追到
            System.out.println("警车开始追击");
            int time = 100/(this.speed-carSpeed);
            try {
                Thread.sleep(3000);//编译时异常
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("小样儿跑了你啦，经过"+time+"秒追到啦");
        }else{//追不到啦
            System.out.println("小汽车飞的太快啦，望尘莫及");
        }
    }
}
