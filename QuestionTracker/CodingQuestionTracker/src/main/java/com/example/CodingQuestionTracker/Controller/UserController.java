package com.example.CodingQuestionTracker.Controller;

import com.example.CodingQuestionTracker.Entity.QuestionEntity;
import com.example.CodingQuestionTracker.Entity.Users;
import com.example.CodingQuestionTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Users>> GetAll(){
        List<Users> all = userService.getAll();
        if(!all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public void CreateUser(@RequestBody Users users){
        userService.SaveEntry(users);
    }

}
