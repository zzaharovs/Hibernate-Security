package ru.netology.daohiber.service;

import ru.netology.daohiber.entity.Person;

import java.util.List;

public interface PersonsService {

    String  createPerson(Person person);

    String deletePerson(Person person);

    String updatePerson(Person person);

    List<Person> getPersonsByCity(String city);

    List<Person> getPersonsWhereYoungerThenAge(Integer age);

    Person getPersonByNameAndSurname(String name, String surname);

}
