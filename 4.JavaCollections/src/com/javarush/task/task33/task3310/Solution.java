package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.nio.ShortBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by k-terra on 29.05.2019.
 */
public class Solution {
    public static void main(String[] args)
    {
       testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
    }
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){

        Set<Long> setId = new HashSet<>();
        for (String s : strings) {
            setId.add(shortener.getId(s));
        }
        return setId;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> setStr = new HashSet<>();
        for (Long number : keys) {
            setStr.add(shortener.getString(number));
        }
        return setStr;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        //6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
        System.out.println(strategy.getClass().getSimpleName());


        //6.2.3.2. Генерировать тестовое множество строк
        Set<String> strings = new HashSet<>();
        Long[] elements = new Long[(int) elementsNumber];

        for (int i = 0; i < elementsNumber; i++)
            strings.add(Helper.generateRandomString());

        //6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
        Shortener shortener = new Shortener(strategy);

        //6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
        Date startDateTime = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finishDateTime = new Date();

        long deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));

        //6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
        startDateTime = new Date();
        Set<String> strs = getStrings(shortener, ids);
        finishDateTime = new Date();

        deltaTime = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage(Long.toString(deltaTime));


        //6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings.
        if (strings.equals(strs))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
