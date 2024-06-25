package com.himedia.twoving.service;

import com.himedia.twoving.dao.IPaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    IPaymentDAO paymentDAO;
}
