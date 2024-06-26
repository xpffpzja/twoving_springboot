package com.himedia.twoving.dao;

import com.himedia.twoving.dto.Paging;
import com.himedia.twoving.dto.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface IPaymentDAO {
    int getAllCount(String userid);

    PaymentVO getSelectList(String userid);

    ArrayList<PaymentVO> getAllList(Paging paging, String userid);

    PaymentVO getPayment(String productname, String userid);

    void passTicketUpdate1(int pmseq);

    void passTicketInsert1(PaymentVO paymentVO);

    void updateMemberPass(String userid, int ptseq);

    PaymentVO getPaymentOne(String userid);
}
