package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by s.sergienko on 24.02.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes jpg)
    {
        if (jpg == ImageTypes.JPG)
            return new JpgReader();
                else if (jpg == ImageTypes.BMP)
                    return new BmpReader();
                        else if (jpg == ImageTypes.PNG)
                            return new PngReader();
                                else throw  new IllegalArgumentException("Неизвестный тип картинки");
    }
}
