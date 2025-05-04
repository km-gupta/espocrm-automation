package com.espocrm.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

	// Static block to load properties only once
	static {
		try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file from path: " + CONFIG_FILE_PATH);
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public static String getBrowser() {
		return getProperty("browser");
	}

	public static String getAppUrl() {
		return getProperty("app.url");
	}

	public static String getUsername() {
		return getProperty("app.username");
	}

	public static String getPassword() {
		return getProperty("app.password");
	}
}
