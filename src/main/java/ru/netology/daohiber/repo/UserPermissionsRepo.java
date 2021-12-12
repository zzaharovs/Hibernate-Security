package ru.netology.daohiber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.daohiber.entity.security.Permissions;

import java.util.List;

public interface UserPermissionsRepo extends JpaRepository<Permissions, Permissions> {

    @Query("select p from Permissions p where p.role.roleName =" +
            " (select ur.role.roleName from UserRoles ur where ur.customUser.username = :user)")
    List<Permissions> getPermissionsByUserName(@Param("user") String user);

}
