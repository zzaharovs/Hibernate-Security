package ru.netology.daohiber.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonId implements Serializable {

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String surname;

    @Min(0)
    @Column(nullable = false)
    private int age;

}
