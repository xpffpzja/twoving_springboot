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

    public void passTicketUpdate1(int pmseq) {
        paymentDAO.passTicketUpdate1(pmseq);
    }

    public void passTicketInsert1(String userid, String subscribeyn, String productname, String paymentprice) {
        PaymentVO paymentVO = new PaymentVO();

        paymentVO.setUserid(userid);
        paymentVO.setSubscribeyn(subscribeyn);
        paymentVO.setProductname(productname);
        paymentVO.setPaymentprice(paymentprice);

        paymentDAO.passTicketInsert1(paymentVO);
    }

    public void updateMemberPass(String userid, int ptseq) {
        paymentDAO.updateMemberPass(userid, ptseq);
    }
}
