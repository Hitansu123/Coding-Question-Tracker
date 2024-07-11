package com.example.CodingQuestionTracker.Service;

import com.example.CodingQuestionTracker.Entity.QuestionEntity;
import com.example.CodingQuestionTracker.Entity.Users;
import com.example.CodingQuestionTracker.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;

    public List<Users> getAll(){
        return usersRepo.findAll();
    }
    public void SaveEntry(Users users){
        usersRepo.save(users);
    }
    public void addQuestionToUser(String userId, QuestionEntity question) {
        try {
            Optional<Users> optionalUser = usersRepo.findById(userId);
            if (optionalUser.isPresent()) {
                Users user = optionalUser.get();
                user.getQuestionEntities().add(question);
                usersRepo.save(user);
            } else {
                // Handle case when user with userId is not found
                throw new RuntimeException("User not found for id: " + userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately, logging or throwing as needed
        }
    }
    public Users findByUserName(String username){
        return usersRepo.findByusername(username);
    }

    public void DeleteUser(String userid) {
        usersRepo.deleteById(userid);
    }
}
