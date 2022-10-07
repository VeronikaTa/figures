package com.epam.rd.autotasks.figures;

import java.util.ArrayList;

class Quadrilateral extends Figure{
    Point a;
    Point b;
    Point c;
    Point d;
    double lengthA;
    double lengthB;
    double lengthC;
    double lengthD;

    Quadrilateral(Point a, Point b, Point c, Point d){
        if(a == null || b == null || c == null || d == null){
            throw new IllegalArgumentException();
        }
        ArrayList<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
       for(int i = 0; i < points.size() -1; i++){
           for(int j = 0; j < points.size() -1; j++){
               if(i == j){
                   continue;
               }
               if(points.get(i).getX() == points.get(j).getX() && points.get(i).getY() == points.get(j).getY()){
                   throw new IllegalArgumentException();
               }
           }
       }

        if((a.getX() == b.getX() && b.getX() == c.getX() && c.getX() == d.getX()) || (a.getY() == b.getY() && b.getY() == c.getY() && d.getY() == c.getY())){
            throw new IllegalArgumentException();
        }

        this.a = new Point(a.getX(), a.getY());
        this.b = new Point(b.getX(), b.getY());
        this.c = new Point(c.getX(), c.getY());
        this.d = new Point(d.getX(), d.getY());

        this.lengthA = segmentLengthCount(a, b);
        this.lengthB = segmentLengthCount(b,c);
        this.lengthC = segmentLengthCount(c, d);
        this.lengthD = segmentLengthCount(d, a);

    }

    @Override
    public double area() {
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a,c,d);
        double areaOfTriangle1 = triangle1.area();
        double areaOfTriangle2 = triangle2.area();
        return areaOfTriangle1 + areaOfTriangle2;
    }

    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")(" + b.getX() + "," + b.getY() + ")(" + c.getX() + "," + c.getY()+ ")(" + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {a, b, c, d};
        Point leftmostPoint = new Point(points[0].getX(), points[0].getY());
        for(Point point : points){
            if(point.getX() <= leftmostPoint.getX()){
                leftmostPoint = point;
            }
        }
        return leftmostPoint;
    }

    private double segmentLengthCount(Point a, Point b){
        Point start;
        Point end;
        if(a.getX() < b.getX()){
            start = new Point(a.getX(), a.getY());
            end = new Point(b.getX(), b.getY());
        }
        else{
            start = new Point(b.getX(), b.getY());
            end = new Point(a.getX(), a.getY());
        }
        double segmentLength = Math.sqrt(Math.pow((end.getX() - start.getX()), 2.0) + Math.pow((end.getY() - start.getY()), 2.0));
        return segmentLength;
    }
}
