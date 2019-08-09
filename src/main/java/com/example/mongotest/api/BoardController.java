package com.example.mongotest.api;


import com.example.mongotest.dto.Board;
import com.example.mongotest.model.BoardReq;
import com.example.mongotest.model.DefaultRes;
import com.example.mongotest.model.Test;
import com.example.mongotest.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class BoardController {

    private final BoardService boardService;

    private final MongoRepository mongoRepository;
    public BoardController(BoardService boardService, MongoRepository mongoRepository) {
        this.boardService = boardService;
        this.mongoRepository = mongoRepository;
    }


    @GetMapping("/board")
    public ResponseEntity findAllBoards() {
        try {
            return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Board> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류" );
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/board/{boardIdx}")
    public ResponseEntity findIdxBoard(@PathVariable int boardIdx) {
        try {
            log.info(boardIdx+"");
            return new ResponseEntity<>(boardService.findIdx(boardIdx), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Board> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류" );
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/board")
    public ResponseEntity insertBoard(BoardReq boardreq, @RequestPart(value ="profile",required = false) MultipartFile profile) {
        try {
            //log.info(profile+"=======");
            if(profile != null) boardreq.setProfile(profile);
            return new ResponseEntity<>(boardService.insert(boardreq), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Board> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류" );
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //====
    @PostMapping("/mongo")
    public ResponseEntity mongotest(@RequestBody com.example.mongotest.model.Board board) {

        log.info("====================="+board.getTitle());
        mongoRepository.save(board);
        DefaultRes<Board> sm = new DefaultRes<>(HttpStatus.OK,"성공" );
        return new ResponseEntity<>(sm, HttpStatus.OK);

    }
    @DeleteMapping("/mongo")
    public ResponseEntity mongotest(@RequestBody com.example.mongotest.model.Board board) {

        log.info("====================="+board.getTitle());
        mongoRepository.save(board);
        DefaultRes<Board> sm = new DefaultRes<>(HttpStatus.OK,"성공" );
        return new ResponseEntity<>(sm, HttpStatus.OK);

    }
    @PostMapping("/mongo")
    public ResponseEntity mongotest(@RequestBody com.example.mongotest.model.Board board) {

        log.info("====================="+board.getTitle());
        mongoRepository.save(board);
        DefaultRes<Board> sm = new DefaultRes<>(HttpStatus.OK,"성공" );
        return new ResponseEntity<>(sm, HttpStatus.OK);

    }
    @PostMapping("/mongo")
    public ResponseEntity mongotest(@RequestBody com.example.mongotest.model.Board board) {

        log.info("====================="+board.getTitle());
        mongoRepository.save(board);
        DefaultRes<Board> sm = new DefaultRes<>(HttpStatus.OK,"성공" );
        return new ResponseEntity<>(sm, HttpStatus.OK);

    }

}
