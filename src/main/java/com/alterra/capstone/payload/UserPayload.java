package com.alterra.capstone.payload;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserPayload {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String contact;
    private String username;
    private String password;
    private Integer id_role = 2;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

}
