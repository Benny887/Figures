package Support;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class Config {

    private String srcFile;
    private String dstFile;
    private boolean isValid;

    private static final Logger LOGGER = Logger.getLogger(Config.class.getName());

    public Config(String[] args) {
        if (validateInputData(args)) isValid = true;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getSrcFile() {
        return srcFile;
    }

    public String getDstFile() {
        return dstFile;
    }


    protected boolean validateInputData(String[] params) {
        LOGGER.info(ShapeLogger.CHECK_INPUT_DATA);
        if (params.length > 3 || params.length < 2) return false;
        if (params.length == 3 && params[1].equals("-f") && Files.exists(Path.of(params[0])) &&
                Files.exists(Path.of(params[2])) && !params[0].equals(params[2])) {
            srcFile = params[0];
            dstFile = params[2];
            return true;
        } else if ((params.length == 2 && Files.exists(Path.of(params[0])) && params[1].equals("-c"))) {
            srcFile = params[0];
            return true;
        }
        return false;
    }

}
