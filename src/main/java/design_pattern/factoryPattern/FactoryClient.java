package design_pattern.factoryPattern;

public class FactoryClient {
    public static Shape createShape(String shapeType) {
        switch (shapeType) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            default:
                return null;
        }
    }
}
