package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

/**
 * Created by k-terra on 29.05.2019.
 */
public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();
    @Override
    public boolean containsKey(Long key) {
        if(data.containsKey(key))return true;
        else return false;
    }

    @Override
    public boolean containsValue(String value) {
        if(data.containsValue(value))return true;
        else return false;
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        Long keyId = null;
        for (HashMap.Entry<Long, String> o :data.entrySet()) {
            if(o.getValue().equals(value))keyId = o.getKey();
        }
        return keyId;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
