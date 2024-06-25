package com.himedia.twoving.dao;

import com.himedia.twoving.dto.Paging;
import com.himedia.twoving.dto.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface IPaymentDAO {
    int getAllCount(String userid);

    List<PaymentVO> getSelectList();

    ArrayList<PaymentVO> getAllList(Paging paging, String userid);
}
