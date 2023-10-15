package org.example.hw2;

public class Main {

    public static void main(String[] args) {
        GeneralizedClass<String, String> generalizedClass1 = new GeneralizedClass<>("Hello ", "World!");
        GeneralizedClass<Integer, Integer> generalizedClass2 = new GeneralizedClass<>(128, 128);

        generalizedMethod(generalizedClass1);
        generalizedMethod(generalizedClass2);
    }

    /**
     * Обобщеный метод
     * @param generalizedClass объект обобщеного метода
     * @param <S> обобщеное значение 1
     * @param <I> обобщеное значение 2
     */
    public static <S, I> void generalizedMethod(GeneralizedClass<S, I> generalizedClass){
        if(generalizedClass.getObject1() instanceof String && generalizedClass.getObject2() instanceof String)
            System.out.println("Конкатинация: " + generalizedClass.getObject1() + generalizedClass.getObject2());
        else if (generalizedClass.getObject1() instanceof Integer && generalizedClass.getObject2() instanceof Integer){
            int result = (int)generalizedClass.getObject1() + (int)generalizedClass.getObject2();
            System.out.println("Сложение: " + result);
        }
    }
}
