package test;
import util.*;

public class TestMain {
    public static void main(String[] args){
        ArrayBox ab = new ArrayBox();
        ab.add(10);
        ab.remove(0);
        ab.get(0);
        ab.size();

        LinkedBox lb = new LinkedBox();
        lb.add(10);
        lb.remove(0);
        lb.get(0);
        lb.size();
    }
}
