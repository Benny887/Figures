package Shapes;

import Support.ShapeParams;

import java.text.DecimalFormat;

public abstract class Shape {

    protected static final String TYPE_MEASURE_WORD = " мм";
    protected static final String TYPE_SQUARE_MEASURE_WORD = " кв.мм";
    protected static final String SQUARE_WORD = "Площадь: ";
    protected static final String TYPE_FIGURE_WORD = "Тип фигуры: ";
    protected static final String PERIMETER_WORD = "Периметр: ";


    protected Shape(String dimensions) {
        if (dimensionsValid(ShapeParams.arrayOfDimensions(dimensions))) {
            initMainParams(ShapeParams.arrayOfDimensions(dimensions));
            evaluateShape();
        } else throw new IllegalArgumentException();
    }

    protected DecimalFormat decimalFormat = new DecimalFormat("#.##");


    protected abstract boolean dimensionsValid(String[] countOfParams);

    protected abstract void initMainParams(String[] s);

    protected abstract void evaluateShape();

    public abstract String getInfoSpec();

}
