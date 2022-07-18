package com.alterra.capstone.service;

import com.alterra.capstone.entity.Instructor;
import org.hibernate.mapping.List;

public interface InstructorService {
    Iterable<Instructor> getAll();
    Instructor getById (Long id);
    Instructor create (Instructor instructor);
    void delete(Long id);
}
