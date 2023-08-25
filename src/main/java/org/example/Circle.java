package org.example;

public class Circle extends Shape{
    double radius;
    String type;

    public Circle(Double radius){
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double value){
        this.radius = value;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String value){
        this.type = value;
    }

    //Method that calculates the area of the circle
    @Override
    public double getArea() {
        return Math.PI*(radius*radius);
    }

    //Method that calculates the perimeter of the circle
    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    /*
    Compare two circles against each other and return positive if this is larger,
    negative if other is larger or 0 if equal area.
     */
    @Override
    public int compareTo(Shape anotherShape) {
        return (int) (this.getArea() - anotherShape.getArea());
    }
}

