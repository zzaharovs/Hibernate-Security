package ru.netology.daohiber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.daohiber.entity.security.CustomUser;

import java.util.Optional;

public interface UsersSecurityRepo extends JpaRepository<CustomUser, String> {



}
