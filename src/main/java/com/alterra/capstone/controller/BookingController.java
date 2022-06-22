package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.service.BookingService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/booking")
public class BookingController {
 @Autowired
    BookingService bookingService;

 @GetMapping
    public Iterable<Booking> getAll(){
     return bookingService.getAll();

 }
 @GetMapping ("/{id}")
    public ResponseEntity<?>BookingById(@PathVariable("id") Integer id){
     Booking booking = bookingService.getById(id);
     return ResponseEntity.ok(booking);

   // GET USER BY ID
 }
 @GetMapping ("/User{id}")
 public ResponseEntity<?>BookingUserById(@PathVariable("id") Integer id){
     Booking booking = (Booking) bookingService.findBookingByUser_Id(id);
     return ResponseEntity.ok(booking);

     // GET CLASS BY ID
 }
 @GetMapping
 public ResponseEntity<?>BookingClassById(@PathVariable("id")Integer id){
     Booking booking = (Booking) bookingService.findBookingByClass_Id(id);
     return  ResponseEntity.ok(booking);
 }

@PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
     Booking bookingCreate = bookingService.create(booking);
     return ResponseEntity.ok(bookingCreate);
}
@DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Integer id){
     bookingService.delete(id);
     return ResponseEntity.notFound().build();

}





}
