package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        File rootDir = new File(root);
        Stack<File> stack = new Stack<>();
        stack.push(rootDir);
        while (!stack.isEmpty()){
            File child = stack.pop();
            if (child.isDirectory()){
                for(File f : child.listFiles()) stack.push(f);
            } else {
                result.add(child.getAbsolutePath());
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        for (String arg : getFileTree("D:\\VMs")) {
            System.out.println(arg);
        }
    }
}
/*Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).*/