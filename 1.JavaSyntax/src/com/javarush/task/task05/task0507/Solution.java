package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double number;
        List<Double> doubleList  = new ArrayList<>();


        while ((number = Double.parseDouble(reader.readLine())) != -1){
            doubleList.add(number);
        }
        System.out.println(average(doubleList));

    }
    public static double average(List<Double> doubleList){
        double average = 0;
        if (doubleList.size() > 0)
        {
            double sum = 0;
            for (int j = 0; j < doubleList.size(); j++) {
                sum += doubleList.get(j);
            }
            average = sum / doubleList.size();
        }
        return average;
    }
}

