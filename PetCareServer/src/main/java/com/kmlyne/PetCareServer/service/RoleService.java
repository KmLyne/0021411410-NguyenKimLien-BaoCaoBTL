// RoleService.java
package com.kmlyne.PetCareServer.service;

import com.kmlyne.PetCareServer.model.Role;
import com.kmlyne.PetCareServer.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> findRoleByName(String roleName) {
        return roleRepository.findByRolename(roleName);
    }
}
