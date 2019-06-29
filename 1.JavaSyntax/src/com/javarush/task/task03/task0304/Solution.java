package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static int addTenPercent(int i) {
        i+= i * 10 / 100;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(20));
    }
}
