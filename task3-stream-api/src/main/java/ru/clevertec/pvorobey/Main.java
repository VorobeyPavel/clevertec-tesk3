package ru.clevertec.pvorobey;

import ru.clevertec.pvorobey.model.Animal;
import ru.clevertec.pvorobey.model.Car;
import ru.clevertec.pvorobey.model.Flower;
import ru.clevertec.pvorobey.model.House;
import ru.clevertec.pvorobey.model.Person;
import ru.clevertec.pvorobey.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();


    }

    private static void task1() throws IOException {

        AtomicInteger index = new AtomicInteger(0);

        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge()>=10 && animal.getAge()<=20)
                .sorted(Comparator.comparing(Animal::getAge))
                .collect(Collectors.groupingBy(animal -> index.getAndIncrement()/7))
                .getOrDefault(2, animals)
                .forEach(System.out::println);



    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> animal.getGender().equals("Female") ?
                        animal.getBread().toUpperCase() : animal.getBread())
                .forEach(System.out::println);


    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge()>30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .forEach(System.out::println);

    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long count = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println(count);


    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean isHungarian = animals.stream()
                .filter(animal -> animal.getAge()>=20 && animal.getAge()<=30)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
        System.out.println(isHungarian);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean isMaleOrFemale = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female"));
        System.out.println(isMaleOrFemale);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean isNoOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        System.out.println(isNoOceania);
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(animal -> System.out.println(animal.getAge()));


    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        OptionalInt minLengthBread = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(animal -> animal.length)
                .min();
        System.out.println(minLengthBread);

    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long countAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println(countAge);
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        OptionalDouble avrAge = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average();
        System.out.println(avrAge);
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
        people.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> person.getDateOfBirth().isBefore(LocalDate.now().minusYears(18).plusDays(1))
                && person.getDateOfBirth().isAfter(LocalDate.now().minusYears(27)))
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        //        Продолжить...
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}