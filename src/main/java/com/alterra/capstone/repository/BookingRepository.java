package com.alterra.capstone.repository;


import com.alterra.capstone.entity.Booking;
import com.alterra.capstone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("select b from Booking b")
    List<Booking> findBookingByUser_id();

    List<Booking> findBookingByClass_id();
}
