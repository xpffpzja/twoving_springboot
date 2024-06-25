package com.himedia.twoving.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NoticeVO {
    private Integer nseq;
    private String userid;
    private String title;
    private String content;
    private Timestamp indate;
    private Integer readcount;
    private String noticeyn;
}
