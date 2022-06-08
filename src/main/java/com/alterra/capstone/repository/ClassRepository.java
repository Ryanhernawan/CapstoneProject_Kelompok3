package com.alterra.capstone.repository;

import com.alterra.capstone.entity.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<GymClass, Long> {
}
