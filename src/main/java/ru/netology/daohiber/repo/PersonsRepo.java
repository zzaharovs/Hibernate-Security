package ru.netology.daohiber.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.daohiber.entity.Person;
import ru.netology.daohiber.entity.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonsRepo extends JpaRepository<Person, PersonId> {


    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCity(@Param("city") String cityOfLiving);

    @Query("select p from Person p where p.personId.age < :age " +
            "order by p.personId.age")
    List<Person> findByAge(@Param("age") int age);

    @Query("select distinct p from Person p" +
            " where p.personId.name = :name and p.personId.surname = :surname" +
            " order by p.personId.surname")
    List<Optional<Person>> findByNameAndSurname(String name, String surname);




}
