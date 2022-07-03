package com.alterra.capstone.repository;


import com.alterra.capstone.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM `booking` WHERE is_booked = 0", nativeQuery = true)
    List<Booking> getBookingBeforeAcc();

    @Query(value = "SELECT * FROM `booking` WHERE is_booked = 1", nativeQuery = true)
    List<Booking> getBookingAfterAcc();

    @Query(value = "SELECT * FROM `booking` WHERE id_user = :id_user", nativeQuery = true)
    List<Booking> getBookingByUserID(@Param("id_user") Long id);

    @Query(value = "SELECT price FROM `class` WHERE id_class = :id", nativeQuery = true)
    Integer hargaClassByID(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `class` SET `qty_users` = `qty_users` - 1 WHERE `id_class` = :classId", nativeQuery = true)
    void qtyMin1(@Param("classId") Long classId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO class_by_user (id_class, id_user) VALUES (:idClass,:idUser)", nativeQuery = true)
    void InsertAccBooking(@Param("idClass") Long id_Class, @Param("idUser") Long id_User);
}
