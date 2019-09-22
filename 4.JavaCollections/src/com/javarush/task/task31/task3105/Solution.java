package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ZipInputStream inputZip = new ZipInputStream(new FileInputStream(args[1]));
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        ZipEntry entry;
        while ((entry = inputZip.getNextEntry()) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = inputZip.read(buffer)) != -1)
                byteArrayOutputStream.write(buffer, 0, count);
            map.put(entry.getName(), byteArrayOutputStream);
        }
        inputZip.close();

        ZipOutputStream outputZip = new ZipOutputStream(new FileOutputStream(args[1]));
        for (Map.Entry<String, ByteArrayOutputStream> line : map.entrySet()) {
            if (!line.getKey().equals("new/"+Paths.get(args[0]).getFileName().toString())){
                entry = new ZipEntry(line.getKey());
                outputZip.putNextEntry(entry);
                outputZip.write(line.getValue().toByteArray());
            }

        }
        outputZip.putNextEntry(new ZipEntry("new/" + Paths.get(args[0]).getFileName().toString()));
        Files.copy((Paths.get(args[0])), outputZip);
        outputZip.close();


    }
}
/*В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.


Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.*/