package com.mirbozorgi.postgresql.core.repository.entity;

import com.mirbozorgi.postgresql.core.entity.Student;
import java.util.List;

public interface StudentRepository {

  Student save(Student student);

  Student findById(long id);

  List<Student> findAll();

  void delete(Student student);

}
