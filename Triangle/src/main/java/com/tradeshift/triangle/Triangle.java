package com.tradeshift.triangle;

import com.tradeshift.triangle.exception.InvalidSideValueException;
import com.tradeshift.triangle.exception.InvalidTriangleException;

/**
 * Created by archviv on 10/16/16.
 */
public class Triangle {

    public enum Type {
        EQUILATERAL,
        ISOSCELES,
        SCALENE;
    }

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        isValidTriangle(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return this.sideA;
    }

    public double getSideB() {
        return this.sideB;
    }

    public double getSideC() {
        return this.sideC;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new InvalidSideValueException("The sides of a triangle cannot be 0 or negative");
        }
        if (a+b <= c || b+c <= a || c+a <= b) {
            throw new InvalidTriangleException("Invalid triangle as triangle inequality is violated");
        }
        return true;
    }

    public Type getType() {
        if (sideA == sideB && sideB == sideC)
            return Type.EQUILATERAL;
        if (sideA == sideB || sideB == sideC || sideC == sideA)
            return Type.ISOSCELES;
        return Type.SCALENE;
    }

}
