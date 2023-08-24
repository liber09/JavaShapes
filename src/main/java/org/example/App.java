package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the circle:");
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        System.out.println("The area of the circle is " + String.format("%.2f", c.getArea()) );
    }
}
