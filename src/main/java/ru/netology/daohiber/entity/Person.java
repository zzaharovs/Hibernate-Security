package ru.netology.daohiber.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@IdClass(Person.class)
@Getter
@Setter
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @NotBlank
    @Column(nullable = false)
    private String name;

    @Id
    @NotBlank
    @Column(nullable = false)
    private String surname;

    @Id
    @Min(0)
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;

}
