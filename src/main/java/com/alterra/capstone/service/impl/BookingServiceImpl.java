package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.entity.Class;
import com.alterra.capstone.repository.BookingRepository;
import com.alterra.capstone.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Iterable<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isEmpty()) {
        }
        return optionalBooking.get();
    }

//    @Override
//    public Booking bookingOfflineClass(Booking payload) {
//        Booking booking = new Booking();
//
//        Class classRegister = new Class();
//
//        booking.setIsBooked(false);
//        booking.setTotalPrice(cl.getPrice());
//        booking.setClassId();
//        booking.setIdUser();
//        return null;
//    }
//
//    @Override
//    public Booking bookingOnlineClass(Booking booking) {
//        return null;
//    }

    @Override
    public Booking create(Booking booking) {
        Class classBook = new Class();
        Integer price = classBook.getPrice();

        Booking bookingClass = new Booking();
        bookingClass.setIsBooked(false);
        bookingClass.setTotalPrice(price);
        bookingClass.setClassId(booking.getClassId());
        return bookingRepository.save(booking);
    }

    @Override
    public Booking accBokingByid(Long id) {
        Optional<Booking> bookingId = bookingRepository.findById(id);
        bookingId.ifPresent(accBooking ->{
            accBooking.setIsBooked(true);
        });
        return bookingRepository.save(getById(id));
    }

    @Override
    public List<Booking> getBookingBeforeAcc() {
        return bookingRepository.getBookingBeforeAcc();
    }

    @Override
    public List<Booking> getBookingAcc() {
        return bookingRepository.getBookingAfterAcc();
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}




