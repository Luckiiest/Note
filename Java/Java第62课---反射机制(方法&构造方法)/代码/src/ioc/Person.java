package ioc;

public class Person {//实体对象
    private String name;
    private Integer age;//Integer       person类的信息  写在文件里   null  18
    private String sex;

    //@xxx("郑中拓",18,"男")
    public Person() {}

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
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
}
