package com.alterra.capstone.service;

import com.alterra.capstone.entity.Booking;

import java.util.List;

public interface BookingService {
    Iterable<Booking> getAll();
    Booking getById (Integer id);
    Booking create (Booking booking);
    void delete(Integer id);
    List<Booking> findBookingByUser_Id(Integer Id);
    List<Booking> findBookingByClass_Id(Integer Id);
}

