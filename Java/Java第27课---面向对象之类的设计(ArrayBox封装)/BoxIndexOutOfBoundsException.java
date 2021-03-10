public class BoxIndexOutOfBoundsException extends RuntimeException{
    //想要描述这个类是一个(我们自己的异常 is a 异常)异常
    //继承extends  泛化(实现)implements

    public BoxIndexOutOfBoundsException(){}
    public BoxIndexOutOfBoundsException(String msg){
        super(msg);//msg提供给父类
    }
}
