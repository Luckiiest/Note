package velometer;

public class Car {

    //属性--小汽车自己的速度   匀速直线运动
    private int speed;
    //构造方法
    public Car(){}
    public Car(int speed){
        this.speed=speed;
    }
    //提供一个方法获取小气车的速度
    public int getSpeed(){
        return this.speed;
    }
}
