package com.example.board.controller;

import com.example.board.domain.Board;
import com.example.board.exception.ResourceNotFoundException;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/board")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<Board> getBoardList() throws Exception {
        return boardService.getBoardList();
    }

    @GetMapping("/{board_seq}")
    public Board getBoardDetail(@PathVariable("board_seq") int board_seq) throws Exception {

        Board board = boardService.getBoardDetail(board_seq);

        if(board == null) {
            throw new ResourceNotFoundException();
        }

        return board;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Board insertBoard(@RequestBody Board board) throws Exception {

        boardService.insertBoard(board);

        int boardSeq = board.getBoard_seq();

        Board boardDetail = boardService.getBoardDetail(boardSeq);

        return boardDetail;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/{board_seq}")
    public Board updateBoard(@PathVariable("board_seq") int board_seq, @RequestBody Board board) throws Exception {

        boardService.updateBoard(board);

        Board boardDetail = boardService.getBoardDetail(board_seq);

        return boardDetail;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/{board_seq}")
    public Board deleteBoard(@PathVariable("board_seq") int board_seq) throws Exception {

        boardService.deleteBoard(board_seq);

        Board deleteBoard = new Board();
        deleteBoard.setBoard_seq(board_seq);

        return deleteBoard;
    }

}
