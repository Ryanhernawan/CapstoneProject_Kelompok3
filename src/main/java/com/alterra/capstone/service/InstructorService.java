package com.alterra.capstone.service;

import com.alterra.capstone.entity.Instructor;
import org.hibernate.mapping.List;

public interface InstructorService {
    Iterable<Instructor> getAll();
    Instructor getById (Integer id);
    Instructor create (Instructor instructor);
    void delete(Integer id);
}
