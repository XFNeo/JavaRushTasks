package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes types){
        if (types == null) throw new IllegalArgumentException("Неизвестный тип картинки");
        switch (types){
            case BMP: return new BmpReader();
            case JPG: return new JpgReader();
            case PNG: return new PngReader();
            default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }


    }
}
/*4. Этот метод должен:
4.1. Для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG - JpgReader;
4.2. Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException("Неизвестный тип картинки").*/