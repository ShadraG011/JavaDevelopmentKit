package org.example.hw3.task2;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {


        Integer itemInteger1 = 128;
        Integer itemInteger2 = 256;

        Double itemDouble1 = 128.128;
        Double itemDouble2 = 256.256;

        String itemString1 = "Hello";
        String itemString2 = "World!";


        System.out.println("_________Проверка метода \"sum\"_________");
        System.out.println(Calculator.sum(itemInteger1, itemInteger2));
        System.out.println(Calculator.sum(itemDouble1, itemDouble2));
        System.out.println(Calculator.sum(itemString1, itemString2));

        System.out.println("\n_________Проверка метода \"subtract\"_________");
        System.out.println(Calculator.subtract(itemInteger1, itemInteger1));
        System.out.println(Calculator.subtract(itemDouble1, itemDouble2));
        try {
            System.out.println(Calculator.subtract(itemString1, itemString2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n_________Проверка метода \"multiply\"_________");
        System.out.println(Calculator.multiply(itemInteger1, itemInteger2));
        System.out.println(Calculator.multiply(itemDouble1, itemDouble2));
        try {
            System.out.println(Calculator.multiply(itemString1, itemString2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n_________Проверка метода \"divide\"_________");
        System.out.println(Calculator.divide(itemInteger2, itemInteger1));
        System.out.println(Calculator.divide(itemDouble2, itemDouble1));
        try {
            System.out.println(Calculator.divide(itemString1, itemString2));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
