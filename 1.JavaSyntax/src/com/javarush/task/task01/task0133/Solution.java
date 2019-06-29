package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        int secondsAfter15 = 30 * 60;
        System.out.println(getCountSecondsPassedInCurrentHour(secondsAfter15));
    }
    public static int getCountSecondsPassedInCurrentHour(int seconds) {
        //напишите тут ваш код
        int hour = seconds/3600;
        return seconds - hour * 3600;

    }
}