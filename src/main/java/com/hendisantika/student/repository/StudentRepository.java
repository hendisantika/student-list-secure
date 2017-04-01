package com.hendisantika.student.repository;

import java.util.List;
import com.hendisantika.student.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByLastName(String lastname);
    
}
