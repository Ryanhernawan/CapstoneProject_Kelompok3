package com.alterra.capstone.service;

import com.alterra.capstone.entity.Role;
import com.alterra.capstone.payload.RolePayload;

public interface RoleService {
    Iterable<Role> getAll();
    Role getById (Integer id);
    Role create (RolePayload rolePayload);
    void delete(Integer id);


}
