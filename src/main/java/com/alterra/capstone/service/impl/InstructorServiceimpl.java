package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Instructor;
import com.alterra.capstone.repository.InstructorRepository;
import com.alterra.capstone.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorServiceimpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Iterable<Instructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getById(Integer id) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
        if (optionalInstructor.isEmpty()) {
        }
            return optionalInstructor.get();
    }

    @Override
    public Instructor create(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void delete(Integer id) {
        instructorRepository.deleteById(id);
    }


}
