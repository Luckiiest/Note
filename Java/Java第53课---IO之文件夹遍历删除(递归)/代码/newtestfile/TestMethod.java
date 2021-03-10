package newtestfile;

public class TestMethod {

//    public void testOne(){
//        this.testTwo();
//        System.out.println("我是testOne方法");
//    }
//    public void testTwo(){
//        this.testThree();
//        System.out.println("我是testTwo方法");
//    }
//    public void testThree(){
//        System.out.println("我是testThree方法");
//    }

    //递归---->本质是方法的调用
    //      设计一个方法  描述盖宝塔
//    public void buildTower(int floor){//5
//        for(int i=1;i<=floor;i++){
//            System.out.println("盖到第"+floor+"层宝塔啦");
//        }
//    }

    //递归的想法
    //  想让我做事(盖第五层) 我要求让别人把之前的事情做完
    //      1.让别人先做事
    //      2.我自己做事
    public void buildTower(int floor){//5
        //判断当前floor是否为1 若不是找一个别人先盖之前层
        if(floor>1){
            this.buildTower(floor-1);
        }
        //我自己做事
        System.out.println("盖到第"+floor+"层宝塔啦");
    }
//    public void buildTower(int floor){//4
//        //找一个别人先盖3层
//        this.buildTower(floor-1);
//        //我自己做事
//        System.out.println("盖到第"+floor+"层宝塔啦");
//    }
//    public void buildTower(int floor){//3
//        //找一个别人先盖2层
//        this.buildTower(floor-1);
//        //我自己做事
//        System.out.println("盖到第"+floor+"层宝塔啦");
//    }
//    public void buildTower(int floor){//2
//        //找一个别人先盖1层
//        this.buildTower(floor-1);
//        //我自己做事
//        System.out.println("盖到第"+floor+"层宝塔啦");
//    }
//    public void buildTower(int floor){//1
//        //我自己做事
//        System.out.println("盖到第"+floor+"层宝塔啦");
//    }


    public static void main(String[] args){
        //加载TestMethod类的过程
        TestMethod tm = new TestMethod();
        tm.buildTower(5);//执行一次
//        tm.testOne();//调用testOne让其执行一遍--->栈内存中 临时
    }

}
