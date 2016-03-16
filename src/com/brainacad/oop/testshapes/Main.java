package com.brainacad.oop.testshapes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidShapeStringException {

        Circle testCircle = new Circle("Blue", 10);

        System.out.println(testCircle);
        System.out.println("Circle area is: "+testCircle.calcArea());
        System.out.println("-------------------------------------");

        Rectangle testRect = new Rectangle("Black", 11, 22);

        System.out.println(testRect);
        System.out.println("Rectangle area is: "+testRect.calcArea());
        System.out.println("-------------------------------------");

        Triangle testTri = new Triangle("Orange", 5, 5, 5);

        System.out.println(testTri);
        System.out.println("Triangle area is: "+testTri.calcArea());
        System.out.println("-------------------------------------");

        Shape[] arr = {testCircle, new Circle("Blue", 3), testRect, new Rectangle("Brown", 5,8)
                ,testTri, new Triangle("Green", 3,4,5)};

        double sumArea = 0;
        double sumRectArea = 0;
        double sumCircleArea = 0;
        double sumTriangleArea = 0;

        for(Shape arrayElement : arr){
            System.out.println(arrayElement.toString() + ", area is: " + arrayElement.calcArea());
            sumArea+=arrayElement.calcArea();
            if(arrayElement instanceof Rectangle){
                sumRectArea+=arrayElement.calcArea();
            } if(arrayElement instanceof Circle){
                sumCircleArea+=arrayElement.calcArea();
            } if(arrayElement instanceof Triangle){
                sumTriangleArea+=arrayElement.calcArea();
            }
        }
        System.out.println("-------------------------------------");
        System.out.println("Total area of all shapes = "+sumArea);
        System.out.println("Rectangle total area: "+sumRectArea);
        System.out.println("Circle total area: "+sumCircleArea);
        System.out.println("Triangle total are: "+sumTriangleArea);
        System.out.println("-------------------------------------");

        //Lab 2.8.2

        Shape[] arr1 = {testRect,testTri,testCircle};

        for(Shape arrayElement : arr1){
            arrayElement.draw();
        }
        System.out.println("-------------------------------------");

        //Lab 2.8.3

        Rectangle testRectangleOne = new Rectangle("Red", 20, 10);
        Rectangle testRectangleTwo = new Rectangle("Red", 10, 10);

        System.out.println(testRectangleOne.compareTo(testRectangleTwo));
        System.out.println("-------------------------------------");

        //Lab 2.8.4

        Rectangle[] arr2 = {testRect,testRectangleOne,testRectangleTwo,
                new Rectangle("Black", 20, 20), new Rectangle("White", 5, 5), new Rectangle("Green", 10, 100)};
        Arrays.sort(arr2);
        for (Rectangle arrayElement : arr2){
            arrayElement.draw();
        }
        System.out.println("-------------------------------------");

        //Lab 2.10.4

        try {
            Shape.parseShape("Rectangle:RED:10,20");
            Shape.parseShape("Triangle:BLUE:3,4,5");
            Shape.parseShape("Circle:GREY:10");
            System.out.println("All correct!");
        } catch (InvalidShapeStringException e){
            System.out.println(e.getMessage());
        }
        System.out.println("-------------------------------------");

        //added loop to repeat operation "n" times
        int n = 5;

        for(int i = 1; i<=n;i++) {
            System.out.print("Enter Shape: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            try {
                Shape.parseShape(input);
            } catch (InvalidShapeStringException e) {
                System.out.println(e.getMessage());
            }
            if(i < n){
                System.out.println("Try again!("+(n-i)+" attempts remaining)");
            } else {
                System.out.println("Game Over!");
            }
        }
    }
}
