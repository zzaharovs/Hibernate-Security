package ru.netology.daohiber.entity.security;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class CustomUser {

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

//    @OneToOne
//    private UserRoles userRoles;

}
