package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(args[0]);
        List<FileInputStream> inputStreams = Arrays.stream(args).skip(1).sorted().map(name -> {
            try {
                return new FileInputStream(name);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        ZipInputStream zin = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreams)));
        zin.getNextEntry();
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = zin.read(buffer)) != -1) {
            fos.write(buffer, 0, count);
        }
        zin.close();
        fos.close();
    }
}
/*В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002


Требования:
1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят аргументами в main, начиная со второго.
2. Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
3. Поток для чтения из архива должен быть закрыт.
4. Поток для записи в файл должен быть закрыт.*/