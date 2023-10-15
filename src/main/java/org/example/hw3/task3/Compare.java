package org.example.hw3.task3;

public class Compare<T> {
    T[] array;

    public Compare(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public static <T, V> boolean compareArrays(Compare<T> array1, Compare<V> array2) {
        T[] arr1 = array1.getArray();
        V[] arr2 = array2.getArray();
        if (arr1.length != arr2.length) return false;

        for (T t : arr1) {
            for (V t2 : arr2) {
                if (!(t.getClass().equals(t2.getClass()))) {
                    return false;
                }
            }
        }

        return true;

    }
}
