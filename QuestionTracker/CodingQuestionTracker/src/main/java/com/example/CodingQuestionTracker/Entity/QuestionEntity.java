package com.example.CodingQuestionTracker.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class QuestionEntity {

    @Id
    private int number;

    private String questionName;

    private String platform;

    private String difficulty;

}
