package testset;

import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args){
        TreeSet<String> stringSet = new TreeSet<String>();
        stringSet.add(new String("郑中拓"));
        stringSet.add(new String("郑中拓"));
        stringSet.add(new String("郑中拓"));
        stringSet.add(new String("郑中拓"));
        stringSet.add(new String("郑中拓"));
        System.out.println(stringSet.size());//1    set家族如有相同的对象 拒绝存入

        TreeSet<Person> personSet = new TreeSet<Person>();
        personSet.add(new Person("郑中拓",18,1));
        personSet.add(new Person("郑中拓",16,2));
        personSet.add(new Person("郑中拓",20,3));
        personSet.add(new Person("郑中拓",24,4));
        personSet.add(new Person("郑中拓",25,5));
        System.out.println(personSet.size());//????  5
        System.out.println(personSet);
        //ClassCastException--->造型异常


    }
}
