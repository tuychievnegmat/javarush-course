package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String str = Integer.toString(number);
        int sum = StrToInt(str.charAt(0)) + StrToInt(str.charAt(1)) + StrToInt(str.charAt(2));
        return sum;
    }
    public static int StrToInt(char a){
        String str = Character.toString(a);
        int numb = Integer.parseInt(str);
        return numb;
    }

}