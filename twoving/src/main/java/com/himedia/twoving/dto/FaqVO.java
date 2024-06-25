package com.himedia.twoving.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FaqVO {
    private int qseq;
    private String inquirylist;
    private String subject;
    private String content;
    private Timestamp indate;
}
