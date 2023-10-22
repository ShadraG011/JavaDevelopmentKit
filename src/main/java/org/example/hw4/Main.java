package org.example.hw4;

// Создать класс справочник сотрудников, который содержит внутри
// коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
// Табельный номер
// Номер телефона
// Имя
// Стаж
// Добавить метод, который ищет сотрудника по стажу (может быть список)
// Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
// Добавить метод, который ищет сотрудника по табельному номеру
// Добавить метод добавление нового сотрудника в справочник сотрудников


import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        var persons = new ArrayList<Person>(
                List.of(
                        new Person(0, "46456456", "Алекс", 10),
                        new Person(1, "9575789", "Алекс", 12),
                        new Person(2, "575756", "Василий", 8),
                        new Person(3, "475675647", "Михаил", 9),
                        new Person(4, "56457567657", "Анжелика", 11),
                        new Person(5, "56457567657", "Анжелика", 11),
                        new Person(6, "45757567", "Александра", 15)));

        Person person = findByExperience(persons, 12);
        System.out.println("Сотрудник " + (person != null ? person : "не найден"));
        Person person2 = findByExperience(persons, 20);
        System.out.println("Сотрудник " + (person2 != null ? person2 : "не найден"));


        var phonesByName = findPhonesByName(persons, "Алекс");
        System.out.println("Сотрудники по имени Алекс : " + Arrays.toString(phonesByName));

//        var idsByName = findSomething(persons, p -> p.getName().equals("Анжелика"), Person::getPersonId);
//        System.out.println("ID'шники Анжелики: " + idsByName);

        Person person3 = findPersonById(persons, 5);
        System.out.println("Сотрудник " + (person3 != null ? person3 : "не найден"));

        add(persons, "1456456", "Вася", 5);
        add(persons, "45756", "Маша", 10);
        add(persons, "56767657", "Коля", 20);

        persons.forEach(System.out::println);
    }

    static Person findByExperience(List<Person> list, int experience) {
        return list.stream().filter(p -> p.getExperience() == experience).findAny().orElse(null);
    }

    static Object[] findPhonesByName(List<Person> list, String name) {
        return list.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .map(Person::getPhone).toArray();
    }

    static <R> List<R> findSomething(List<Person> list, Predicate<Person> filter, Function<Person, R> mapper) {
        return list.stream().filter(filter).map(mapper).toList();
    }

    static Person findPersonById(List<Person> list, int id) {
        return list.stream().filter(person -> person.getPersonId() == id).findAny().orElse(null);
    }

    static void add(ArrayList<Person> list, String phone, String name, int experience) {
        int lastId = list.stream().max(Comparator.comparingInt(Person::getPersonId)).get().getPersonId();
        list.add(new Person(lastId + 1, phone, name, experience));
    }
}

class Person {
    int personId;
    String phone;
    String name;
    int experience;

    public Person(int personId, String phone, String name, int experience) {
        this.personId = personId;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public int getPersonId() {
        return personId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("Табельный номер: %d, Имя: %s, Телефон: %s, Стаж: %d", personId, name, phone, experience);
    }

}
