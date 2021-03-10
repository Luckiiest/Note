package testset;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private int testNum;//记录人是谁
    public Person(String name,int age,int testNum){
        this.name=name;
        this.age=age;
        this.testNum=testNum;
    }

    //重写equals方法  将person放入set集合中 去掉重复
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof Person){
            //obj还原回Person类型
            Person anotherPerson = (Person)obj;
            //this  anotherPerson比较对象中的name属性
            if(this.name.equals(anotherPerson.name)){//递归
                return true;
            }
        }
        return false;
    }
    //重写 hashCode方法
    public int hashCode(){
        //两个person对象name属性一致  需要让hashCode返回值一致
        return this.name.hashCode();
    }
    //重写 toString方法  让对象打印输出的时候直接输出对象的属性 而不是hashCode码
    public String toString(){
        StringBuilder builder = new StringBuilder("{");
        builder.append(this.name);
        builder.append(",");
        builder.append(this.age);
        builder.append(",");
        builder.append(this.testNum);
        builder.append("}");
        return new String(builder);
    }

    //如果想要让person对象存入TreeSet集合内  必须实现接口 重写这个方法
    public int compareTo(Person o) {
        int value = this.name.compareTo(o.name);
        if(value!=0){
            return value;//当前对象name和另一个对象name的compateTo结果
        }
        return this.age-o.age;//返回值整数 靠后  返回值负数 靠前
    }

    public String getName(){
        return this.name;
    }
    public int getTestNum(){
        return this.testNum;
    }


}
