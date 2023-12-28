package com.mongodb.Repository;

import com.mongodb.entity.student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<student, Integer> {
}
