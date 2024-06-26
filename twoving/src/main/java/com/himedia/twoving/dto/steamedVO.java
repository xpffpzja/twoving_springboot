package com.himedia.twoving.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class steamedVO {

    private int sseq;
    private int pseq;
    private int kind;
    private String userid;
    private String mname;
    private String ptitle;
    private String savefilename;
    private Timestamp indate;
    private String result;
}
