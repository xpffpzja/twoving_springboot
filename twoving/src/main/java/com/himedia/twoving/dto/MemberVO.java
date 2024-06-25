package com.himedia.twoving.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class MemberVO {

    private String userid;
    @NotEmpty(message="비밀번호를 입력하세요")
    private String pwd;
    @NotEmpty(message="이름을 입력하세요")
    private String name;
    @NotEmpty(message="이메일을 입력하세요")
    private String email;
    private String useyn;
    private Timestamp indate;
    private int ptseq;
    private String phone;
    private String provider;
}
