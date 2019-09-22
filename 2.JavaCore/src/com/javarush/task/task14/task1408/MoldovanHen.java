package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 12;
    }

    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %s яиц в месяц.", super.getDescription(), Country.MOLDOVA, getCountOfEggsPerMonth());
    }

}
