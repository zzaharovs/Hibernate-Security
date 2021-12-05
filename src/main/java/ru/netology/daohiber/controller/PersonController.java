package ru.netology.daohiber.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.daohiber.entity.Person;
import ru.netology.daohiber.entity.PersonId;
import ru.netology.daohiber.service.PersonsService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/")
@Validated
@AllArgsConstructor
public class PersonController {

    private final PersonsService personsService;

    @PostMapping("/persons/create")
    public String createPerson(@RequestBody Person person) {
        return personsService.createPerson(person);
    }

    @PostMapping("/persons/delete")
    public String deletePerson(@RequestBody Person person) {
        return personsService.deletePerson(person);
    }

    @PostMapping("/persons/update")
    public String updatePerson(@RequestBody Person person) {
        return personsService.updatePerson(person);
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@NotBlank String city) {
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsWhereYoungerThenAge(@Min(0) Integer age) {
        return personsService.getPersonsWhereYoungerThenAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Person getPersonByNameAndSurname(@NotBlank String name, @NotBlank String surname) {
        return personsService.getPersonByNameAndSurname(name, surname);
    }
}
