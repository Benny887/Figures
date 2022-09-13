package Writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ResultWriter {

    public static PrintWriter getWriter(String fileName) throws FileNotFoundException {
        if (fileName != null) return new PrintWriter(fileName);
        else return null;
    }

}
