package ru.netology.daohiber.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.daohiber.entity.Person;
import ru.netology.daohiber.repo.DaoHiberRepo;

import java.util.List;

@AllArgsConstructor
@Service
public class DaoHiberService {

    private final DaoHiberRepo daoHiberRepo;

    public List<Person> getPersonOnCity(String city) {
        return daoHiberRepo.getPersonByCity(city);
    }

}
