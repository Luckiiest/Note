package testannotation;

import java.io.Serializable;


public class Animal implements Serializable {

    public void eat(){
        System.out.println("父类的吃饭方法");
    }

}
