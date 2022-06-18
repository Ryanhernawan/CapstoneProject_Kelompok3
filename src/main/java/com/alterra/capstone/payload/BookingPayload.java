package com.alterra.capstone.payload;

import com.alterra.capstone.entity.Class;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class BookingPayload {

    private Long id;
    private Class classId;
    private Boolean isBooked;
    private Long idUser;
    private Integer totalPrice;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
