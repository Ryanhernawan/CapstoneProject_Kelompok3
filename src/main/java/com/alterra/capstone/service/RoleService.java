package com.alterra.capstone.service;

import com.alterra.capstone.entity.Role;

public interface RoleService {
    Iterable<Role> getAll();
    Role getById (Integer id);
    Role create (Role rOle);
    void delete(Integer id);


}
