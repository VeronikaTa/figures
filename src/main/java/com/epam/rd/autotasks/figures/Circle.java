package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    Point center;
    double radius;

    Circle(Point center, double radius){
        if(center == null || radius <= 0){
            throw new IllegalArgumentException();
        }
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String pointsToString() {
        return "("+ center.getX() + "," + center.getY() + ")";
    }

    @Override
    public String toString() {
        return "Circle[" + pointsToString()
                 + radius +
                ']';
    }

    @Override
    public Point leftmostPoint() {
        Point leftMostPoint = new Point((center.getX() - radius), center.getY());
        return leftMostPoint;
    }
}
