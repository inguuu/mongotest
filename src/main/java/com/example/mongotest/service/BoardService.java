package com.example.mongotest.service;


import com.example.mongotest.dto.Board;
import com.example.mongotest.model.BoardReq;
import com.example.mongotest.model.DefaultRes;
import com.example.mongotest.model.Test;

import java.util.List;

public interface BoardService {

    DefaultRes<List<Board>> findAll();

    DefaultRes<Board> findIdx(int boardIdx);

    DefaultRes insert(BoardReq boardreq);

    DefaultRes test(Test test);

}
