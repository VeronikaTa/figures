package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

   private final Point a;
     private final Point b;
    private final Point c;
    private final double segmentLengthC;
    private final double segmentLengthA;
   private final double segmentLengthB;

    Triangle(Point a, Point b, Point c){
        if((a == null || b == null || c == null) ||  (a.getX() == b.getX() && a.getY() == b.getY()) || (a.getX() == c.getX() && a.getY() == c.getY()) || (b.getX() == c.getX() && b.getY() == c.getY())){
           throw new IllegalArgumentException();
        }
        if((a.getX() == b.getX() && b.getX() == c.getX()) || (a.getY() == b.getY() && b.getY() == c.getY())){
            throw new IllegalArgumentException();
        }
        this.segmentLengthC = segmentLengthCount(a, b);
        this.segmentLengthA = segmentLengthCount(b, c);
        this.segmentLengthB = segmentLengthCount(c, a);

        if(segmentLengthA + segmentLengthB <= segmentLengthC){
            throw  new IllegalArgumentException();
        }
        this.a = new Point(a.getX(), a.getY());
        this.b = new Point(b.getX(), b.getY());
        this.c = new Point(c.getX(), c.getY());
    }

    @Override
    public double area() {
        double area = 0;
        area = (Math.sqrt(Math.pow((Math.pow(segmentLengthA,2) + Math.pow(segmentLengthB,2) + Math.pow(segmentLengthC,2)),2) - 2*(Math.pow(segmentLengthA,4)+Math.pow(segmentLengthB,4) + Math.pow(segmentLengthC,4))))/4;
        return area;
    }

    @Override
    public String pointsToString() {
        return "("+a.getX() + "," + a.getY() + ")(" + b.getX() + "," + b.getY() + ")(" + c.getX() + "," + c.getY() + ")";
    }

    @Override
    public String toString() {
        return "Triangle[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        Point[] points = {a, b, c};
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
