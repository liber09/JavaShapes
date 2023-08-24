package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userSelection;
        ArrayList<Shape> shapes;

        do {
            System.out.println("MENU");
            System.out.println("--------------");
            System.out.println("1. Create random shapes");
            System.out.println("2. Create Shapes");
            userSelection = sc.nextLine();


            if (Objects.equals(userSelection, "1")) {
                shapes = createRandomShapes();
                System.out.println("List is now unsorted");
                printList(shapes);
                shapes.sort(null);
                System.out.println("List is now sorted by area");
                printList(shapes);
            }

        }while(!userSelection.equalsIgnoreCase("e"));


    }

    private static void printList(ArrayList<Shape> shapes) {
        for(int i = 0; i<shapes.size(); i++){
            Shape shape = shapes.get(i);
            System.out.printf("%.2f%n",shape.getArea());
        }
    }

    private static ArrayList<Shape> createRandomShapes() {
        Random rnd = new Random();
        ArrayList<Shape> createdShapes = new ArrayList<>();

        for(int i = 0; i<=3; i++){
           Circle rndCircle = new Circle(rnd.nextDouble(1,10));
           createdShapes.add(rndCircle);
           Rectangle rndRectangle = new Rectangle(rnd.nextDouble(1,10),rnd.nextDouble(1,10));
           createdShapes.add(rndRectangle);
        }
        return createdShapes;
    }
}
