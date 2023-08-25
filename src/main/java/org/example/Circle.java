package org.example;

import java.util.Objects;

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
    Method compares if two circles are the same.
     */
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Circle other)) return false;
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
        result = prime * result + (int)getRadius();
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
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

