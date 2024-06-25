package com.himedia.twoving.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CustomerInquiryVO {
    private int ciseq;
    private String name;
//    @NotEmpty(message = "이메일을 먼저 입력해주세요...")
//    @NotNull(message = "이메일을 먼저 입력해주세요...")
    private String email;
//    @NotEmpty(message = "연락처를 먼저 입력해주세요...")
//    @NotNull(message = "연락처를 먼저 입력해주세요...")
    private String phone;
//    @NotEmpty(message = "문의종류 중 하나를 선택해주세요...")
//    @NotNull(message = "문의종류 중 하나를 선택해주세요...")
    private String inquirylist; //문의종류
    private String devicephone; // 디바이스폰
    private String devicemodelname; //디바이스모델명
    private String runenvironment; //이용환경
    private String runplace; // 이용장소
    private String runtime1; //이용시간(문의할 때 사용한 이용시간)
    private String runtime2; //이용시간(문의할 때 사용한 이용시간)
    private String runcontent; //이용콘텐츠
    @NotEmpty(message = "문의할 제목을 먼저 입력해주세요...")
    @NotNull(message = "문의할 제목을 먼저 입력해주세요...")
    private String inquirytitle; //문의제목
    @NotEmpty(message = "문의할 내용을 먼저 입력해주세요...")
    @NotNull(message = "문의할 내용을 먼저 입력해주세요...")
    private String inquirycontent; //문의내용
    private String reply;
    private Timestamp indate;
}
