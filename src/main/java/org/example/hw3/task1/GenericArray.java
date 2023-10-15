package org.example.hw3.task1;
import java.util.Arrays;
import java.util.Iterator;

class MyIterator<T> implements Iterator<T>, Iterable<T>{

    T[] array;
    private Integer index = 0;

    public MyIterator(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(array);
    }

    @Override
    public boolean hasNext() {
        return (array.length > index);
    }

    @Override
    public T next() {
        if (hasNext()){
            return array[index++];
        }
        return null;
    }
}

public class GenericArray<T>{
    Object[] arr;

    GenericArray(){
       arr = new Object[0]; 
    }


    public void add(T t){
        Object[] temp_arr = new Object[arr.length + 1];
        
        for (int index = 0; index < arr.length; index++) {
            temp_arr[index] = arr[index];
        }
        temp_arr[temp_arr.length - 1] = t;
        
        arr = temp_arr;
    }

    public void remove(T t){
        Integer position = find(t);
        if (position != null) {
            Object[] temp_arr = new Object[arr.length - 1];
            
            for (int i = 0; i < position; i++) {
                temp_arr[i] = arr[i];
            }

            for (int i = position; i < arr.length -1; i++) {
                temp_arr[i] = arr[i + 1];
            }

            arr = temp_arr;
        }

    }

    public Integer find(T t){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(t)) return i;
        }
        return null;
    }

    public String info(){
        return Arrays.toString(arr);
    }

    public MyIterator<T> getMyIterator() {
        return (MyIterator<T>) new MyIterator<>(arr);
    }
}


