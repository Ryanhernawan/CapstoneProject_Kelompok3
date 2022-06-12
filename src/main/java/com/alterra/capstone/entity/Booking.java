package com.alterra.capstone.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Booking", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_class")
    private Class idClass;

    @Column(name = "is_booked")
    private Boolean isBooked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User idUser;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;


}