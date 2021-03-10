package packb;
import packa.TestA;

public class TestB extends TestA{

    public void testB(){
        this.testPublic();
        this.testProtected();
    }
    public static void main(String[] args){
        //TestB tb = new TestB();
        //tb.testPublic();
        //tb.testProtected();
        TestA ta = new TestA();
        ta.testPublic();
    }
}
