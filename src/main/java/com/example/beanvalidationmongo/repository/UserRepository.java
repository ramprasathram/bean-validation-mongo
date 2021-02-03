package com.example.beanvalidationmongo.repository;

import com.example.beanvalidationmongo.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {
}
