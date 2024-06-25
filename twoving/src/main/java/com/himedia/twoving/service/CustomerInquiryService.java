package com.himedia.twoving.service;

import com.himedia.twoving.dao.ICustomerInquiryDAO;
import com.himedia.twoving.dto.CustomerInquiryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerInquiryService {
    @Autowired
    ICustomerInquiryDAO customerInquiryDAO;

    public void cisInsert(CustomerInquiryVO customerInquiryVO) {
        customerInquiryDAO.cisInsert(customerInquiryVO);
    }
}
