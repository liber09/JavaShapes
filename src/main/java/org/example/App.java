package org.example;

import java.util.*;

public class App {
    static ArrayList<Shape> createdShapesArrayList = new ArrayList<>();
    static HashSet<Shape> createdShapesHashSet = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String userSelection;
        ArrayList<Shape> shapes;
        boolean exit = false;

        do {
            System.out.println("MENU");
            System.out.println("--------------");
            System.out.println("1. Create random shapes and sort them by area");
            System.out.println("2. Create Shape and save in ArrayList");
            System.out.println("3. Print ArrayList of shapes");
            System.out.println("4. Create Shape and save in HashMap");
            System.out.println("5. Print HashMap of shapes");
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
                case "3" -> printList(createdShapesArrayList);
                case "4" -> {
                    var shape = createShape();
                    if (shape != null){
                        createdShapesHashSet.add(shape);
                    }
                }
                case "5" -> printHashSet(createdShapesHashSet);
                case "e" -> exit = true;
                default -> System.out.println("You made a incorrect choice! Try again.");
            }
        }while(!exit);
    }

    /*
    Method used to print the area of the shapes in an arraylist
     */
    private static void printList(ArrayList<Shape> shapes) {

        if(shapes.isEmpty()){
            System.out.println("There are no shapes in this list");
            return;
        }
        for (Shape shape : shapes) {
            System.out.printf(shape.getType() + " with area " + "%.2f%n", shape.getArea());
        }
    }
    private static void printHashSet(HashSet<Shape> shapes) {

        if(shapes.isEmpty()){
            System.out.println("There are no shapes in this list");
            return;
        }
        Shape shape;
        for (Shape value : shapes) {
            shape = value;
            System.out.printf(shape.getType() + " with area " + "%.2f%n", shape.getArea());
        }
    }

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
        boolean shapeCreated = false;
        do{
            System.out.println("What shape would you like to create (circle / rectangle)?");
            selectedShapeType = sc.nextLine();
            if (selectedShapeType.equalsIgnoreCase("circle")){
                System.out.println("How large radius has the circle?");
                double radius = sc.nextDouble();
                shape = Shape.CreateShape(radius);
                shapeCreated = true;
            }else if(selectedShapeType.equalsIgnoreCase("rectangle")){
                System.out.println("How wide is the rectangle?");
                double width = sc.nextDouble();
                System.out.println("How high is the rectangle?");
                double height = sc.nextDouble();
                shape = Shape.CreateShape(width, height);
                shapeCreated = true;
            }else{
                System.out.println("Incorrect choice, you can only type \"circle\" or \"rectangle\"");
            }

        }while(!shapeCreated);

        return shape;
    }
}
