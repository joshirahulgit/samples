package edu.sundot.covariantsample;

/**
 * Created by Rahul on 3/20/2017.
 */
public class SubClass1 extends SuperClass1{

    public SubClass2 method() {
        System.out.println("I am sub-class.");
        return new SubClass2();
    }
}
