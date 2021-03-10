package gc;

public class Person {

    //Person类默认继承Object
    //  hashCode  equals  toString  getClass  wait  notify  notifyAll  clone
    //  finalize  Object类中的一个protected方法

    public Person(){
        System.out.println("person对象被创建啦");
    }
    public void finalize(){
        System.out.println("person对象被回收啦");
    }
}
