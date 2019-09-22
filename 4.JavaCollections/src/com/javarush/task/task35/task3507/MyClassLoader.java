package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyClassLoader extends ClassLoader {
    public Class<?> load(Path path) throws ClassNotFoundException, IOException {
        byte[] b = Files.readAllBytes(path);
        return defineClass(null, b, 0, b.length);
    }
}
