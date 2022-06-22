package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.repository.BookingRepository;
import com.alterra.capstone.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public Iterable<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(Integer id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isEmpty()) {
        }
        return optionalBooking.get();
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Integer id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findBookingByUser_Id(Integer Id) {
        return bookingRepository.findBookingByUser_id();
    }

    @Override
    public List<Booking> findBookingByClass_Id(Integer Id) {
        return bookingRepository.findBookingByClass_id();
    }
}




