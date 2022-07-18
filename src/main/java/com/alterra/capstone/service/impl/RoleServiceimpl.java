package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Role;
import com.alterra.capstone.payload.RolePayload;
import com.alterra.capstone.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.alterra.capstone.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceimpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

//    @Override
//    public Role getById(Integer id) {
//        Optional<Role> optionalRole = roleRepository.findById(id);
//        if (optionalRole.isEmpty()) {
//        }
//        return optionalRole.get();
//    }

    @Override
    public Role getById(Long id) {
        Role role = new Role();
        role = roleRepository.findById(id).orElse(role);
        return role;
    }

    @Override
    public Role create (RolePayload rolePayload){
        Role role = new Role();
        role.setName(rolePayload.getName());
        return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
