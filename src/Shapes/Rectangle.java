package Shapes;

import Support.ShapeLogger;

import java.text.MessageFormat;
import java.util.logging.Logger;

public class Rectangle extends Shape {

    private static final Logger logger = Logger.getLogger(Rectangle.class.getName());

    private double sideA;
    private double sideB;
    private double diagonal;
    private double length;
    private double width;
    private String name;
    private double square;
    private double perimeter;


    public Rectangle(String dimensions) {
        super(dimensions);
        logger.info(MessageFormat.format("{0}{1}", ShapeLogger.CREATE_OBJECT, name));
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

    public double getDiagonal() {
        return diagonal;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }


    @Override
    protected void initMainParams(String[] s) {
        sideA = Double.parseDouble(s[0]);
        sideB = Double.parseDouble(s[1]);
    }


    @Override
    public boolean dimensionsValid(String[] countOfParams) {
        try {
            if (countOfParams.length != 2) return false;
            logger.info(ShapeLogger.CHECK_RECTANGLE);
            if (Double.parseDouble(countOfParams[0]) <= 0 || Double.parseDouble(countOfParams[1]) <= 0)
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    @Override
    protected void evaluateShape() {
        name = "Прямоугольник";
        square = sideA * sideB;
        perimeter = 2 * (sideA + sideB);
        diagonal = Math.sqrt(sideA * sideA + sideB * sideB);
        length = Math.max(sideA, sideB);
        width = Math.min(sideA, sideB);
    }


    @Override
    public String getInfoSpec() {
        return TYPE_FIGURE_WORD + name + "\n" + SQUARE_WORD + decimalFormat.format(square) + TYPE_SQUARE_MEASURE_WORD + "\n"
                + PERIMETER_WORD + decimalFormat.format(perimeter) + TYPE_MEASURE_WORD + "\n" + "Длина диагонали: " +
                decimalFormat.format(diagonal) + TYPE_MEASURE_WORD + "\n" + "Длина: " + decimalFormat.format(length) +
                TYPE_MEASURE_WORD + "\n" + "Ширина: " + decimalFormat.format(width) + TYPE_MEASURE_WORD + "\n\n";
    }

}
