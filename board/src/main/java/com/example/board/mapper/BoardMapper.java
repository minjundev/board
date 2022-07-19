package com.example.board.mapper;

import com.example.board.domain.Board;

import java.util.List;

public interface BoardMapper {

    public List<Board> getBoardList() throws Exception;

    public Board getBoardDetail(int board_seq) throws Exception;

    public int insertBoard(Board board) throws Exception;

    public int updateBoard(Board board) throws Exception;

    public int deleteBoard(int board_seq) throws Exception;
}
