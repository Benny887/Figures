package Start;



import Readers.ShapeParamsReader;
import Shapes.Shape;
import Shapes.ShapeFactory;
import Support.Config;
import Support.ShapeLogger;
import Support.ShapeParams;
import Writer.OptionalWriter;
import Writer.ResultWriter;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Logger;

public class ApplicationWork {

    private static final Logger LOGGER = Logger.getLogger(ApplicationWork.class.getName());

    public static void work(String[] args) {
        LOGGER.info(ShapeLogger.START);
        Config cfg = new Config(args);
        if (!cfg.isValid()) {
            LOGGER.warning(ShapeLogger.INCORRECT_DATA);
            return;
        }
        LOGGER.info(ShapeLogger.CHECK_INPUT_DATA_FINISHED);
        try (Scanner scanner = new Scanner(Path.of(cfg.getSrcFile()));
             PrintWriter writer = ResultWriter.getWriter(cfg.getDstFile())) {
            OptionalWriter realWriter = new OptionalWriter(writer);
            ShapeParamsReader reader = new ShapeParamsReader(scanner);
            LOGGER.info(ShapeLogger.READING_PARAMS);
            while (reader.hasNextShape()) {
                ShapeParams params = reader.readShapeParams();
                if (!params.isReadSuccess()) {
                    continue;
                }
                try {
                    Shape shape = ShapeFactory.buildShape(params);
                    LOGGER.info(ShapeLogger.WRITE_OUT);
                    realWriter.write(shape.getInfoSpec());
                } catch (IllegalArgumentException e) {
                    LOGGER.warning(ShapeLogger.INVALID_PARAMS);
                }
            }
            LOGGER.info(ShapeLogger.READ_FILE_COMPLETE);
        } catch (Throwable e) {
            LOGGER.severe(ShapeLogger.FATAL_ERROR);
        }
    }

}
