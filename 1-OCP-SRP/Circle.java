public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculate() {
        return Math.PI * radius * radius;
    }
}