package org.example;

public abstract class Shape implements Comparable<Shape>{

    public abstract String getType();
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract boolean equals(Object o);
    public abstract int hashCode();

    /*
    Method that can be used to create a new Circle. We know it is a circle because
    it only contains one parameter
     */
    public static Circle CreateShape(double x) {
        Circle c = new Circle(x);
        c.type = "Circle";
        return c;
    }

    /*
    Method that can be used to create a new Rectangle. We know it is a Rectangle because
    it contains two parameters
     */
    public static Rectangle CreateShape(double x, double y) {
        Rectangle r = new Rectangle(x,y);
        r.setType("Rectangle");
        return r;
    }

}

