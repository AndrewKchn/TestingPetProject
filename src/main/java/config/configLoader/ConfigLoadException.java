package config.configLoader;

public class ConfigLoadException extends RuntimeException {
    public ConfigLoadException(String message) {
        super(message);
    }
}