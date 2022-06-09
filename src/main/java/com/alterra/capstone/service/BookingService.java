package com.alterra.capstone.service;

import com.alterra.capstone.entity.Booking;
import org.hibernate.mapping.List;

public interface BookingService {
    Iterable<Booking> getAll();
    Booking getById (Integer id);
    Booking create (Booking booking);
    void delete(Integer id);
}

