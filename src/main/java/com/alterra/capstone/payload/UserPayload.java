package com.alterra.capstone.payload;

import com.alterra.capstone.entity.Class;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserPayload {
    private Long id;
    private String name;
    private Class classes;
    private String email;
    private String address;
    private String contact;
    private String username;
    private String password;
    private Integer id_role;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

}
