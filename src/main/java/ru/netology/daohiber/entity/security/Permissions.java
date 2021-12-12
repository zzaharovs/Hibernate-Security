package ru.netology.daohiber.entity.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@IdClass(Permissions.class)
public class Permissions implements Serializable {

    @Id
    private String permissionName;

    @Id
    @ManyToOne
    private Role role;

}
