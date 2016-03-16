package com.brainacad.oop.testshapes;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Triangle extends Shape implements Comparable {
    private double a;
    private double b;
    private double c;

    public Triangle(String shapeColor, double a, double b, double c) {
        super(shapeColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcArea() {
        double s = (a+b+c)/2;
        double area = Math.sqrt((s*(s-a)*(s-b)*(s-c)));
        return area;
    }

    @Override
    public String toString() {
        return "This is Triangle, color: "+getShapeColor()+", a = "+a+
                ", b = "+b+", c = "+c;
    }

    @Override
    public void draw() {
        System.out.println(toString()+", area is: "+calcArea());
    }

    @Override
    public int compareTo(Object o) {
        Triangle triangle = (Triangle) o;
        if(this.calcArea()>triangle.calcArea())return 1;
        if(this.calcArea()<triangle.calcArea())return -1;
        return 0;
    }

    //Lab 2.13.4

    public static Triangle parseTriangle(String str) throws InvalidShapeStringException{

        StringTokenizer stringTokenizer = new StringTokenizer(str, ":, ");
        String type = stringTokenizer.nextToken();

        String conditionTri = "(Triangle):[A-Z]+:\\d+,\\d+,\\d+";
        Pattern patternTwo = Pattern.compile(conditionTri);
        Matcher matcherTwo = patternTwo.matcher(str);

        if (!matcherTwo.matches())
            throw new InvalidShapeStringException("Invalid input");

        String color1 = stringTokenizer.nextToken();
        double a = Double.parseDouble(stringTokenizer.nextToken());
        double b = Double.parseDouble(stringTokenizer.nextToken());
        double c = Double.parseDouble(stringTokenizer.nextToken());
        return new Triangle(color1, a, b, c);
    }
}
