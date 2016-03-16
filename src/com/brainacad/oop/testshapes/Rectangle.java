package com.brainacad.oop.testshapes;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rectangle extends Shape implements Comparable {
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        double area = width*height;
        return area;
    }

    @Override
    public String toString() {
        return "This is Rectangle, color: "+getShapeColor()+", width = "+width+
                ", height = "+height;
    }

    @Override
    public void draw() {
        System.out.println(toString()+", area is: "+calcArea());
    }

    @Override
    public int compareTo(Object o) {
        Rectangle rectangle = (Rectangle) o;
        if(this.calcArea()>rectangle.calcArea())return 1;
        if(this.calcArea()<rectangle.calcArea())return -1;
        return 0;
    }

    //Lab 2.13.4

    public static Rectangle praseRectangle(String str) throws InvalidShapeStringException{

        StringTokenizer stringTokenizer = new StringTokenizer(str, ":, ");
        String type = stringTokenizer.nextToken();

        String conditionRec = "(Rectangle):[A-Z]+:\\d+,\\d+";
        Pattern patternOne = Pattern.compile(conditionRec);
        Matcher matcherOne = patternOne.matcher(str);

        if (!matcherOne.matches())
            throw new InvalidShapeStringException("Invalid input");

        String color = stringTokenizer.nextToken();
        double width = Double.parseDouble(stringTokenizer.nextToken());
        double height = Double.parseDouble(stringTokenizer.nextToken());
        return new Rectangle(color, width, height);
    }
}
