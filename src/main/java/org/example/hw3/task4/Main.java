package org.example.hw3.task4;

public class Main {
    public static void main(String[] args) {
        Pair<String, String> pair1 = new Pair<>("First item", "Second item");
        Pair<Integer, Integer> pair2 = new Pair<>(1, 2);
        Pair<String, Integer> pair3 = new Pair<>("First item", 2);
        Pair<Double, String> pair4 = new Pair<>(1.0, "Second item");

        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(pair3);
        System.out.println(pair4);
    }
}
