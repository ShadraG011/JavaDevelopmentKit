package org.example.hw5;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Задание.
 * Есть пять философов (потоки), которые могут либо обедать, либо размышлять.
 * Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
 * После каждого приема пищи философ должен размышлять
 * Не должно возникнуть общей блокировки
 * Философы не должны есть больше одного раза подряд
 */
public class Main {

    private final int TIME_FOR_EATING = 200;
    private final int TIME_FOR_THINKING = TIME_FOR_EATING / 2;

    private final int EATING_COUNT = 3;
    AtomicInteger philosopherNumber = new AtomicInteger(0);
    AtomicInteger countEating = new AtomicInteger(0);

    public static void main(String[] args) {
        Main main = new Main();
        main.philosophers();
    }

    public void philosophers() {

        Thread philosopher1 = new Thread(() -> {
            Thread.currentThread().setName("Философ 1");
            while (countEating.get() < EATING_COUNT) {
                if (philosopherNumber.get() == 1) {
                    canBeEat();
                    canBeThink();
                }
            }

        });

        Thread philosopher2 = new Thread(() -> {
            Thread.currentThread().setName("Философ 2");
            while (countEating.get() < EATING_COUNT) {
                if (philosopherNumber.get() == 2) {
                    canBeEat();
                    canBeThink();
                }
            }

        });

        Thread philosopher3 = new Thread(() -> {
            Thread.currentThread().setName("Философ 3");
            while (countEating.get() < EATING_COUNT) {
                if (philosopherNumber.get() == 3) {
                    canBeEat();
                    canBeThink();
                }
            }

        });

        Thread philosopher4 = new Thread(() -> {
            Thread.currentThread().setName("Философ 4");
            while (countEating.get() < EATING_COUNT) {
                if (philosopherNumber.get() == 4) {
                    canBeEat();
                    canBeThink();
                }
            }

        });

        Thread philosopher5 = new Thread(() -> {
            Thread.currentThread().setName("Философ 5");
            while (countEating.get() < EATING_COUNT) {
                if (philosopherNumber.get() == 5) {
                    canBeEat();
                    canBeThink();
                }
            }
        });


        Thread platonMainPhilosopher = new Thread(() -> {
            Thread.currentThread().setName("Платон (главный философ)");

            int philNum;
            for (int i = 0; i < EATING_COUNT; i++) {
                System.out.println("\n\n\t" + Thread.currentThread().getName() + " объявляет " + (i + 1) + " прием пищи!");
                countEating.set(i);
                philNum = 0;
                philosopherNumber.set(philNum);
                while (philNum < 5) {
                    philosopherNumber.set(++philNum);
                    try {
                        Thread.sleep((TIME_FOR_EATING + TIME_FOR_THINKING) * 5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            countEating.set(EATING_COUNT);

        });


        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();

        platonMainPhilosopher.start();

    }

    private void canBeEat() {
        System.out.printf("\n%s ест '%d-й раз' | продолжительность приема пищи: ", Thread.currentThread().getName(), (countEating.get() + 1));
        printTime(TIME_FOR_EATING);

    }

    private void canBeThink() {
        System.out.printf("\n%s размышляет | продолжительность размышления: ", Thread.currentThread().getName());
        printTime(TIME_FOR_THINKING);

    }

    private void printTime(int millis) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

