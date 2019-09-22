package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

public class dsa {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("AA", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {

        String tel = "+38(050)123-45-67";
//For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567
        System.out.println("callto://" + tel.replace("-","").replace("(","").replace(")",""));

    }
}
