package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        switch (args[0]){
            case "-e": encrypt(args[1],args[2]); break;
            case "-d": decrypt(args[1],args[2]); break;
        }
    }

    public static void encrypt(String fileName, String fileOutputName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        FileOutputStream out = new FileOutputStream(fileOutputName);
        while (in.available()> 0){
            out.write(in.read()+1);
        }
        in.close();
        out.close();
    }

    public static void decrypt(String fileName, String fileOutputName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        FileOutputStream out = new FileOutputStream(fileOutputName);
        while (in.available()> 0){
            out.write(in.read()-1);
        }
        in.close();
        out.close();
    }

}
/*Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.*/