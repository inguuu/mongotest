package com.example.mongotest.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Board {
    private int idx;
    private String title;
    private String content;

}