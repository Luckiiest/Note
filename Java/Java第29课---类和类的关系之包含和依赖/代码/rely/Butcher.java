package rely;

public class Butcher {//描述屠夫

    //属性  名字 有刀

    //方法
    //描述一个屠夫杀猪的方法   需要提供条件 一头猪
    public void killPig(Pig pig){
        System.out.println("屠夫执行了杀猪方法");
        String pigName = pig.getName();
        int pigWeight = pig.getWeight();
        System.out.println(pigName+"的体重为:"+pigWeight);
        pig.beKilled();
    }
}
