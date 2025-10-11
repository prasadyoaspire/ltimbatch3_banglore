package com.abc.springcore;

public class Rectangle implements  Shape {

    private int length;
    private int breadth;

    public void setLength(int length) {
        this.length = length;
    }
    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
    @Override
    public void area() {
        double area = length*breadth;
        System.out.println("rectangle area: "+area);
    }
}
