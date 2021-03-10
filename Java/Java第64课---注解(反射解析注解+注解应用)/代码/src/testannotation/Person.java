package testannotation;

public class Person {

    @MyAnnotation({"abc",""})//我们定义一个注解对象 我们把abc传递给注解 让他携带给别人
    public void eat(){

    }
//    //方法重写override
//    //继承关系两个类   子类重写父类的方法
//    //权限修饰符   子类可以大于等于父类
//    //特征修饰符   父类final子类不能重写  父类static子类不存在  父类abstract子类必须重写
//    //返回值类型   子类可以小于等于父类
//    //方法名字     子类必须与父类一致
//    //参数列表     子类必须与父类一致
//    //抛出异常     父类异常是运行时  子类可以不予理会
//    //             父类异常是编译时  子类抛出的异常 类型 个数都小于等于父类
//
//    //方法重载overload
//    //  一个类中的方法
//    //  具有相同的方法名字  不同的参数列表
//    //  不同的参数列表体现在  个数  类型  顺序
//
//    @Override
//    public void eat(){//算作方法重载
////        //什么时候---时间
////        Date date = new Date();//当前系统时间
////        date.getYear();//当前的方法是废弃的 过时的
//    }
//
//    @Override
//    @SuppressWarnings("all")
//    public void test() {
//        String str = "abc";
//        ArrayList list = new ArrayList();
//        Date date = new Date();
//        date.getYear();
//    }
}
