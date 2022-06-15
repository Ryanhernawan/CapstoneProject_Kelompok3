package com.alterra.capstone.service;

import com.alterra.capstone.entity.Booking;

import java.util.List;

public interface BookingService {
    Iterable<Booking> getAll();
    Booking getById (Long id);
    Booking create (Booking booking);
    List<Booking> getBookingBeforeAcc();
    List<Booking> getBookingAcc();
    Booking accBokingByid(Long id);
    void delete(Long id);
}

