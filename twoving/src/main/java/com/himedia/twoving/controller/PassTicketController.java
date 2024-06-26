package com.himedia.twoving.controller;

import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.service.PassTicketService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class PassTicketController {

    @Autowired
    private PassTicketService passTicketService;

    @GetMapping("/updateDefuseCheck")
    public ModelAndView updateDefuseCheck(@RequestParam("productname") String productname, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();

        MemberVO memberVO =(MemberVO)session.getAttribute("loginUser");

        if(memberVO == null){
            mav.setViewName("redirect:/loginForm");
        }else{
            HashMap<String, Object> hm = passTicketService.getPaymentAndSelectMemberPass(productname, memberVO.getUserid(), request);
            mav.addObject("paymentVO", hm.get("paymentVO"));
            mav.addObject("memberVO", hm.get("memberVO"));
            mav.setViewName("mypage/updateDefuseCheck");
        }
        return mav;
    }

    @GetMapping("/insertPassTicketPopup")
    public ModelAndView insertPassTicketPopup(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();

        mav.setViewName("mypage/updateDefuseCheck2");

        return mav;
    }

    @GetMapping("/allPassTicketView")
    public ModelAndView allPassTicketView(@RequestParam("productname") String productname,HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        MemberVO memberVO =(MemberVO)session.getAttribute("loginUser");

        if(memberVO == null){
            mav.setViewName("redirect:/loginForm");
        }else{
            HashMap<String, Object> hm = passTicketService.getPaymentAndSelectMemberPass(productname, memberVO.getUserid(), request);
            mav.addObject("paymentVO", hm.get("paymentVO"));
            mav.addObject("memberVO", hm.get("memberVO"));
            mav.setViewName("mypage/allPassTicketViewCheck");
        }
        return mav;
    }

}
