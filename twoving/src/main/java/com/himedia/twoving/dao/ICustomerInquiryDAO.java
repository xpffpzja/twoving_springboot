package com.himedia.twoving.dao;

import com.himedia.twoving.dto.CustomerInquiryVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICustomerInquiryDAO {
    void cisInsert(CustomerInquiryVO customerInquiryVO);
}
