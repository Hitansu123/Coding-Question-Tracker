package com.example.CodingQuestionTracker.Entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
@Data
public class Users {

  @Id
  private String userid;
  // @Indexed(unique = true)
  @NonNull
  private String username;
  @NonNull
  private String password;

  @DBRef
  private List<QuestionEntity> questionEntities = new ArrayList<>();
}
