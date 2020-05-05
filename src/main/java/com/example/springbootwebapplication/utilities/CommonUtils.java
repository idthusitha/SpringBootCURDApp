package com.example.springbootwebapplication.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * 
 * @author Thusitha Dissanayaka
 * 
 */
public class CommonUtils {
	final static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	private CommonUtils() {
	}

	public static Properties properties = null;
	private static CommonUtils instance = null;

	/**
	 * @return CommonUtils
	 */
	public static CommonUtils getInstance() {
		if (instance == null) {
			instance = new CommonUtils();
		}
		return instance;
	}

	public String printTime(long startTime, String lable) {
		String time = "";
		try {
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			time = ((totalTime / 60000) % 60) + "m " + ((totalTime / 1000) % 60) + "s " + totalTime % 1000 + "ms";
			logger.warn("Total time for " + lable + ":" + ((totalTime / 60000) % 60) + "m " + ((totalTime / 1000) % 60) + "s " + totalTime % 1000 + "ms\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	public Properties getProperties() {

		Properties properties = null;
		try {
			java.util.Locale myLocale = java.util.Locale.getDefault();
			PropertyResourceBundle resource = (PropertyResourceBundle) PropertyResourceBundle.getBundle("application", myLocale);
			properties = convertResourceBundleToProperties(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;

	}

	private Properties convertResourceBundleToProperties(ResourceBundle resource) {
		Properties properties = new Properties();

		Enumeration<String> keys = resource.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			properties.put(key, resource.getString(key));
		}

		return properties;
	}

	public String getFile(String fileName) {
		StringBuilder result = new StringBuilder("");

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	public int getNumber(String number) {
		int numeric = 0;
		try {
			numeric = Integer.parseInt(number);
		} catch (Exception e) {
			numeric = 0;
		}
		return numeric;
	}
	
	public JSONObject objectToJSON(Object bean) {
		JSONObject json = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Field[] fields = bean.getClass().getDeclaredFields();

			for (Field f : fields) {
				String field = f.getName();
				Class t = f.getType();
				Class params[] = {};
				Object paramsObj[] = {};

				try {

					Method method = bean.getClass().getDeclaredMethod("get" + StringUtils.capitalise(field), params);
					Object v = method.invoke(bean, paramsObj);

					if (t == boolean.class && Boolean.FALSE.equals(v)) {
						json.accumulate(field, v != null ? v.toString() : null);

					} else if (t == Boolean.class && Boolean.FALSE.equals(v)) {
						json.accumulate(field, v != null ? v.toString() : null);

					} else if (t == Double.class || t == double.class || t == Float.class || t == float.class) {
						json.accumulate(field, v != null ? Double.parseDouble(v.toString()) : null);

					} else if (t == Long.class || t == Integer.class || t == long.class || t == int.class || t == short.class || t == byte.class) {
						json.accumulate(field, v != null ? Long.parseLong(v.toString()) : null);

					} else if (t == Date.class) {
						json.accumulate(field, v != null ? sdf.format((Date) v) : null);

					} else if (t == String.class) {
						json.accumulate(field, v != null ? v.toString() : null);
					}
				} catch (Exception e) {
					logger.error("" + field + ":" + t.getName() + ":" + e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
