package com.example.CodingQuestionTracker.Controller;

import com.example.CodingQuestionTracker.Entity.QuestionEntity;
import com.example.CodingQuestionTracker.Entity.Users;
import com.example.CodingQuestionTracker.Service.QuestionService;
import com.example.CodingQuestionTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;


    @GetMapping("/get-question/{username}")
    public ResponseEntity<List<QuestionEntity>> getAllQuestionofUser(@PathVariable String username){
        try {
            Users users = userService.findByUserName(username);
            List<QuestionEntity> all=users.getQuestionEntities();
            return new ResponseEntity<>(all,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/{username}")
    public ResponseEntity<QuestionEntity> questionDone(@RequestBody QuestionEntity question,@PathVariable String username){
        try {
            questionService.saveEntry(question,username);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("id/{Id}")
    public ResponseEntity<QuestionEntity>  GetById(@PathVariable int Id){
        Optional<QuestionEntity> getBYId =questionService.getById(Id);
        if(getBYId.isPresent()){
            return new ResponseEntity<>(getBYId.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(getBYId.get(),HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("number/{num}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteById(@PathVariable int num){
        if(!questionService.Delete(num)){
            throw  new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
//    @PutMapping("/{num}")
//    public ResponseEntity<QuestionEntity> Update(@PathVariable int num,@RequestBody QuestionEntity myentity) {
//        QuestionEntity entity = questionService.getById(num).orElse(null);
//        if (entity != null){
//            entity.setQuestionName(myentity.getQuestionName() != null && !myentity.getQuestionName().equals(" ") ? myentity.getQuestionName() : entity.getQuestionName());
//            entity.setDifficulty(myentity.getDifficulty() != null && !myentity.getDifficulty().equals(" ") ? myentity.getDifficulty() : entity.getDifficulty());
//            questionService.saveEntry(entity, users);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }




}
