package ru.netology.daohiber.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "persons")
@ToString
public class Person {

    @EmbeddedId
    private PersonId personId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;


    public void setPersonId(String name, String surname, Integer age) {
        this.personId = new PersonId(name, surname, age);
    }
}
