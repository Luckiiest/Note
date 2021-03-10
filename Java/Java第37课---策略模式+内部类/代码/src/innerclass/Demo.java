package innerclass;

public class Demo {
    private String name = "这是正常类中的属性";
    public void testDemo(){
        System.out.println("这是正常类中的方法");
    }
    public void testDemoOne(){
        String s = "";
        //定义一个局部内部类
        class InnerTestMethod{
            //局部内部类中使用的局部变量都需要加final修饰
        }
    }
    public void testDemoTwo(){
        String s;
        //定义一个局部内部类
        class InnerTestMethod{

        }
    }

    //成员内部类
    public class InnerDemo{
        private String name="我是内部类的属性";
        public void testInnerDemo(){
            System.out.println("我是成员内部类的方法:"+this.name);
            Demo.this.testDemo();
        }
    }

    private static class InnerDemoStatic{

    }

}

