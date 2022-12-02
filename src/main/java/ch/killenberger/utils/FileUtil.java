package ch.killenberger.utils;

import java.io.File;
import java.io.IOException;

public abstract class FileUtil {

    public static String getFilePath(final File f) {
        if(f == null) {
            return null;
        }

        try {
            return f.getCanonicalPath();
        } catch (IOException e) {
            return f.getAbsolutePath();
        }
    }
}
