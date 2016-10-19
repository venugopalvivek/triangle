package com.tradeshift.triangle;

import java.util.Scanner;

/**
 * Created by archviv on 10/16/16.
 */
public class TriangleChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sideA = getValueForSide(scanner, 1);
        double sideB = getValueForSide(scanner, 2);
        double sideC = getValueForSide(scanner, 3);
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        System.out.print("Triangle is of type " + triangle.getType());
    }

    private static double getValueForSide(Scanner scanner, int side) {
        System.out.println("Enter a long value for a triangle side " + side + ":");
        while (!scanner.hasNextDouble()) {
            System.out.println("Enter a long value for a triangle side " + side + ":");
            scanner.nextLine();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();

        return value;
    }

}
