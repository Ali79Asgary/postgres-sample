package com.mirbozorgi.postgres.core.repository.entity;

import com.mirbozorgi.postgres.core.entity.Student;
import java.util.List;

public interface StudentRepository {

  Student save(Student student);

  Student findById(long id);

  List<Student> findAll();

  void delete(Student student);

}
