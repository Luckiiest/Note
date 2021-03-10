package rely;

public class Test {
    public static void main(String[] args){
        //创建农夫对象
        Farmer farmer = new Farmer();
        //农夫做一件事情--->养猪
        Pig pig = farmer.feedPig(5);
        //创建屠夫对象
        Butcher butcher = new Butcher();
        //屠夫做事--->杀猪
        butcher.killPig(pig);
    }
}
