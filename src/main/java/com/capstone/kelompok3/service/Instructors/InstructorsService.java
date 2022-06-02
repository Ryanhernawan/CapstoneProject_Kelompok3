package com.capstone.kelompok3.service.Instructors;

import com.capstone.kelompok3.entity.Instructors;

import java.util.List;

public interface InstructorsService {
    List<Instructors> getAllInstructors();
    Instructors getInstructorsById(Long id);
    Instructors createNewInstructors(Instructors instructors);
    Instructors updateInstructors(Instructors instructors);
    void deleteInstructorsById(Long id);


}
