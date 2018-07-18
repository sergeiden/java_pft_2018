package ru.stga.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point (double x, double y){
    this.x = x;
    this.y = y;
  }
  public double distance(Point p2) {
    double dx = p2.x - x;
    double dy = p2.y - y;
    return Math.sqrt(dx*dx+dy*dy);
  }
}