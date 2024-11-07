import java.util.Scanner;

abstract class Shape {
    double dim1, dim2;

    Shape(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    abstract double printArea();
}

class Rectangle extends Shape {
    Rectangle(double a, double b) {
        super(a, b);
    }

    double printArea() { 
        System.out.printf("The area of the Rectangle is: " + (dim1 * dim2) + "\n");
        return 0;
    }

}

class Triangle extends Shape {
    Triangle(double a, double b) {
        super(a, b);
    }

    double printArea() {
        System.out.printf("The area of the Triangle is: " + ((dim1 * dim2) / 2) + "\n");
        return 0;
    }
}

class Circle extends Shape {
    Circle(double a, double b) {
        super(a, b);
    }

    double printArea() {
        System.out.printf("The area of the Circle is: " + (3.14 * dim1 * dim1) + "\n");
        return 0;
    }
}

class Area {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4, 5);
        Triangle t = new Triangle(10, 8);
        Circle c = new Circle(10, 10);
        Shape s;
        s = r;
        s.printArea();
        s = t;
        s.printArea();
        s = c;
        s.printArea();
    }
}
