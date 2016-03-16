package com.brainacad.oop.testshapes;

import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Shape implements Drawable {
    private String shapeColor;

    public String getShapeColor() {
        return shapeColor;
    }

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    @Override
    public String toString() {
        return "This is Shape, color is: " + shapeColor;
    }

    public abstract double calcArea();

    /*Lab 2.10.4 and 2.13.3 - butthurt - changing course program during ongoing classes ain't good,
    * need to change labs' order according to new program. In this case it would have made my labs
    * progress much easier, but whatever... =) */

    public static Shape parseShape(String str) throws InvalidShapeStringException {

        StringTokenizer stringTokenizer = new StringTokenizer(str, ":, ");
        String type = stringTokenizer.nextToken();

        //change to if...if...if to switch/case as recommended

        switch (type) {
            case "Rectangle": return Rectangle.praseRectangle(str);
            case "Triangle": return Triangle.parseTriangle(str);
            case "Circle": return Circle.praseCircle(str);
            default:
                System.out.println("Invalid input!");
                return null;
        }
    }
}
