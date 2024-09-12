package utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileUtil {
    //TODO: add LOGGER

    public static String loadFileAsString(String path) {
        System.out.println("Load file as String from resource: " + path);
        String fileContents = null;
        try (InputStream inputStream = FileUtil.class.getResourceAsStream(path)) {
            fileContents = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }
        return fileContents;
    }
}
