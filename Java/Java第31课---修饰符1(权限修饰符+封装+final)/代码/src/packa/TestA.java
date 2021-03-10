package packa;

public class TestA {

    public static void main(String[] args){
        TestA ta = new TestA();
        ta.testPublic();
        ta.testProtected();
        ta.testDefault();
        ta.testPrivate();
    }

    public void testPublic(){
        System.out.println("我是TestA类中的public修饰符方法");
    }
    protected void testProtected(){
        System.out.println("我是TestA类中的protected修饰符方法");
    }
    void testDefault(){
        System.out.println("我是TestA类中的默认不写修饰符方法");
    }
    private void testPrivate(){
        System.out.println("我是TestA类中的private修饰符方法");
    }

}
