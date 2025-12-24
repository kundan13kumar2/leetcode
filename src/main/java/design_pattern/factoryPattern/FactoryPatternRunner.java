package design_pattern.factoryPattern;

public class FactoryPatternRunner {
    public static void main(String[] args) {

        Shape rectangleShape = FactoryClient.createShape("Rectangle");
        Shape circleShape = FactoryClient.createShape("Circle");
        Shape squareShape = FactoryClient.createShape("Square");
        assert rectangleShape != null;
        rectangleShape.draw();
        assert circleShape != null;
        circleShape.draw();
        assert squareShape != null;
        squareShape.draw();

    }
}
