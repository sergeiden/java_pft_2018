package ru.stga.pft.sandbox;

import ru.stga.pft.sandbox.Point;

public class TwoPointsDistance {

  public static void main(String[] args) {
    Point p1 = new Point(2,2);
    Point p2 = new Point(3,3);

    System.out.println("Расстояние между точками p1 и p2 равно " + distance (p1, p2) + " - вычисление через функцию");

    System.out.println("Расстояние между точками p1 и p2 равно " + p1.distance(p2) + " - вычисление через метод");

  }

  public static double distance(Point p1, Point p2) {
    double dx = p2.x - p1.x;
    double dy = p2.y - p1.y;
    return Math.sqrt(dx*dx+dy*dy);
  }

}