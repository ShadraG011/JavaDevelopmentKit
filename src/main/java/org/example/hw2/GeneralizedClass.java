package org.example.hw2;

/**
 * Обобщеный метод
 * @param <S> параметр 1
 * @param <I> параметр 2
 */
public class GeneralizedClass<S, I> {
    private S object1;
    private I object2;

    public GeneralizedClass(S object1, I object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public S getObject1() {
        return object1;
    }

    public I getObject2() {
        return object2;
    }
}
