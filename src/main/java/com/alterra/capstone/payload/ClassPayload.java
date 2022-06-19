package com.alterra.capstone.payload;

import com.alterra.capstone.entity.Instructor;
import com.alterra.capstone.entity.User;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class ClassPayload {
    private Long id;
    private User user;
    private String name;
    private String description;
    private OffsetDateTime startAt;
    private OffsetDateTime endAt;
    private Integer qtyUsers;
    private String type;
    private Instructor idInstructor;
    private Integer price;
    private String location;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
