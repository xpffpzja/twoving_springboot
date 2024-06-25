package com.himedia.twoving.controller;

import com.himedia.twoving.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
}
