package com.javarush.task.task02.task0205;

/* 
Прибавка к зарплате
*/
public class Solution {
    public static void main(String[] args) {
        hackSalary(700);
    }

    public static void hackSalary(int a) {
        a = a + 100;
        System.out.print("Твоя зарплата составляет: "+a+" долларов в месяц.");
    }
}
