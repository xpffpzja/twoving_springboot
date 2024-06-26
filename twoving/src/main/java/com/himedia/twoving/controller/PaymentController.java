package com.himedia.twoving.controller;

import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/passTicketList")
    public ModelAndView passTicketList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

        if(memberVO == null){
            mav.setViewName("redirect:/loginForm");
        }else{
            HashMap<String, Object> hm = paymentService.passTicketList(request);

            mav.addObject("paymentVO", hm.get("paymentVO"));
            mav.addObject("memberVO", hm.get("memberVO"));
            mav.addObject("passTicket2", hm.get("passTicket2List"));
            mav.addObject("paging", hm.get("paging"));
            mav.setViewName("mypage/passTicket");
        }

        return mav;
    }

}
