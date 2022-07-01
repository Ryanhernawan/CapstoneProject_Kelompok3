package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.entity.Class;
import com.alterra.capstone.payload.BookingPayload;
import com.alterra.capstone.repository.BookingRepository;
import com.alterra.capstone.repository.ClassRepository;
import com.alterra.capstone.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(@PathVariable Long id) {
        Booking booking = new Booking();
        booking = bookingRepository.findById(id).orElse(booking);

//        Optional<Booking> optionalBooking = bookingRepository.findById(id);
//        if (optionalBooking.isEmpty()) {
//        }
        return booking;
    }

    @Override
    public List<Booking> create(BookingPayload bookingPayload) {
        Optional<Class> sentClass = classRepository.findById(bookingPayload.getClassId().getId());
        sentClass.ifPresent(lemaparHarga ->{
            Integer price = lemaparHarga.getPrice();

            Booking bookingClass = new Booking();
            bookingClass.setIdUser(bookingPayload.getIdUser());
            bookingClass.setIsBooked(false);
            bookingClass.setTotalPrice(price);
            bookingClass.setClassId(bookingPayload.getClassId());
            bookingRepository.save(bookingClass);
        });
        return bookingRepository.findAll();
    }

    @Override
    public Booking accBokingByid(Long id) {
        //sent id ke
//        sent id cla, sent id user, isbooked jadi true
//        bookingRepository.accBooking(idClass, idUser);
//        class dengan id tersebut qty berkurang

        Optional<Booking> bookingId = bookingRepository.findById(id);
        bookingId.ifPresent(accBooking ->{
            Long idClass = accBooking.getClassId().getId();
            Long idUser = accBooking.getIdUser().getId();
            bookingRepository.InsertAccBooking(idClass, idUser);
            bookingRepository.qtyMin1(idClass);
            accBooking.setIsBooked(true);
        });
        return bookingRepository.save(getById(id));
    }

    @Override
    public Booking insertAfterAcc(Long id) {
        return null;
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




