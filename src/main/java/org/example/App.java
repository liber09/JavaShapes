package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class App {
    ArrayList<Shape> createdShapes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userSelection;
        ArrayList<Shape> shapes;

        do {
            System.out.println("MENU");
            System.out.println("--------------");
            System.out.println("1. Create random shapes and sort them by area");
            System.out.println("2. Create Shapes");
            userSelection = sc.nextLine();

            switch(userSelection) {
                case "1": {
                    shapes = createRandomShapes();
                    System.out.println("List is now unsorted");
                    printList(shapes);
                    shapes.sort(null);
                    System.out.println("List is now sorted by area");
                    printList(shapes);
                }
            }
            if (Objects.equals(userSelection, "1")) {

            }


        }while(!userSelection.equalsIgnoreCase("e"));
    }

    /*
    Method used to print the area of the shapes in an arraylist
     */
    private static void printList(ArrayList<Shape> shapes) {
        for(int i = 0; i<shapes.size(); i++){
            Shape shape = shapes.get(i);
            System.out.printf(shape.getType() + " with area " + "%.2f%n",shape.getArea());
        }
    }

    /*
    Method that creates 8 shapes (4 circles and 4 rectangles), adds them to
    an arraylist and returns the list.
     */
    private static ArrayList<Shape> createRandomShapes() {
        Random rnd = new Random();
        ArrayList<Shape> createdShapes = new ArrayList<>();

        for(int i = 0; i<=3; i++){
            Circle rndCircle = new Circle(rnd.nextDouble(1,10));
            rndCircle.setType("Circle");
            createdShapes.add(rndCircle);
            Rectangle rndRectangle = new Rectangle(rnd.nextDouble(1,10),rnd.nextDouble(1,10));
            rndRectangle.setType("Rectangle");
            createdShapes.add(rndRectangle);
        }
        return createdShapes;
    }

    private static void createShapes() {

        Scanner sc = new Scanner(System.in);
        String selectedShapeType;

        System.out.println("What shape would you like to create (circle / rectangle)?");
        selectedShapeType = sc.nextLine();
        if (selectedShapeType.equalsIgnoreCase("circle")){
            System.out.println("How large radius has the circle?");
            double radius = sc.nextDouble();
            Circle circle = new Circle(radius);
        }
    }
}
