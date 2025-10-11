package com.abc.springcore;

public class Circle implements Shape {
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public void area() {
        double area = Math.PI*radius*radius;
        System.out.println("circle area: "+area);
    }
}
