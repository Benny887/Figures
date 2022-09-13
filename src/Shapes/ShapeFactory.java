package Shapes;


import Support.ShapeParams;

public class ShapeFactory {

    public static Shape buildShape(ShapeParams params) {
        if (params.getKindOfShape().equals(ShapesKeys.CIRCLE.name())) {
            return new Circle(params.getDimensions());
        }
        if (params.getKindOfShape().equals(ShapesKeys.RECTANGLE.name())) {
            return new Rectangle(params.getDimensions());
        }
        if (params.getKindOfShape().equals(ShapesKeys.TRIANGLE.name())) {
            return new Triangle(params.getDimensions());
        } else throw new IllegalArgumentException();
    }

}
