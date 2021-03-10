package testreflect;

public class Person extends Animal{

    private String name;
    public int age;

    public String toString(){
        return "{"+name+","+age+"}";
    }

}
