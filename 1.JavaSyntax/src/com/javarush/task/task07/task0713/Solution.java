package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> all = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Random rnd = new Random(100);
        for (int i = 0; i < 20; i++)
            all.add(Integer.parseInt(reader.readLine()));// = Integer.parseInt(reader.readLine());//rnd.nextInt(100);
        reader.close();

        for(int i = 0;i < 20;i++){
            if(all.get(i)%3 == 0 && all.get(i)%2 ==0){
                list3.add(all.get(i));
                list2.add(all.get(i));
            }
            else if (all.get(i)%3 == 0){
                list3.add(all.get(i));
            }
            else if(all.get(i)%2 == 0){
                list2.add(all.get(i));
            }
            else {
                listOther.add(all.get(i));
            }
        }

        printList(list3);
        printList(list2);
        printList(listOther);

    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer i : list)
            System.out.println(i);
    }
}