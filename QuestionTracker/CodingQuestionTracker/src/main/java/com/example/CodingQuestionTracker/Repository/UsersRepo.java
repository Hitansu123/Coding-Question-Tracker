package com.example.CodingQuestionTracker.Repository;

import com.example.CodingQuestionTracker.Entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepo extends MongoRepository<Users, String> {
    Users findByusername(String username);
    //Optional<Users> findById(String userId);
}
