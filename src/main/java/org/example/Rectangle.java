package org.example;

import java.util.Objects;

public class Rectangle extends Shape {

    private double width;
    private double height;
    private String type;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public void setType(String value){
        this.type = value;
    }

    //Method that calculates the area of the rectangle
    @Override
    public double getArea() {
        return getWidth() * getHeight();
    }

    //Method that calculates the perimeter of the rectangle
    @Override
    public double getPerimeter() {
        return getWidth()+getWidth()+getHeight()+getHeight();
    }

    /*
    Compare two rectangles against each other and return positive if this is larger,
    negative if other is larger or 0 if equal area.
     */
    @Override
    public int compareTo(Shape anotherShape) {
        return (int) (this.getArea() - anotherShape.getArea());
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Rectangle other)) return false;
        boolean areaEquals = this.getArea() == other.getArea();
        boolean typeEquals = Objects.equals(this.getType(), other.getType());
        return areaEquals && typeEquals;
    }

    /*
    when overriding equals you must also override hashCode. Now we can not save two equal objects in the hashset
     */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)getWidth() + (int)getHeight();
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}
