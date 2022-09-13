package Shapes;

import Support.ShapeLogger;

import java.util.logging.Logger;

public class Circle extends Shape {

    private static final Logger logger = Logger.getLogger(Circle.class.getName());

    private double radius;
    private double diameter;
    private String name;
    private double square;
    private double perimeter;


    public Circle(String dimensions) {
        super(dimensions);
        logger.info(ShapeLogger.CREATE_OBJECT + name);
    }

    public String getName() {
        return name;
    }

    public double getSquare() {
        return square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    protected void initMainParams(String[] s) {
        radius = Double.parseDouble(s[0]);
    }


    @Override
    protected void evaluateShape() {
        name = "Круг";
        diameter = radius * 2;
        square = Math.PI * radius * radius;
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    public boolean dimensionsValid(String[] countOfParams) {
        try {
            if (countOfParams.length != 1) return false;
            logger.info(ShapeLogger.CHECK_CIRCLE);
            if (Double.parseDouble(countOfParams[0]) <= 0) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String getInfoSpec() {
        return TYPE_FIGURE_WORD + name + "\n" + SQUARE_WORD + decimalFormat.format(square) + TYPE_SQUARE_MEASURE_WORD + "\n" + PERIMETER_WORD
                + decimalFormat.format(perimeter) + TYPE_MEASURE_WORD + "\n" + "Радиус: " + decimalFormat.format(radius) + TYPE_MEASURE_WORD + "\n" +
                "Диаметр: " + decimalFormat.format(diameter) + TYPE_MEASURE_WORD + "\n\n";
    }
}
