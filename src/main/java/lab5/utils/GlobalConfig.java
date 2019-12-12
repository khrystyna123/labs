package lab5.utils;

import java.io.IOException;
import java.util.Properties;

public class GlobalConfig {
    private static final String CONFIG_PATH = "/";
    private static final String CONFIG_NAME = "config.properties";
    private final Properties globalConfig;

    {
        globalConfig = new Properties();
    }

    public void loadGlobalConfig() throws IOException {
        loadGlobalConfig(null);
    }

    public void loadGlobalConfig(String name) throws IOException {
        if (name != null && !name.trim().isEmpty()) {
            globalConfig.load(getClass().getResourceAsStream(CONFIG_PATH + name));
        } else {
            globalConfig.load(getClass().getResourceAsStream(CONFIG_PATH + CONFIG_NAME));
        }
    }

    public String getProperty(String property) {
        return globalConfig.getProperty(property);
    }
}