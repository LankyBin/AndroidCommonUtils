package com.lanky.androidutils;

import java.lang.reflect.Method;

/**
 * @ClassName CommonUtils
 * @Description TODO
 * @Author LankyBin
 * @Date 2021/6/24 14:30
 * @Version 1.0
 */
public class CommonUtils {
    public static String getProp(String key, String defValue) {
        String value = defValue;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String) (get.invoke(c, key, "unknown"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return value;
        }
    }
    public static void setProp(String key, String string) {
        String value = string;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("set", String.class, String.class);
            get.invoke(c, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
