package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;
        if (partOfContent != null && Files.readAllLines(file).stream().noneMatch(s -> s.contains(partOfContent))) return FileVisitResult.CONTINUE;
        if (minSize != 0 && attrs.size() < minSize) return FileVisitResult.CONTINUE;
        if (maxSize != 0 && attrs.size() > maxSize) return FileVisitResult.CONTINUE;
        foundFiles.add(file);
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int i) {
        this.minSize = i;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
/*1. В классе SearchFileVisitor нужно создать поля partOfName, partOfContent, minSize, maxSize и сеттеры для них.
2. В классе SearchFileVisitor нужно создать поле foundFiles и геттер для него. Поле должно быть сразу инициализировано.
3. Если в SearchFileVisitor задан критерий поиска partOfName, метод visitFile должен добавить файл в foundFiles, если в названии содержится строка partOfName.
4. Если в SearchFileVisitor задан критерий поиска partOfContent, метод visitFile должен добавить файл в foundFiles, если в содержимом встречается строка partOfContent.
5. Если в SearchFileVisitor задан критерий поиска maxSize, метод visitFile должен добавить файл в foundFiles, если размер файла меньше maxSize.
6. Если в SearchFileVisitor задан критерий поиска minSize, метод visitFile должен добавить файл в foundFiles, если размер файла больше minSize.
7. Метод visitFile должен быть реализован так, чтобы учитывать сразу несколько критериев поиска.*/