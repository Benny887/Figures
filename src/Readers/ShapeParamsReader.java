package Readers;

import Shapes.ShapesKeys;
import Support.ShapeParams;

import java.util.List;
import java.util.Scanner;

public class ShapeParamsReader {

    private final Scanner scanner;

    public ShapeParamsReader(Scanner scan) {
        scanner = scan;
    }


    public ShapeParams readShapeParams() {
        ShapeParams params = new ShapeParams();
        List<String> shapes = List.of(ShapesKeys.CIRCLE.name(), ShapesKeys.RECTANGLE.name(), ShapesKeys.TRIANGLE.name());
        while (scanner.hasNextLine()) {
            String lineOfParams = scanner.nextLine().trim();
            if (lineOfParams.isEmpty()) continue;
            if (shapes.contains(lineOfParams))
                params.setKindOfShape(lineOfParams);
            else if (params.getKindOfShape() != null)
                params.setDimensions(lineOfParams);
            if (params.getKindOfShape() != null && params.getDimensions() != null) {
                params.setReadSuccess(true);
                break;
            }
        }
        return params;
    }

    public boolean hasNextShape() {
        return scanner.hasNextLine();
    }

}
