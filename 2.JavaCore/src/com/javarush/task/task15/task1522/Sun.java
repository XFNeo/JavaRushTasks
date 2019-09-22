package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance;

    private Sun() {

    }

    public static Sun getInstance(){
        if (instance == null){
            return instance = new Sun();
        }else return instance;
    }
}
