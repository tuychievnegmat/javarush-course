package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int sumSize = 0;
        for (Map.Entry<K, List<V>> kListHashMap : map.entrySet()) {
            sumSize += kListHashMap.getValue().size();
        }
        return sumSize;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if(map.containsKey(key)){
           int size = map.get(key).size();
            V v = map.get(key).get(size - 1);
            if(size < repeatCount){
                map.get(key).add(value);
            }else if (size == repeatCount){
                map.get(key).remove(0);
                map.get(key).add(value);
            }
            return v;
        }
        else{
            List<V> list = new ArrayList<V>();
            list.add(value);
            map.put(key, list);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if(map.containsKey(key)){
            int size = map.get(key).size();
            V v = map.get(key).get(0);
            if(size == 0){

                map.remove(key);
            }
            else if(size == 1){
                map.get(key).remove(0);
                map.remove(key);
            }
            else{
                map.get(key).remove(0);
            }
            return v;

        }else return null;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        Collection<V> collection = new ArrayList<V>();
        for (Map.Entry<K, List<V>> kListEntry : map.entrySet()) {
            collection.addAll(kListEntry.getValue());
        }
        return collection;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        boolean isContains = false;
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            if(entry.getValue().contains(value))isContains = true;

        }
        return isContains;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}