package contains;

public class Car {

    //属性
    public String brand;//汽车品牌
    public String type;//型号
    public String color;//颜色
    public Wheel wheel;//车里面有一个轮子--->包含关系

    //构造方法
    public Car(){}
    public Car(String brand,String type,String color,Wheel wheel){
        this.brand=brand;
        this.type=type;
        this.color=color;
        this.wheel=wheel;
    }
    //方法
    public void showCar(){
        System.out.println("这是一辆"+brand+"牌"+type+"型号"+color+"的小汽车");
        System.out.println("车上搭载着"+wheel.brand+"牌的"+wheel.size+"尺寸"+wheel.color+"颜色的车轮子");
        wheel.turn();//方法一定对象调用的  车轮子的方法肯定是车轮子对象调用   可以放置在任何地方
    }
}
