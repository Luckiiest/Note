package testmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {

    public static void main(String[] args){
        //创建一个HashMap对象
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        //将一些key-value的映射关系存入集合
        map.put(2,"bbb");
        map.put(5,"eee");
        map.put(6,"aaa");//key不同 value与1相同
        map.put(4,"ddd");
        map.put(3,"ccc");
        map.put(5,"xxx");//key相同 value与之前的5不同
        map.put(1,"aaa");

        Set<Entry<Integer,String>> entrys = map.entrySet();//获取集合中全部的entry对象
        Iterator<Entry<Integer,String>> it = entrys.iterator();
        while(it.hasNext()){
            Entry<Integer,String> entry = it.next();//entry  key value
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"--"+value);
        }


//        map.putIfAbsent(20,"yyy");
//        System.out.println(map);
//
//        System.out.println(map.getOrDefault(10,"1000"));
//
//        //获取map集合的全部key
//        Set<Integer> keys = map.keySet();
//        //通过迭代器遍历keys
//        Iterator<Integer> it = keys.iterator();
//        while(it.hasNext()){
//            Integer key = it.next();
//            String value = map.get(key);
//            System.out.println(key+"---"+value);
//        }


//        System.out.println(map);
//        map.remove(3);
//        System.out.println(map);
    }

}
