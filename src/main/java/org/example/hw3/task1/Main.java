package org.example.hw3.task1;

public class Main{
    public static void main(String[] args) {

        System.out.println("__________Массив Integer__________");
        GenericArray<Integer> arrayInteger = new GenericArray<>();
        arrayInteger.add(1);
        arrayInteger.add(128);
        arrayInteger.add(256);
        arrayInteger.add(512);
        arrayInteger.add(1024);
        arrayInteger.add(2048);
        arrayInteger.add(4096);
        MyIterator<Integer> iteratorInteger = arrayInteger.getMyIterator();

        for (Integer item: iteratorInteger) {
            System.out.println(item);
        }

        System.out.println("\n__________Массив String__________");
        GenericArray<String> arrayString = new GenericArray<>();
        arrayString.add("one");
        arrayString.add("two");
        arrayString.add("three");
        arrayString.add("four");
        arrayString.add("five");
        arrayString.add("six");

        MyIterator<String> iteratorString = arrayString.getMyIterator();

        for (String item: iteratorString) {
            System.out.println(item);
        }
    }
}