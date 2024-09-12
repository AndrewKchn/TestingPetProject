package config;

import config.configLoader.ConfigLoader;

import java.util.Properties;

public class MavenProperties {
    private static final String MAVEN_PROPERTIES = "/maven.properties";
    private static final String ENVIRONMENT_PROPERTY = "environment";
    private static final String BROWSER = "browser";
    private Properties properties;

    private MavenProperties() {
        loadProperties();
    }

    public static Properties getMavenProperties() {
        return SingletonHolder.INSTANCE.properties;
    }

    public static String getCurrentEnvironment() {
        return getMavenProperties().getProperty(ENVIRONMENT_PROPERTY);
    }

    public static String getTestingBrowser() {
        return getMavenProperties().getProperty(BROWSER);
    }

    private void loadMavenProperties() {
        properties.putAll(ConfigLoader.loadProps(MAVEN_PROPERTIES));
    }

    private void loadProperties() {
        properties = new Properties();
        loadMavenProperties();
    }

    private static class SingletonHolder {

        static final MavenProperties INSTANCE = new MavenProperties();

        private SingletonHolder() {
        }
    }
}
