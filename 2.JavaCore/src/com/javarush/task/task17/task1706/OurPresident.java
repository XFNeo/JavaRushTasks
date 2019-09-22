package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;
    static {
        synchronized (OurPresident.class){
            president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
/*Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.*/