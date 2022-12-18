package ru.netology.daohiber.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.daohiber.entity.Person;
import ru.netology.daohiber.service.PersonsService;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/")
@Validated
@AllArgsConstructor
public class PersonController {

    private final PersonsService personsService;

    @RolesAllowed("ROLE_CREATE")
    @PostMapping("/persons/create")
    public String createPerson(@RequestBody Person person) {
        return personsService.createPerson(person);
    }

    @PreAuthorize("hasAnyRole('WRITE','DELETE')")
    @PostMapping("/persons/delete")
    public String deletePerson(@RequestBody Person person) {
        return personsService.deletePerson(person);
    }

    @RolesAllowed("WRITE")
    @PostMapping("/persons/update")
    public String updatePerson(@RequestBody Person person) {
        return personsService.updatePerson(person);
    }

    @Secured(value = {"ROLE_READ"}) //старая реализация в спринге
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@NotBlank String city) {
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
//    @PreAuthorize("hasAuthority('ROLE_READ')")
    @PreAuthorize("hasAnyAuthority('ROLE_READ, ROLE_DELETE')")
    public List<Person> getPersonsWhereYoungerThenAge(@Min(0) Integer age) {
        System.out.printf("username");
        return personsService.getPersonsWhereYoungerThenAge(age);
    }

    @PreAuthorize("#name == authentication.principal.username")
    @GetMapping("/persons/by-name-and-surname")
    public List<Person> getPersonByNameAndSurname(@NotBlank String name, @NotBlank String surname) {
        return personsService.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/hello")
    public String hello(@NotBlank String name) throws Exception {

        return "Hello, " + name;

    }

}
