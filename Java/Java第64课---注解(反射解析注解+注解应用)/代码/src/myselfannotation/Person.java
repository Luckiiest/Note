package myselfannotation;

public class Person {//domain实体对象 建议大家利用包装类

    private String name;
    private Integer age;
    private String sex;

    @MyAnnotation({"郑中拓","18","男"})
    public Person(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    //利用反射技术实现了一个IOC 对象由别人来创建 创建同时自动注入属性信息
    //自动注入属性的信息--->String字符串 产生一个注解 携带这些信息

//    @MyAnnotation({"郑中拓","18","男"})
//    private String name;
//
//    @MyAnnotation({"郑中拓2","19","女"})
//    public void eat(){
//
//    }
}
