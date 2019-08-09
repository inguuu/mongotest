package com.example.mongotest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Data
@Document(collection = "deliver")
public class Board {

    @Id
    private  int contentIdx;
    private  String title;

}