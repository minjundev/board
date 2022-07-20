package com.example.board.domain;

import lombok.*;

@Data
public class Board {

    @NonNull
    private int board_seq; // 게시글 번호

    private int board_re_ref; // 글의 그룹 번호

    private int board_re_lev; // 답변 글 깊이

    private int board_re_seq; // 답변 글 순서

    private String board_writer; // 게시글 작성자

    private String board_subject; // 게시글 제목

    private String board_content; // 게시글 내용

    @NonNull
    private int board_hits; // 게시글 조회수

    @NonNull
    private String del_yn; // 삭제 유무

    private String ins_user_id; // 입력자 아이디

    private String ins_date; // 입력일시

    private String upd_user_id; // 수정자 아이디

    private String upd_date; // 수정일시

    public Board() {}
}