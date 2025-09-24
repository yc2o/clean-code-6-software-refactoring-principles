public class Cube implements Shape {
    private double side;
    public Cube(double side) {
        this.side = side;
    }
    public double calculate() {
        return side * side * side;
    }
}