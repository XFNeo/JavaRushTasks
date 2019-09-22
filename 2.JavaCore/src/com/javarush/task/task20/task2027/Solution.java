package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String word : words) {
            Word tmp = new Word(word);
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (word.charAt(0) == crossword[i][j]) { //Первая буква слова совпадает
                        if (word.length() <= crossword[i].length - j) { // Помещается ли слово вправо
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i][j + cn]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j + cn, i);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                        if (word.length() <= j + 1) { // Помещается ли слово влево
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i][j - cn]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j - cn, i);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                        if (word.length() <= crossword.length - i) { // Помещается ли слово вниз
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i + cn][j]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j, i + cn);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                        if (word.length() <= i + 1) { // Помещается ли слово вверх
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i - cn][j]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j, i - cn);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                        if (word.length() <= crossword.length - i && word.length() <= crossword[i].length - j) {
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i + cn][j + cn]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j + cn, i + cn);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                        if (word.length() <= i + 1 && word.length() <= j + 1) {
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i - cn][j - cn]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j - cn, i - cn);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                        if (word.length() <= i + 1 && word.length() <= crossword[i].length - j) {
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i - cn][j + cn]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j + cn, i - cn);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                        if (word.length() <= crossword[i].length - i && word.length() <= j + 1) {
                            for (int cn = 1; cn < word.length(); cn++) {
                                if (word.charAt(cn) == crossword[i + cn][j - cn]) {
                                    if (cn == word.length() - 1) {
                                        tmp.setStartPoint(j, i);
                                        tmp.setEndPoint(j - cn, i + cn);
                                        list.add(tmp);
                                    }
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}