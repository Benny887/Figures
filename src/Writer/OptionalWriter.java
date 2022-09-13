package Writer;

import java.io.PrintWriter;

public class OptionalWriter {

    private final PrintWriter printWriter;

    public OptionalWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void write(String shapeInfo) {
        if (printWriter != null)
            printWriter.write(shapeInfo);
        else System.out.println(shapeInfo);
    }
}
