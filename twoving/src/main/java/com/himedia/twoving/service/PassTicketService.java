package com.himedia.twoving.service;

import com.himedia.twoving.dao.IPassTicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassTicketService {
    @Autowired
    IPassTicketDAO passTicketDAO;
}
