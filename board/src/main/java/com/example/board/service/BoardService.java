package com.example.board.service;

import com.example.board.domain.Board;

import java.util.List;


public interface BoardService {

    public List<Board> getBoardList() throws Exception;

    public Board getBoardDetail(int board_seq) throws Exception;

    public int insertBoard(Board board) throws Exception;

    public int updateBoard(Board board) throws Exception;

    public int deleteBoard(int board_seq) throws Exception;
}
