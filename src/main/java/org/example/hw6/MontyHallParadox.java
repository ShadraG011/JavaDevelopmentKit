package org.example.hw6;

import org.apache.commons.io.output.TeeOutputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class MontyHallParadox {
    private int countWinsWithChangeDoor = 0;
    private int countWinsWithoutChangeDoor = 0;
    private int countLosesWithChangeDoor = 0;
    private int countLosesWithoutChangeDoor = 0;
    static Random random = new Random();
    double chanceWinWithChangeDoor;
    double chanceWinWithoutChangeDoor;
    double chanceLoseWithChangeDoor;
    double chanceLoseWithoutChangeDoor;

    public static void main(String[] args) {
        String filePath = "src\\main\\java\\org\\example\\hw6\\log.txt";

        MontyHallParadox run = new MontyHallParadox();

        Scanner sc = new Scanner(System.in);

        String enter = " ";


        try {
            // Создаем объект File для указанного пути
            File file = new File(filePath);

            // Создаем новый объект FileOutputStream для записи в файл
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);

            // Создаем объект TeeOutputStream, который направляет вывод в консоль и в файл
            TeeOutputStream teeOutputStream = new TeeOutputStream(System.out, fileOutputStream);

            // Создаем новый объект PrintStream, который будет связан с TeeOutputStream
            PrintStream printStream = new PrintStream(teeOutputStream, false, StandardCharsets.UTF_8);

            // Сохраняем стандартный вывод (System.out) в отдельную переменную
            PrintStream originalOut = System.out;

            // Устанавливаем новый поток вывода
            System.setOut(printStream);

            while (!enter.equalsIgnoreCase("n")) {
                System.out.println("=============== Дата проверки парадокса Монти Холла: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss")) + " ===============");
                // Ваш код, который выводит строки в консоль и в файл
                run.startGame(1);
                run.startGame(2);
                run.startGame(3);
                System.out.println("\t---------------------------------------------------------------------------");
                run.startGame(1, 1);
                run.startGame(2, 1);
                run.startGame(3, 1);
                System.out.println("\t---------------------------------------------------------------------------");
                run.startGame(1, 2);
                run.startGame(2, 2);
                run.startGame(3, 2);
                System.out.println("\t---------------------------------------------------------------------------");
                run.startGame(1, 3);
                run.startGame(2, 3);
                run.startGame(3, 3);
                System.out.print("Проверить доказательство парадокса Монти Холла еще раз? (y/n) ");

                enter = sc.nextLine();
                System.out.println("\n======================================================================================\n\n");
            }
            // Восстанавливаем стандартный поток вывода
            System.setOut(originalOut);

            // Закрываем потоки вывода
            printStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame(int doorWithCar) {
        int personDoor;
        chanceWinWithChangeDoor = 0;
        chanceWinWithoutChangeDoor = 0;
        chanceLoseWithChangeDoor = 0;
        chanceLoseWithoutChangeDoor = 0;
        System.out.println("\t\t\t\tЕсли машина находиться за " + doorWithCar + " дверью");

        for (int i = 0; i < 1_000; i++) {
            personDoor = random.nextInt(1, 4);
            openDoor(personDoor, doorWithCar);
        }
        chanceWinWithChangeDoor = (double) countWinsWithChangeDoor / (countWinsWithChangeDoor + countLosesWithChangeDoor) * 100;
        chanceLoseWithChangeDoor = (double) countLosesWithChangeDoor / (countWinsWithChangeDoor + countLosesWithChangeDoor) * 100;
        chanceWinWithoutChangeDoor = (double) countWinsWithoutChangeDoor / (countWinsWithoutChangeDoor + countLosesWithoutChangeDoor) * 100;
        chanceLoseWithoutChangeDoor = (double) countLosesWithoutChangeDoor / (countWinsWithoutChangeDoor + countLosesWithoutChangeDoor) * 100;

        System.out.printf("\t\t\t\tШанс победить при смене двери %.2f %%\n" +
                "\t\t\t\tШанс проиграть при смене двери: %.2f %%\n", chanceWinWithChangeDoor, chanceLoseWithChangeDoor);
        System.out.printf("\t\t\t\tШанс победить без смены двери %.2f %%\n" +
                "\t\t\t\tШанс проиграть без смены двери: %.2f %%\n\n", chanceWinWithoutChangeDoor, chanceLoseWithoutChangeDoor);
    }

    private void startGame(int personDoor, int doorWithCar) {
        chanceWinWithChangeDoor = 0;
        chanceWinWithoutChangeDoor = 0;
        chanceLoseWithChangeDoor = 0;
        chanceLoseWithoutChangeDoor = 0;
        System.out.println("\t\t\t\tЕсли машина находиться за " + doorWithCar + " дверью");
        for (int i = 0; i < 1_000; i++) {
            openDoor(personDoor, doorWithCar);
        }

        chanceWinWithChangeDoor = (double) countWinsWithChangeDoor / (countWinsWithChangeDoor + countLosesWithChangeDoor) * 100;
        chanceLoseWithChangeDoor = (double) countLosesWithChangeDoor / (countWinsWithChangeDoor + countLosesWithChangeDoor) * 100;
        chanceWinWithoutChangeDoor = (double) countWinsWithoutChangeDoor / (countWinsWithoutChangeDoor + countLosesWithoutChangeDoor) * 100;
        chanceLoseWithoutChangeDoor = (double) countLosesWithoutChangeDoor / (countWinsWithoutChangeDoor + countLosesWithoutChangeDoor) * 100;

        System.out.printf("\t\t\t\tШанс победить при смене " + personDoor + " двери на другую: %.2f %%\n" +
                "\t\t\t\tШанс проиграть при смене " + personDoor + " двери на другую: %.2f %%\n", chanceWinWithChangeDoor, chanceLoseWithChangeDoor);
        System.out.printf("\t\t\t\tШанс победить без смены " + personDoor + " двери на другую: %.2f %%\n" +
                "\t\t\t\tШанс проиграть без смены " + personDoor + " двери на другую: %.2f %%\n\n", chanceWinWithoutChangeDoor, chanceLoseWithoutChangeDoor);
    }

    private void openDoor(int personDoor, int doorWithCar) {
        switch (personDoor) {
            case 1, 2, 3 -> {
                int doorWithGoat = openDoorWithGoat(personDoor, doorWithCar);
                changeChoose(personDoor, doorWithCar, doorWithGoat);
            }
        }
    }

    private int openDoorWithGoat(int personDoor, int doorWithCar) {
        switch (doorWithCar) {
            case 1 -> {
                switch (personDoor) {
                    case 1 -> {
                        return random.nextInt(2, 4);
                    }
                    case 2 -> {
                        return 3;
                    }
                    case 3 -> {
                        return 2;
                    }
                }
            }
            case 2 -> {
                switch (personDoor) {
                    case 1 -> {
                        return 3;
                    }
                    case 2 -> {
                        int choseDoor = random.nextInt(0, 2);
                        return choseDoor == 0 ? 1 : 3;
                    }
                    case 3 -> {
                        return 1;
                    }
                }
            }
            case 3 -> {
                switch (personDoor) {
                    case 1 -> {
                        return 2;
                    }
                    case 2 -> {
                        return 1;
                    }
                    case 3 -> {
                        return random.nextInt(1, 3);
                    }
                }
            }
        }
        return -1;
    }

    private void changeChoose(int personDoor, int doorWithCar, int doorWithGoat) {
        switch (personDoor) {
            case 1 -> {

                switch (doorWithGoat) {
                    case 2 -> {
                        if (random.nextBoolean()) {
                            personDoor = 3;
                            checkWinWithChange(personDoor, doorWithCar, true, true);
                        } else {
                            checkWinWithChange(personDoor, doorWithCar, false, false);

                        }
                    }

                    case 3 -> {
                        if (random.nextBoolean()) {
                            personDoor = 2;
                            checkWinWithChange(personDoor, doorWithCar, true, true);
                        } else {
                            checkWinWithChange(personDoor, doorWithCar, false, false);
                        }
                    }
                }
            }
            case 2 -> {

                switch (doorWithGoat) {
                    case 1 -> {
                        if (random.nextBoolean()) {
                            personDoor = 3;
                            checkWinWithChange(personDoor, doorWithCar, true, true);
                        } else {
                            checkWinWithChange(personDoor, doorWithCar, false, false);
                        }
                    }

                    case 3 -> {
                        if (random.nextBoolean()) {
                            personDoor = 1;
                            checkWinWithChange(personDoor, doorWithCar, true, true);
                        } else {
                            checkWinWithChange(personDoor, doorWithCar, false, false);
                        }
                    }
                }
            }
            case 3 -> {

                switch (doorWithGoat) {
                    case 1 -> {
                        if (random.nextBoolean()) {
                            personDoor = 2;
                            checkWinWithChange(personDoor, doorWithCar, true, true);
                        } else {
                            checkWinWithChange(personDoor, doorWithCar, false, false);
                        }
                    }

                    case 2 -> {
                        if (random.nextBoolean()) {
                            personDoor = 1;
                            checkWinWithChange(personDoor, doorWithCar, true, true);
                        } else {
                            checkWinWithChange(personDoor, doorWithCar, false, false);
                        }
                    }
                }
            }
        }
    }

    private void checkWinWithChange(int personDoor, int doorWithCar, boolean isChangeDoorWin,
                                    boolean isChangeDoorLose) {
        if (personDoor == doorWithCar) {
            if (isChangeDoorWin) countWinsWithChangeDoor++;
            else countWinsWithoutChangeDoor++;
        } else {
            if (isChangeDoorLose) countLosesWithChangeDoor++;
            else countLosesWithoutChangeDoor++;
        }
    }
}