package com.himedia.twoving.controller;

import com.himedia.twoving.service.PassTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PassTicketController {

    @Autowired
    private PassTicketService passTicketService;
}
