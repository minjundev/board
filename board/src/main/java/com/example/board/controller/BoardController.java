package com.example.board.controller;

import ch.qos.logback.core.CoreConstants;
import com.example.board.domain.Board;
import com.example.board.exception.ResourceNotFoundException;
import com.example.board.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/board")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String logging(Board board) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(board);
        logger.info(jsonStr);
        return jsonStr;
    }

    @GetMapping
    public List<String> getBoardList() throws Exception {
        ArrayList<String> list = new ArrayList<>();

        for (Board board : boardService.getBoardList()) {list.add(logging(board));}
        return list;
//        return boardService.getBoardList();
    }

    @GetMapping("/{board_seq}")
    public String getBoardDetail(@PathVariable("board_seq") int board_seq) throws Exception {
        // Object to JSON String
        return logging(boardService.getBoardDetail(board_seq));

//        Board board = boardService.getBoardDetail(board_seq);
//
//        if(board == null) {
//            throw new ResourceNotFoundException();
//        }
//
//        return board; @Blank
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public String insertBoard(@RequestBody Board board, BindingResult bindingResult) throws Exception {

        if(bindingResult.hasErrors()) {
            return null;
        }


        boardService.insertBoard(board);

        int boardSeq = board.getBoard_seq();

        Board boardDetail = boardService.getBoardDetail(boardSeq);

        return logging(boardDetail);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/{board_seq}")
    public String updateBoard(@PathVariable("board_seq") int board_seq, @RequestBody Board board) throws Exception {

        boardService.updateBoard(board);

        Board boardDetail = boardService.getBoardDetail(board_seq);

        return logging(boardDetail);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/{board_seq}")
    public String deleteBoard(@PathVariable("board_seq") int board_seq) throws Exception {

        boardService.deleteBoard(board_seq);

        Board deleteBoard = new Board();
        deleteBoard.setBoard_seq(board_seq);

        return logging(deleteBoard);
    }

}
