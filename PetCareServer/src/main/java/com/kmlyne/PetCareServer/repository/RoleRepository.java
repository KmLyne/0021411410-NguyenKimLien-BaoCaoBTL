package com.kmlyne.PetCareServer.repository;

import com.kmlyne.PetCareServer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRolename(String roleName);
}
