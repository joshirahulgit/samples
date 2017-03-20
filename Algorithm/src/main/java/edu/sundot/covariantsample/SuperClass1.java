package edu.sundot.covariantsample;

/**
 * Created by Rahul on 3/20/2017.
 */
public class SuperClass1 {
    public SuperClass2 method(){
        System.out.println("I am super class.");
        return new SuperClass2();
    }
}
