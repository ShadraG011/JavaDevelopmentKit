package org.example.hw3.task2;

public class Calculator {

    public static <T, V> Object sum(T item1, V item2) {
        if (item1 instanceof Double && item2 instanceof Double) {
            return (Double) item1 + (Double) item2;
        } else if (item1 instanceof String && item2 instanceof String) {
            return item1 + " " + item2;
        } else if (item1 instanceof Integer && item2 instanceof Integer) {
            return (Integer) item1 + (Integer) item2;
        } else {
            throw new RuntimeException("Error calculating");
        }
    }

    public static <T, V> Object multiply(T item1, V item2) {
        if (item1 instanceof String && item2 instanceof String) {
            throw new RuntimeException("Cannot multiply for String");
        } else if (item1 instanceof Double && item2 instanceof Double) {
            return (Double) item1 * (Double) item2;
        } else if (item1 instanceof Integer && item2 instanceof Integer) {
            return (Integer) item1 * (Integer) item2;
        } else {
            throw new RuntimeException("Error calculating");
        }
    }

    public static <T, V> Object divide(T item1, V item2) {
        if (item1 instanceof String || item2 instanceof String) {
            throw new RuntimeException("Cannot divide for String");
        } else if (item1 instanceof Double && item2 instanceof Double) {
            return (Double) item1 / (Double) item2;
        } else if (item1 instanceof Integer && item2 instanceof Integer) {
            return (Integer) item1 / (Integer) item2;
        } else {
            throw new RuntimeException("Error calculating");
        }
    }

    public static <T, V> Object subtract(T item1, V item2) {
        if (item1 instanceof String || item2 instanceof String) {
            throw new RuntimeException("Cannot subtract for String");
        } else if (item1 instanceof Double && item2 instanceof Double) {
            return (Double) item1 - (Double) item2;
        } else if (item1 instanceof Integer && item2 instanceof Integer) {
            return (Integer) item1 - (Integer) item2;
        } else {
            throw new RuntimeException("Error calculating");
        }
    }
}
