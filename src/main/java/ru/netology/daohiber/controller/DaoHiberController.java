package ru.netology.daohiber.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohiber.entity.Person;
import ru.netology.daohiber.service.DaoHiberService;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/")
@Validated
@AllArgsConstructor
public class DaoHiberController {

    private final DaoHiberService daoHiberService;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@NotBlank String city) {
        return daoHiberService.getPersonOnCity(city);
    }
}
