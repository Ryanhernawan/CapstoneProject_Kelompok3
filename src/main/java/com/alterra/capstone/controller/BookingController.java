package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.payload.BookingPayload;
import com.alterra.capstone.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<BaseResponse<Iterable<Booking>>> getAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get All Booking");
        baseResponse.setData(bookingService.getAll());
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<BaseResponse<Booking>> BookingById(@PathVariable("id") Long id){
        BaseResponse baseResponse = new BaseResponse();
        if (bookingService.getById(id) != null) {
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Get Booking " + id);
            baseResponse.setData(bookingService.getById(id));
        }else {
            baseResponse.setSuccess(false);
            baseResponse.setMessage(" Failed to get Booking " + id);
            baseResponse.setData(null);
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Booking>> createBooking(@RequestBody BookingPayload bookingPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Add Booking Class");
        baseResponse.setData(bookingService.create(bookingPayload));
        return new ResponseEntity(baseResponse, HttpStatus.CREATED);
    }

    //get booking before acc
    @GetMapping("/false")
    public ResponseEntity<BaseResponse<Booking>> getBeforeAcc(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Booking before ACC");
        baseResponse.setData(bookingService.getBookingBeforeAcc());
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/true")
    public ResponseEntity<BaseResponse<Booking>> getAfterAcc(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Booking Accepted");
        baseResponse.setData(bookingService.getBookingAcc());
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    @PutMapping("/acc/{id}")
    public BaseResponse<Booking> accBooking(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("berhasil");
        baseResponse.setSuccess(true);
        baseResponse.setData(bookingService.accBokingByid(id));
        return baseResponse;

//        if (bookingService.getById(id) != null){
//            bookingService.accBokingByid(id);
//            baseResponse.setSuccess(true);
//            baseResponse.setMessage("Success to Acc booking ID " + id);
//        }else {
//            baseResponse.setSuccess(false);
//            baseResponse.setMessage("Failed to Acc Booking");
//            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity(baseResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id){
        bookingService.delete(id);
        return ResponseEntity.notFound().build();

    }
}
