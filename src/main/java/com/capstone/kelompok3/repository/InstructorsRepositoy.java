package com.capstone.kelompok3.repository;

import com.capstone.kelompok3.entity.Instructors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorsRepositoy extends JpaRepository<Instructors, Long> {
}
