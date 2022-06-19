package com.alterra.capstone.payload;

import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class RolePayload {
    private Long id;
    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
