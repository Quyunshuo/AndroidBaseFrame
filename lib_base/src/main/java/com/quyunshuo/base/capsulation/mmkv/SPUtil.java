package com.quyunshuo.base.capsulation.mmkv;

import com.tencent.mmkv.MMKV;

/**
 * @Author: QuYunShuo
 * @Time: 2020/4/13
 * @Class: MMKVUtil
 * @Remark: 使用MMKV替代SharedPreferences 对使用进行简单封装
 */
public final class SPUtil {

    public static void put(String key, Object value) {
        if (value instanceof String) {
            putString(key, (String) value);
        } else if (value instanceof Integer) {
            putInt(key, (int) value);
        } else if (value instanceof Long) {
            putLong(key, (long) value);
        } else if (value instanceof Float) {
            putFloat(key, (float) value);
        } else if (value instanceof Double) {
            putDouble(key, (double) value);
        } else if (value instanceof Boolean) {
            putBoolean(key, (boolean) value);
        }
    }

    public static void putString(String key, String value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static String getString(String key) {
        return MMKV.defaultMMKV().decodeString(key, "");
    }

    public static String getString(String key, String s) {
        return MMKV.defaultMMKV().decodeString(key, s);
    }

    public static void putInt(String key, int value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static int getInt(String key) {
        return MMKV.defaultMMKV().decodeInt(key, -1);
    }

    public static int getInt(String key, int def) {
        return MMKV.defaultMMKV().decodeInt(key, def);
    }

    public static void putLong(String key, long value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static long getLong(String key) {
        return MMKV.defaultMMKV().decodeLong(key, -1L);
    }

    public static long getLong(String key, long defValue) {
        return MMKV.defaultMMKV().decodeLong(key, defValue);
    }

    public static void putFloat(String key, float value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static float getFloat(String key) {
        return MMKV.defaultMMKV().decodeFloat(key, -1.0f);
    }

    public static float getFloat(String key, float def) {
        return MMKV.defaultMMKV().decodeFloat(key, def);
    }

    public static void putDouble(String key, double value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static double getDouble(String key) {
        return MMKV.defaultMMKV().decodeDouble(key, -1.0D);
    }

    public static double getDouble(String key, double def) {
        return MMKV.defaultMMKV().decodeDouble(key, def);
    }

    public static void putBoolean(String key, boolean value) {
        MMKV.defaultMMKV().encode(key, value);
    }

    public static boolean getBoolean(String key) {
        return MMKV.defaultMMKV().decodeBool(key, false);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return MMKV.defaultMMKV().decodeBool(key, defaultValue);
    }
}
