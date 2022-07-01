package com.alterra.capstone.payload;

import com.alterra.capstone.entity.Class;
import com.alterra.capstone.entity.User;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class BookingPayload {

    private Long id;
    private Class classId;
    private Boolean isBooked;
    private User idUser;
    private Integer totalPrice;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
