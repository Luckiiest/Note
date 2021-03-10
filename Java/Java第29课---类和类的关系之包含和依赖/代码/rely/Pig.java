package rely;

public class Pig {//描述猪

    //属性
    private String name;//名字
    private int weight = 20;//体重

    //构造方法
    public Pig(){}
    public Pig(String name){
        this.name=name;
    }

    //方法
    //描述一个方法  表示小猪被杀啦
    public void beKilled(){
        System.out.println(this.name+"被杀啦，好惨呀");
    }

    //描述一个方法  让猪长肉
    //    每一个月涨到前一个月的两倍
    public void growUp(int month){
        for(int i=1;i<=month;i++){
            this.weight*=2;
        }
    }

    //描述一个方法  猪告知他的体重
    public int getWeight(){
        return this.weight;
    }
    public String getName(){
        return this.name;
    }
}
