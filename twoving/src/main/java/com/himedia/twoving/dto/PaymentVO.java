package com.himedia.twoving.dto;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Data
public class PaymentVO {
    private int pmseq;
    private String userid;
    private String subscribeyn;
    private String productname;
    private String paymentprice;
    private String paymentmeans;
    private Timestamp paymentday;
    private Timestamp runperiod1;
    private Timestamp runperiod2;
}
