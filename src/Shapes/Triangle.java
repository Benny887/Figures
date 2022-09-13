package Shapes;

import Support.ShapeLogger;

import java.util.logging.Logger;

public class Triangle extends Shape {

    private static final Logger logger = Logger.getLogger(Triangle.class.getName());

    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double firstSideOppositeAngle;
    private double secondSideOppositeAngle;
    private double thirdSideOppositeAngle;
    private String name;
    private double square;
    private double perimeter;

    private static final String OPPOSITE_ANGLE_WORD = "Противолежащий угол: ";
    private static final String COS_WORD = " cos.";
    private static final String SIDE_LENGTH_WORD = "Длина стороны ";


    public Triangle(String dimensions) {
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

    public double getFirstSideOppositeAngle() {
        return firstSideOppositeAngle;
    }

    public double getSecondSideOppositeAngle() {
        return secondSideOppositeAngle;
    }

    public double getThirdSideOppositeAngle() {
        return thirdSideOppositeAngle;
    }

    @Override
    public boolean dimensionsValid(String[] countOfParams) {
        try {
            if (countOfParams.length != 3) return false;
            logger.info(ShapeLogger.CHECK_TRIANGLE);
            double firstSide = Double.parseDouble(countOfParams[0]);
            double secondSide = Double.parseDouble(countOfParams[1]);
            double thirdSide = Double.parseDouble(countOfParams[2]);
            if (firstSide <= 0 || secondSide <= 0 || thirdSide <= 0 ||
                    (firstSide + secondSide + thirdSide - 2 * Math.max(Math.max(firstSide, secondSide), thirdSide) <= 0))
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    protected void initMainParams(String[] s) {
        firstSide = Double.parseDouble(s[0]);
        secondSide = Double.parseDouble(s[1]);
        thirdSide = Double.parseDouble(s[2]);
    }


    @Override
    protected void evaluateShape() {
        name = "Треугольник";
        double p = (firstSide + secondSide + thirdSide) / 2;
        square = Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
        perimeter = firstSide + secondSide + thirdSide;
        firstSideOppositeAngle = (secondSide * secondSide + thirdSide * thirdSide - firstSide * firstSide) / (2 * secondSide * thirdSide);
        secondSideOppositeAngle = (firstSide * firstSide + thirdSide * thirdSide - secondSide * secondSide) / (2 * firstSide * thirdSide);
        thirdSideOppositeAngle = (firstSide * firstSide + secondSide * secondSide - thirdSide * thirdSide) / (2 * firstSide * secondSide);
    }


    @Override
    public String getInfoSpec() {
        return TYPE_FIGURE_WORD + name + "\n" + SQUARE_WORD + decimalFormat.format(square) + TYPE_SQUARE_MEASURE_WORD + "\n" + PERIMETER_WORD +
                decimalFormat.format(perimeter) + TYPE_MEASURE_WORD + "\n" + SIDE_LENGTH_WORD + "А: " + decimalFormat.format(firstSide) +
                TYPE_MEASURE_WORD + "\n" + OPPOSITE_ANGLE_WORD + decimalFormat.format(firstSideOppositeAngle) + COS_WORD + "\n" + SIDE_LENGTH_WORD + "B: " +
                decimalFormat.format(secondSide) + TYPE_MEASURE_WORD + "\n" + OPPOSITE_ANGLE_WORD + decimalFormat.format(secondSideOppositeAngle) +
                COS_WORD + "\n" + SIDE_LENGTH_WORD + "C: " + decimalFormat.format(thirdSide) + TYPE_MEASURE_WORD + "\n" + OPPOSITE_ANGLE_WORD +
                decimalFormat.format(thirdSideOppositeAngle) + COS_WORD + "\n\n";
    }
}
