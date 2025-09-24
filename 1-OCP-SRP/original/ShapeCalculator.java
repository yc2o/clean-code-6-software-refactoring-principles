package original;
/**
 *
 * @author Rasyid Institute ©2019
 */
public class ShapeCalculator {
    
    public ShapeCalculator() {
        
    }
    
    /**
     * 
     * @param dimension, options: 2 for 2D Shape, 3 for 3D Shape
     * @param idShape, options:
     *                      2D Shapes: rectangle, square, circle
     *                      3D Shapes: cube, cuboid, cone, sphere
     * @param factor1
     * @param factor2
     * @param factor3
     * @return area for 2D Shape or volume for 3D Shape
     */
    public double calculateAreaOrVolume(int dimension, String idShape, double factor1, double factor2, double factor3) {
        double result = 0;
        if (dimension == 2) { //will return area
            switch(idShape) {
                case "rectangle":
                    result = factor1 * factor2; //width * height
                    break;
                case "square":
                    result = factor1 * factor1; //side * side
                    break;
                case "circle":
                    result = 3.14 * factor1 * factor1; //PI * radius^2
                    break;
            }
        } else if (dimension == 3) { //will return volume
            switch(idShape) {
                case "cube":
                    result = factor1 * factor1 * factor1; //side * side * side
                    break;
                case "cuboid":
                    result = factor1 * factor2 * factor3; //length * width * height
                    break;
                case "cone":
                    result = 1/3 * factor1 * factor2; //(1/3) * base * height
                    break;
                case "sphere":
                    result = 4/3 * 3.14 * factor1 * factor1 * factor1; //(4/3) * PI * radius^3
                    break;
            }
        }
        return result;
    }
}