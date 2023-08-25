package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    static ArrayList<Shape> createdShapesArrayList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userSelection;
        ArrayList<Shape> shapes;

        do {
            System.out.println("MENU");
            System.out.println("--------------");
            System.out.println("1. Create random shapes and sort them by area");
            System.out.println("2. Create Shapes");
            System.out.println("3. Print list of shapes");
            System.out.println("e. exit application");
            userSelection = sc.nextLine();

            switch (userSelection) {
                case "1" -> {
                    shapes = createRandomShapes();
                    System.out.println("List is now unsorted");
                    System.out.println("===============");
                    printList(shapes);
                    shapes.sort(null);
                    System.out.println("List is now sorted by area");
                    System.out.println("===============");
                    printList(shapes);
                }
                case "2" -> {
                   var shape = createShape();
                   if (shape != null){
                       createdShapesArrayList.add(shape);
                   }
                }
                case "3" -> {
                    printList(createdShapesArrayList);
                }
                default -> System.out.println("You made a incorrect choice! Try again.");
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

    private static Shape createShape() {

        Scanner sc = new Scanner(System.in);
        String selectedShapeType;
        Shape shape = null;

        System.out.println("What shape would you like to create (circle / rectangle)?");
        selectedShapeType = sc.nextLine();
        if (selectedShapeType.equalsIgnoreCase("circle")){
            System.out.println("How large radius has the circle?");
            double radius = sc.nextDouble();
            shape = Shape.CreateShape(radius);
        }
        if(selectedShapeType.equalsIgnoreCase("rectangle")){
            System.out.println("How wide is the rectangle?");
            double width = sc.nextDouble();
            System.out.println("How high is the rectangle?");
            double height = sc.nextDouble();
            shape = Shape.CreateShape(width, height);
        }
        return shape;
    }
}
