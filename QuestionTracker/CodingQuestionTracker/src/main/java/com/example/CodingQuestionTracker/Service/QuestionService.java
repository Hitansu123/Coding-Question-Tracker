package com.example.CodingQuestionTracker.Service;

import com.example.CodingQuestionTracker.Entity.QuestionEntity;
import com.example.CodingQuestionTracker.Entity.Users;
import com.example.CodingQuestionTracker.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private UserService userService;

    public List<QuestionEntity> getAll(){
        return questionRepo.findAll();

    }
    public void saveEntry(QuestionEntity entity, String username){
        Users users=userService.findByUserName(username);
        QuestionEntity save = questionRepo.save(entity);
        users.getQuestionEntities().add(save);
        userService.SaveEntry(users);
    }
    public Optional<QuestionEntity> getById(int id){
        return questionRepo.findById(id);
    }
    public boolean Delete(int id){
        if(questionRepo.existsById(id)){
            questionRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
