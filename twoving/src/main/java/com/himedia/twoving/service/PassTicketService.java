package com.himedia.twoving.service;

import com.himedia.twoving.dao.IPassTicketDAO;
import com.himedia.twoving.dao.IPaymentDAO;
import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.dto.PaymentVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PassTicketService {
    @Autowired
    IPassTicketDAO passTicketDAO;

    @Autowired
    IPaymentDAO paymentDAO;

    public HashMap<String, Object> getPaymentAndSelectMemberPass(String productname, String userid, HttpServletRequest request) {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        MemberVO memberVO =(MemberVO)session.getAttribute("loginUser");

        PaymentVO paymentVO = paymentDAO.getPayment(productname);

        MemberVO memberVO1 = passTicketDAO.selectMemberPassTicket(memberVO.getUserid());

        hm.put("paymentVO", paymentVO);
        hm.put("memberVO", memberVO1);

        return hm;
    }
}
