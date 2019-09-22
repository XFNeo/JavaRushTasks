package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int min = Integer.MAX_VALUE;
        while (fileInputStream.available()> 0){
            int read = fileInputStream.read();
            if (min > read){
                min = read;
            }
        }
        System.out.println(min);
        reader.close();
        fileInputStream.close();
    }
}
