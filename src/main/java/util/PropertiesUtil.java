package util;

import java.io.*;
import java.util.Properties;

/**
 * 外部properties读取工具类
 * @author lichen
 * @since 2020-09-15 11:01
 */
public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        boolean isLoad = initProperties(true);
        if(!isLoad){
            initProperties(false);
        }
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static String get(String key, String defaultValue) {
        if (PROPERTIES.isEmpty()) {
            throw new UnsupportedOperationException("配置未加载");
        }
        String value = PROPERTIES.getProperty(key, defaultValue);
        return value;
    }

    /**
     * 获取默认配置的值，这个值可以动态修改
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        return get(key, "");
    }

    private static boolean initProperties(boolean isJar) {
        InputStream is = null;
        boolean result = true;
        try {
            //获取当前目录
            String property = System.getProperty("user.dir");
            String fileName = "config.properties";

            File file = null;
            if(isJar){
                //读取当前jar目录下conf配置文件
                file = new File(property + File.separator + fileName);
                System.out.println(property + File.separator + fileName);
            }else {
                //读取classpath下配置文件
                file = new File(PropertiesUtil.class.getClassLoader().getResource(fileName).getFile());
            }

            PROPERTIES.clear();
            is = new FileInputStream(file);
            PROPERTIES.load(is);
        } catch (Exception e) {
            result = false;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    result = false;
                }
            }
        }
        return result;
    }
}
