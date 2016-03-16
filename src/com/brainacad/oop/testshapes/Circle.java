package com.brainacad.oop.testshapes;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Circle extends Shape implements Comparable {
    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        double area = Math.PI*(Math.pow(radius, 2));
        return area;
    }

    @Override
    public String toString() {
        return "This is Circle, color: " + getShapeColor() +
                ", radius = "+radius;
    }

    @Override
    public void draw() {
        System.out.println(toString()+", area is: "+calcArea());
    }

    @Override
    public int compareTo(Object o) {
        Circle circle = (Circle)o;
        if(this.calcArea()>circle.calcArea())return 1;
        if(this.calcArea()<circle.calcArea())return -1;
        return 0;
    }

    //Lab 2.13.4

    public static Circle praseCircle(String str) throws InvalidShapeStringException{

        StringTokenizer stringTokenizer = new StringTokenizer(str, ":, ");
        String type = stringTokenizer.nextToken();

        String conditionCirc = "(Circle):[A-Z]+:\\d+";
        Pattern patternThree = Pattern.compile(conditionCirc);
        Matcher matcherThree = patternThree.matcher(str);

        if (!matcherThree.matches())
            throw new InvalidShapeStringException("Invalid input");

        String color2 = stringTokenizer.nextToken();
        double radius = Double.parseDouble(stringTokenizer.nextToken());
        return new Circle(color2, radius);
    }
}
