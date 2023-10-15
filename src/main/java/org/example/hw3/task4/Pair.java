package org.example.hw3.task4;

public class Pair<F, S> {

    F itemFirst;
    S itemSecond;

    public Pair(F itemFirst, S itemSecond) {
        this.itemFirst = itemFirst;
        this.itemSecond = itemSecond;
    }

    public F getFirst() {
        return itemFirst;
    }

    public S getSecond() {
        return itemSecond;
    }

    @Override
    public String toString() {
        return "Pair:\n" +
                "Первое значение = \"" + itemFirst + "\" класса " + itemFirst.getClass().getSimpleName() +
                "\nВторое Значение = \"" + itemSecond + "\" класса " + itemSecond.getClass().getSimpleName() + "\n";
    }
}
