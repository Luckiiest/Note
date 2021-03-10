package velometer;

public class Velometer {

    //属性--测速器规定好的标准时间
    private int standardTime;
    //构造方法
    public Velometer(){}
    public Velometer(int standardTime){
        this.standardTime=standardTime;
    }

    //测速器测量小汽车速度   依赖关系
    public void measureCar(Car car){
        //获取小气车的速度
        int carSpeed = car.getSpeed();
        //计算小气车运行时间
        int carTime = 100/carSpeed;
        //比较
        if(this.standardTime<=carTime){//小气车时间长 跑得慢
            System.out.println("速度正常,请保持安全行驶,祝您一路平安");
        }else{//超速啦
            System.out.println("经过测量,小气车超速啦,警车可以追击啦");
            //需要一个警车对象 来做事 追车
            //测速器发现小汽车超速  通知警车做事  (观察者设计模式)
            PoliceCar pc = new PoliceCar(25);
            pc.chase(car);
        }
    }
}
