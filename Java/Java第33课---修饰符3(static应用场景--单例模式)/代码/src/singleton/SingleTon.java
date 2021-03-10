package singleton;

public class SingleTon {
    //通过我的设计 让这个类只能创建一个对象

    //每一个类都有默认无参数的构造方法----公有  在外面可以随意创建
    //1.让构造方法变成私有---保证外面不可以随便创建对象
    private SingleTon(){}
    //2.单例 不是无例 --- 在本类中的某个成员位置上创建唯一的一个对象
    //在以下的四个位置 写一行new SingleTon
    //属性
    //方法------不行  每一次执行都会产生一个过程  保证不了唯一
    //构造方法--不行  私有  本身就是这个构建过程
    //块--------不行  没有返回值  创建了对象也无法给别人使用
    //2.在当前类中存在一个私有的静态属性  是当前类类型的
    private static SingleTon single;//直接 = new Singleton(); 立即加载  饿汉式
    //3.提供一个获取单个对象的方法给用户
    //   返回值  将对象返回出去
    public static SingleTon getSingleTon(){// get类名  newInstance
        if(single == null) {
            single = new SingleTon();//延迟加载的方式  懒汉式
        }
        return single;//引用类型
    }

}
