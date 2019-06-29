package com.javarush.task.task16.task1626;

/* Создание по образцу

Разберись, как работает программа.
По образу и подобию CountDownRunnable создай нить CountUpRunnable, которая выводит значения
в нормальном порядке — от 1 до number.
*/
public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable {
        //Add your code here - добавь код тут
        private int countIndexUp = 0;

        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    countIndexUp += 1;
                    System.out.println(toString());
                    if (countIndexUp == Solution.number) return;
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
