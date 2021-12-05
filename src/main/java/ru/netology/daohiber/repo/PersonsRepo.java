package ru.netology.daohiber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.daohiber.entity.Person;
import ru.netology.daohiber.entity.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonsRepo extends JpaRepository<Person, PersonId> {


    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findByPersonIdAgeLessThanOrderByPersonIdAge(int age);

    Optional<Person> findTopByPersonIdNameAndPersonIdSurname(String name, String surname);




}
