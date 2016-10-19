package com.tradeshift;

import com.tradeshift.triangle.Triangle;
import com.tradeshift.triangle.exception.InvalidSideValueException;
import com.tradeshift.triangle.exception.InvalidTriangleException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by archviv on 10/16/16.
 */
public class TriangleTest {

    @Test(expected = InvalidSideValueException.class)
    public void testAllNegativeSides() {
        Triangle triangle = new Triangle(-1.0, -1.0, -1.0);
    }

    @Test(expected = InvalidSideValueException.class)
    public void testAllZeroSides() {
        Triangle triangle = new Triangle(0, 0, 0);
    }

    @Test(expected = InvalidSideValueException.class)
    public void testOneNegativeSide() {
        Triangle triangle = new Triangle(10.0, 98.0, -1.0);
    }

    @Test(expected = InvalidSideValueException.class)
    public void testOneZeroSide() {
        Triangle triangle = new Triangle(10.0, 98.0, 0);
    }

    @Test(expected = InvalidTriangleException.class)
    public void testInvalidTriangle() {
        Triangle triangle = new Triangle(1.0 ,2.0 ,3.0);
    }

    @Test
    public void testTriangleValues() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        Assert.assertEquals(3.0, triangle.getSideA(), 0.0001);
        Assert.assertEquals(4.0, triangle.getSideB(), 0.0001);
        Assert.assertEquals(5.0, triangle.getSideC(), 0.0001);
    }

    @Test
    public void testEquilateralTriangle() {
        Triangle triangle = new Triangle(10.0, 10.0, 10.0);
        Triangle.Type type = triangle.getType();
        Assert.assertEquals("This is not an equilateral triangle", Triangle.Type.EQUILATERAL, type);
    }

    @Test
    public void testIsoscelesTriangle() {
        Triangle triangle = new Triangle(10.0, 10.0, 4.0);
        Triangle.Type type = triangle.getType();
        Assert.assertEquals("This is not an isosceles triangle", Triangle.Type.ISOSCELES, type);
    }

    @Test
    public void testScaleneTriangle() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        Triangle.Type type = triangle.getType();
        Assert.assertEquals("This is not a scalene triangle", Triangle.Type.SCALENE, type);
    }

}
