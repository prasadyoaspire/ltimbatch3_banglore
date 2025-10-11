package com.abc.springcore;

public class ShapeService {
    Shape shape;
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void findArea() {
        shape.area();
    }
}
