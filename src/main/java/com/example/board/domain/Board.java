package com.example.board.domain;

import lombok.Data;

@Data
public class Board {

    private int board_seq;
    private int board_re_ref;
    private int board_re_lev;
    private int board_re_seq;
    private String board_writer;
    private String board_subject;
    private String board_content;
    private int board_hits;
    private String del_yn;
    private String ins_user_id;
    private String ins_date;
    private String upd_user_id;
    private String upd_date;
}
