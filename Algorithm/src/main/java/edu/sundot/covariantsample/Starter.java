package edu.sundot.covariantsample;

/**
 * Created by Rahul on 3/20/2017.
 */
public class Starter {
    public static void main(String[] args) {
        SuperClass1 superClass11=new SuperClass1();
        SuperClass1 superClass12=new SubClass1();
        System.out.println(superClass11.method());
        System.out.println(superClass12.method());
    }
}
