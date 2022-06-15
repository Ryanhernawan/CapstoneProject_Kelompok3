package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping
    public Iterable<Booking> getAll(){
        return bookingService.getAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?>BookingById(@PathVariable("id") Long id){
        Booking booking = bookingService.getById(id);
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
        Booking bookingCreate = bookingService.create(booking);
        return ResponseEntity.ok(bookingCreate);
    }

    //get bookiing before acc
    @GetMapping("/false")
    public ResponseEntity<?> getBeforeAcc(){
        List<Booking> bookingBeforeAcc = bookingService.getBookingBeforeAcc();
        return ResponseEntity.ok(bookingBeforeAcc);
    }

    @GetMapping("/true")
    public ResponseEntity<?> getAfterAcc(){
        List<Booking> bookingBeforeAcc = bookingService.getBookingAcc();
        return ResponseEntity.ok(bookingBeforeAcc);
    }

    @PutMapping("/acc/{id}")
    public ResponseEntity<?> accBooking(@PathVariable Long id){
        Booking booking = bookingService.accBokingByid(id);
        return ResponseEntity.ok(booking);
    }


     @DeleteMapping ("/{id}")
        public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id){
         bookingService.delete(id);
         return ResponseEntity.notFound().build();

     }
}
