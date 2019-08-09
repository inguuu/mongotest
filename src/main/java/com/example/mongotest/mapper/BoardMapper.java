package com.example.mongotest.mapper;

import com.example.mongotest.dto.Board;
import com.example.mongotest.model.BoardReq;
import com.example.mongotest.model.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Select("SELECT * FROM board WHERE board_idx =#{boardIdx}")
    Board findIdx(@Param("boardIdx") int boardIdx);

    @Insert("INSERT INTO board(title,content) VALUES(#{boardreq.title},#{boardreq.content})")
    void insert(@Param("boardreq") BoardReq boardreq);

    @Insert("INSERT INTO test(url) VALUES(#{test.url})")
    void test(@Param("test") Test test);
}
