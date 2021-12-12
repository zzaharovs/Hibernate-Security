package ru.netology.daohiber.entity.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "roles")
@ToString
public class Role {

    @Id
    private String roleName;

}
