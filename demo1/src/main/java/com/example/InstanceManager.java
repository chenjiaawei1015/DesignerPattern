package com.example;


import java.util.HashMap;
import java.util.Map;

public class InstanceManager {

    // 容器

    // 程序的开始,将多个单例类型进行注入到统一的管理类中

    private static Map<String, Object> mInstanceMap = new HashMap<>();

    private InstanceManager() {
    }

    public static void registerInstance(String key, Object instance) {
        if (!mInstanceMap.containsKey(key)) {
            mInstanceMap.put(key, instance);
        }
    }

    public static Object getInstance(String key) {
        return mInstanceMap.get(key);
    }
}
