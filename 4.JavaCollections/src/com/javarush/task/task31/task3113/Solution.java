package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private int dirsCount = -1;
    private int filesCount;
    private long size;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesCount++;
            size += attrs.size();
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        dirsCount++;
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
            return;
        }
        Solution fileVisitor = new Solution();
        Files.walkFileTree(path, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, fileVisitor);
        System.out.printf("Всего папок - %d\n", fileVisitor.dirsCount);
        System.out.printf("Всего файлов - %d\n", fileVisitor.filesCount);
        System.out.printf("Общий размер - %d\n", fileVisitor.size);
    }
}