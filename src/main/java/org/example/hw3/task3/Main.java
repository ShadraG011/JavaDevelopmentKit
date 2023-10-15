package org.example.hw3.task3;

public class Main {
    public static void main(String[] args) {
        Compare<Integer> arrInt1 = new Compare<>(new Integer[]{1, 2, 3, 4, 5});
        Compare<Integer> arrInt2 = new Compare<>(new Integer[]{11, 22, 33, 44, 55});
        Compare<Integer> falseArrInt = new Compare<>(new Integer[]{11, 22, 33,});

        Compare<String> arrStr1 = new Compare<>(new String[]{"one", "two", "three", "four", "five"});
        Compare<String> arrStr2 = new Compare<>(new String[]{"eleven", "twenty two", "thirty three", "thirty four", "thirty five"});
        Compare<String> falseArrStr = new Compare<>(new String[]{"one", "two", "three"});


        System.out.println("_______Проверка массива Integer_______");
        System.out.println(String.format("Массивы arrInt1 и arrInt2 одинаковы: %s", Compare.compareArrays(arrInt1, arrInt2)));
        System.out.println(String.format("Массивы arrInt1 и falseArrInt одинаковы: %s", Compare.compareArrays(arrInt1, falseArrInt)));
        System.out.println(String.format("Массивы arrInt1 и arrStr1 одинаковы: %s", Compare.compareArrays(arrInt1, arrStr1)));
        System.out.println("\n_______Проверка массива String_______");
        System.out.println(String.format("Массивы arrStr1 и arrStr2 одинаковы: %s", Compare.compareArrays(arrStr1, arrStr2)));
        System.out.println(String.format("Массивы arrStr2 и falseArrStr одинаковы: %s",Compare.compareArrays(arrStr2, falseArrStr)));
        System.out.println(String.format("Массивы arrStr2 и arrInt2 одинаковы: %s",Compare.compareArrays(arrStr2, arrInt2)));


    }
}
