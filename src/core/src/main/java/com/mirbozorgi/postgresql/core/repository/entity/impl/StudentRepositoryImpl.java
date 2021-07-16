package com.mirbozorgi.postgresql.core.repository.entity.impl;

import com.mirbozorgi.postgresql.core.entity.Student;
import com.mirbozorgi.postgresql.core.repository.entity.StudentRepository;
import java.sql.Struct;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl extends CustomRepository implements StudentRepository {

  @Override
  public Student save(Student student) {
    return save(Student.class, student);
  }

  @Override
  public Student findById(long id) {
    return findById(id);
  }

  @Override
  public List<Student> findAll() {
    return listQueryWrapper(
        entityManager.createQuery(
            "select s from Student s",
            Student.class
        )
    );
  }

  @Override
  public void delete(Student student) {
      delete(Student.class, student);
  }
}
