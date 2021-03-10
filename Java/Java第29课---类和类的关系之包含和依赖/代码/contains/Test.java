package contains;

public class Test {

    public static void main(String[] args){
        Car car = new Car("宝马","Z4","宝石蓝色",new Wheel("米其林",400,"酷黑"));
        car.showCar();//展示汽车
    }
}
