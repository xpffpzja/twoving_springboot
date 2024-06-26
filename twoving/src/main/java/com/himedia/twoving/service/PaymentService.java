package com.himedia.twoving.service;

import com.himedia.twoving.dao.IPassTicketDAO;
import com.himedia.twoving.dao.IPaymentDAO;
import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.dto.Paging;
import com.himedia.twoving.dto.PassTicketVO;
import com.himedia.twoving.dto.PaymentVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    IPaymentDAO paymentDAO;

    @Autowired
    IPassTicketDAO passTicketDAO;

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public HashMap<String, Object> passTicketList(HttpServletRequest request) {

        HashMap<String, Object> hm = new HashMap<>();


        HttpSession session = request.getSession();

        MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

        int page = 1;

        if(request.getParameter("page") != null) {

            page =  Integer.parseInt(request.getParameter("page"));
            session.setAttribute("page", page);

        } else if(session.getAttribute("page") != null) {

            page = (Integer)session.getAttribute("page");

        } else {
            session.removeAttribute("page");
        }

        String key = "";

        if(request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if(session.getAttribute("key") != null){
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();


        MemberVO memberVO1 = passTicketDAO.selectOnePassTicket(memberVO.getUserid());

        int count = paymentDAO.getAllCount(memberVO.getUserid());

        System.out.println("count : " + count);

        paging.setTotalCount(count);
        paging.calPaging();
        paging.setStartNum(paging.getStartNum()-1);

        PaymentVO paymentVO = paymentDAO.getSelectList(memberVO.getUserid()); // subscribeyn이 'Y' 인것만 레코드만 리턴

        ArrayList<PaymentVO> passTicket2List = paymentDAO.getAllList(paging, memberVO.getUserid());

        hm.put("paymentVO", paymentVO);
        hm.put("memberVO", memberVO1);
        hm.put("passTicket2List", passTicket2List);
        hm.put("paging", paging);

        return hm;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public HashMap<String, Object> passTicketListMyPageUpdate(HttpServletRequest request) {
        HashMap<String, Object> hm = new HashMap<>();


        HttpSession session = request.getSession();

        MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

        int page = 1;

        if(request.getParameter("page") != null) {

            page =  Integer.parseInt(request.getParameter("page"));
            session.setAttribute("page", page);

        } else if(session.getAttribute("page") != null) {

            page = (Integer)session.getAttribute("page");

        } else {
            session.removeAttribute("page");
        }

        String key = "";

        if(request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if(session.getAttribute("key") != null){
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();

        paging.setPage(page);

        MemberVO memberVO1 = passTicketDAO.selectOnePassTicket(memberVO.getUserid());

        int count = paymentDAO.getAllCount(memberVO.getUserid());

        System.out.println("count : " + count);

        paging.setTotalCount(count);
        paging.calPaging();
        paging.setStartNum(paging.getStartNum()-1);

        PaymentVO paymentVO = paymentDAO.getSelectList(memberVO.getUserid()); // subscribeyn이 'Y' 인것만 레코드만 리턴

        // ArrayList<PaymentVO> passTicket2List = paymentDAO.getAllList(paging, memberVO.getUserid());

        hm.put("paymentVO", paymentVO);
        hm.put("memberVO", memberVO1);

        return hm;
    }

    public PaymentVO getPaymentOne(String userid) {
        PaymentVO paymentVO = paymentDAO.getPaymentOne(userid);
        return paymentVO;
    }
}
