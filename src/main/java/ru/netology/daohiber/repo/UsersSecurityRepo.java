package ru.netology.daohiber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.daohiber.entity.security.CustomUser;

public interface UsersSecurityRepo extends JpaRepository<CustomUser, String> {



}
