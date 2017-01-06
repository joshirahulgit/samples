package org.sundot.objectrelations.dependencysample;

/**
 * Created by rahul on 1/6/17.
 */
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        //Here Math is used temporary to serve Circle. Thus it shows dependency of Math on Circle.
        return Math.PI * radius * radius;
    }
}
