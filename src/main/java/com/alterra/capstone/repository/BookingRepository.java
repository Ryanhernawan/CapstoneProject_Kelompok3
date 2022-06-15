package com.alterra.capstone.repository;


import com.alterra.capstone.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "SELECT * FROM `booking` WHERE is_booked = 0", nativeQuery = true)
    List<Booking> getBookingBeforeAcc();

    @Query(value = "SELECT * FROM `booking` WHERE is_booked = 1", nativeQuery = true)
    List<Booking> getBookingAfterAcc();


}
