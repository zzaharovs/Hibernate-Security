package ru.netology.daohiber.repo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.daohiber.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@AllArgsConstructor
@Repository
public class DaoHiberRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    public List <Person> getPersonByCity(String city) {

        Query findAllPersonByCity = entityManager.createQuery(
                "select p from Person p where p.cityOfLiving like upper(:city) ", Person.class);
        findAllPersonByCity.setParameter("city", city);

        return findAllPersonByCity.getResultList();
    }

}
