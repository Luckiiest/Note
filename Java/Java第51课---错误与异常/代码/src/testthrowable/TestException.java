package testthrowable;

public class TestException {

    //来设计一个方法 测试自定义异常的使用
    public void testMyException() throws MyException{
        System.out.println("测试自定义异常的方法执行啦");
        if(3>2){//若满足某个条件
            throw new MyException("说明一下异常的具体问题");
        }
    }



    //设计一个方法
    public String testException() throws NullPointerException,StringIndexOutOfBoundsException,Exception{
        String str = "abc";
        str.length();
        str.charAt(10);

//        try{
//            System.out.println("try开始执行");
//            String str = null;
//            str.length();//空指针异常
//            System.out.println("try执行完毕");
//            return "try中的返回值";//事先约定好 返回值
//        }catch(Exception e){
//            //e.printStackTrace();//打印输出异常的名字
//            System.out.println("捕获到了异常");
//        }finally {
//            System.out.println("finally块执行啦");
//        }
        return "最终的返回值";
    }
    public static void main(String[] args){//JVM
       //System.out.println(10/0);
       TestException te = new TestException();
       try {
           te.testMyException();
       }catch (Exception e){
            e.printStackTrace();
       }


       //te.testException();

//        System.out.println("程序最早开始执行");
//        try {
//            System.out.println("try开始");
//            String str = "abc";
//            str.length();
//            str.charAt(10);//StringIndexOutOfBoundsException
//            System.out.println("try完毕");
//        }catch(NullPointerException e) {
//            System.out.println("捕获到了空指针异常");
//        }catch(Exception e){
//            System.out.println("捕获到了其他异常");
//        }finally {
//            System.out.println("我是finally执行块 我必须执行");
//        }
//        System.out.println("产生异常之后的所有程序");
    }
}
