package com.example.CodingQuestionTracker.Repository;

import com.example.CodingQuestionTracker.Entity.QuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepo extends MongoRepository<QuestionEntity,Integer> {
}
