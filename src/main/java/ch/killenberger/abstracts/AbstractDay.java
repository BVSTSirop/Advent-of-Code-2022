package ch.killenberger.abstracts;

import ch.killenberger.utils.FileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AbstractDay {
    private static final String INPUT_PREFIX         = "input_day_";
    private static final String INPUT_FILE_EXTENSION = ".txt";
    private static final String RESOURCES_DIR_NAME   = "resources";
    private static final String INPUT_DIR_NAME       = "input";

    private static final String WORKING_DIR          = System.getProperty("user.dir");
    private static final String RESOURCES_DIR        = WORKING_DIR + File.separator + RESOURCES_DIR_NAME;
    private static final String INPUT_DIR            = RESOURCES_DIR + File.separator + INPUT_DIR_NAME;

    protected File inputFile;

    public AbstractDay(final String day) {
        if(day == null) {
            throw new IllegalArgumentException("Input path was null");
        }

        this.inputFile = new File(INPUT_DIR + File.separator + INPUT_PREFIX + day + INPUT_FILE_EXTENSION);
    }

    protected void checkInputFile() throws FileNotFoundException {
        if(this.inputFile == null || !this.inputFile.exists()) {
            throw new FileNotFoundException("File " + FileUtil.getFilePath(this.inputFile) + " does not exist");
        }
    }

    protected List<String> readInput() throws IOException {
        return Files.readAllLines(this.inputFile.toPath());
    }
}
