package com.javarush.task.task33.task3310.strategy;

import java.util.Map;

/**
 * Created by k-terra on 30.05.2019.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    //сделано
    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    //сделано
    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        for (Entry table : this.table) {
            for (Entry e = table; e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key),key,value,indexFor(hash(key),this.table.length));
    }

    //сделано
    @Override
    public Long getKey(String value) {
        if (value == null)
            return 0L;

        for (Entry table : this.table) {
            for (Entry e = table; e != null; e = e.next)
                if (value.equals(e.value))
                    return table.getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null == getEntry(key) ? null : getEntry(key).getValue();
    }

    int hash(Long k){
        return k.hashCode();
    }
    int indexFor(int hash, int length){
        return hash & (length-1);}

    //сделано
    Entry getEntry(Long key){
        if (size == 0)
            return null;

        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    //сделано
    void resize(int newCapacity){
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1 << 30)) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, (1 << 30) + 1);
    }

    //сделанно
    void transfer(Entry[] newTable){Entry[] src = table;
        int newCapacity = newTable.length;
        for (Entry e : table) {
            while(null != e) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }}

    //сделано
    void addEntry(int hash, Long key, String value, int bucketIndex){
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }
    void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry (hash, key, value, e);
        size++;
    }


}
