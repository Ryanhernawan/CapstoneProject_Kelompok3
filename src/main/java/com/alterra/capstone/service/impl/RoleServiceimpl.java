package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Role;
import com.alterra.capstone.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alterra.capstone.repository.RoleRepository;

import java.util.Optional;

public class RoleServiceimpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Integer id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty()) {
        }
        return optionalRole.get();
    }

    @Override
    public Role create (Role role){
        return (Role) roleRepository.save(role);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}
