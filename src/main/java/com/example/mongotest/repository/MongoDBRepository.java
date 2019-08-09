package com.example.mongotest.repository;

import com.example.mongotest.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBRepository extends MongoRepository<Board,Integer> {


}
