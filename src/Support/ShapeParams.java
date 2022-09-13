package Support;


public class ShapeParams {

    private String kindOfShape;
    private String dimensions;
    private boolean readSuccess;


    public String getKindOfShape() {
        return kindOfShape;
    }

    public String getDimensions() {
        return dimensions;
    }

    public boolean isReadSuccess() {
        return readSuccess;
    }

    public void setKindOfShape(String kindOfShape) {
        this.kindOfShape = kindOfShape;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setReadSuccess(boolean readSuccess) {
        this.readSuccess = readSuccess;
    }

    public static String[] arrayOfDimensions(String dimensions) {
        return dimensions.replaceAll("\\s+", " ").trim().split(" ");
    }

}
