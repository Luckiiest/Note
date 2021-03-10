package system12306;

public class Ticket {

    //User类  Ticket类  没有任何逻辑
    //只是包含一些基本属性  每一个对象 小容器
    //一个对象 包含很多属性  增强可读性  类名  属性名  属性类型不一致
    //POJO  JavaBean

    private String start;//起始站名
    private String end;//终点站名
    private Float price;// null 123.4

    public Ticket(){}
    public Ticket(String start,String end,Float price){
        this.start=start;
        this.end=end;
        this.price=price;
    }

    //为了让打印输出时变得方便  打印一个对象就可以了
    //重写toString方法
    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        builder.append(this.start);
        builder.append("-->");
        builder.append(this.end);
        builder.append(":");
        builder.append(this.price);
        builder.append("]");
        return builder.toString();
    }



    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
}
