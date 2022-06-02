package com.capstone.kelompok3.service.Instructors;


import com.capstone.kelompok3.entity.Instructors;
import com.capstone.kelompok3.repository.InstructorsRepositoy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorsServiceImpl implements InstructorsService{
    private final InstructorsRepositoy repositoy;


    @Override
    public List<Instructors> getAllInstructors() {
        return repositoy.findAll();
    }

    @Override
    public Instructors getInstructorsById(Long id) {
        Instructors instructors = new Instructors();
        instructors = repositoy.findById(id).orElse(null);
        return instructors;
    }

    @Override
    public Instructors createNewInstructors(Instructors instructors) {
        return repositoy.save(instructors);
    }

    @Override
    public Instructors updateInstructors(Instructors instructors) {
        return repositoy.save(instructors);
    }

    @Override
    public void deleteInstructorsById(Long id) {
        repositoy.deleteById(id);
    }
}
