package contains;

public class Wheel {

    //属性
    public String brand;//品牌
    public int size;//尺寸
    public String color;//颜色

    //构造方法
    public Wheel(){}
    public Wheel(String brand,int size,String color){
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    //方法
    public void turn(){
        System.out.println("车轮子可以旋转");
    }
}
