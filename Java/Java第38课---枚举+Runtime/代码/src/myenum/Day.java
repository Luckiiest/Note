package myenum;

public enum Day{

    //描述了七个当前类的对象
    monday("星期一",1),tuesday("星期二",2),wednesday,thursday,friday,saturday,sunday;

    private String name;
    private int index;

    private Day(){}
    private Day(String  name,int index){
        this.name=name;
        this.index=index;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

}
