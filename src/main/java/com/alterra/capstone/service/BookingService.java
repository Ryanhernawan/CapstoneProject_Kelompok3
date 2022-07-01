package com.alterra.capstone.service;

import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.payload.BookingPayload;

import java.util.List;

public interface BookingService {
    Iterable<Booking> getAll();
    Booking getById (Long id);
    List<Booking> create (BookingPayload bookingPayload);
    List<Booking> getBookingBeforeAcc();
    List<Booking> getBookingAcc();
    Booking accBokingByid(Long id);
    Booking insertAfterAcc(Long id);
    void delete(Long id);
}

