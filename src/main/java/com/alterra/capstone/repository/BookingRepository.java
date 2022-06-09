package com.alterra.capstone.repository;


import com.alterra.capstone.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
