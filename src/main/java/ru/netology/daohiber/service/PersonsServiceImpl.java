package ru.netology.daohiber.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.daohiber.entity.Person;
import ru.netology.daohiber.entity.PersonAlreadyExistsException;
import ru.netology.daohiber.entity.ResultNotFoundException;
import ru.netology.daohiber.repo.PersonsRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonsServiceImpl implements PersonsService {

    private final PersonsRepo personsRepo;

    @Override
    public String createPerson(Person person) {

        if (personsRepo.findById(person.getPersonId()).isPresent()) {
            throw new PersonAlreadyExistsException(String.format(
                    "Create person %s %s failed, person already exists",
                    person.getPersonId().getName(), person.getPersonId().getSurname()));
        }
        personsRepo.save(person);
        return String.format("Create person %s %s success",
                person.getPersonId().getName(), person.getPersonId().getSurname());
    }

    @Override
    public String deletePerson(Person person) {
        personsRepo.findById(person.getPersonId())
                .orElseThrow(() -> new ResultNotFoundException("Person not found"));
        personsRepo.delete(person);
        return "Delete success";
    }

    @Override
    @Transactional
    public String updatePerson(Person person) {
        personsRepo.findById(person.getPersonId())
                .orElseThrow(() -> new ResultNotFoundException("Person not found"));
        personsRepo.save(person);
        return "Update success";
    }

    @Override
    public List<Person> getPersonsByCity(String city) {
        return personsRepo.findByCityOfLiving(city);
    }

    @Override
    public List<Person> getPersonsWhereYoungerThenAge(Integer age) {
        return personsRepo.findByPersonIdAgeLessThanOrderByPersonIdAge(age);
    }

    @Override
    public Person getPersonByNameAndSurname(String name, String surname) {
        return personsRepo.findTopByPersonIdNameAndPersonIdSurname(name, surname)
                .orElseThrow(() -> new ResultNotFoundException("Result Not Found"));
    }
}
