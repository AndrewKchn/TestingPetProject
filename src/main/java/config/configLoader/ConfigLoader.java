package config.configLoader;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigLoader {
    private static final String ERROR_LOADING_CONFIGURATION = "Error loading configuration: ";

    private static final ConcurrentHashMap<String, Properties> PROPS_MAP = new ConcurrentHashMap<>();

    public static Properties loadConfigProperties(Class<?> configClass, String file) {
        return PROPS_MAP.computeIfAbsent(file, key -> {
            Properties props = new Properties();
            try (InputStream inputStream = configClass.getResourceAsStream(file)) {
                props.load(inputStream);
            } catch (Exception e) {
                throw new ConfigLoadException(ERROR_LOADING_CONFIGURATION + e);
            }
            return props;
        });
    }

    public static Properties loadProps(String file) {
        try {
            return loadConfigProperties(ConfigLoader.class, file);
        } catch (Exception e) {
            throw new ConfigLoadException("Configuration file is missing " + file);
        }
    }


}
