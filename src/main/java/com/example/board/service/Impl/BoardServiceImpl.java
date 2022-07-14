package com.example.board.service.Impl;

import com.example.board.domain.Board;
import com.example.board.mapper.BoardMapper;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Board> getBoardList() throws Exception {
        return boardMapper.getBoardList();
    }

    public Board getBoardDetail(int board_seq) throws Exception {
        return boardMapper.getBoardDetail(board_seq);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int insertBoard(Board board) throws Exception {
        return boardMapper.insertBoard(board);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int updateBoard(Board board) throws Exception {
        return boardMapper.updateBoard(board);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int deleteBoard(int board_seq) throws Exception {
        return boardMapper.deleteBoard(board_seq);
    }
}
