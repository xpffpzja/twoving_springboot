package com.himedia.twoving.controller;

import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.dto.PaymentVO;
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

    @GetMapping("/insertOrUpdatePassTicket1")
    public ModelAndView insertOrUpdatePassTicket1(@RequestParam("pmseq") int pmseq, @RequestParam("subscribeyn") String subscribeyn, @RequestParam("productname") String productname, @RequestParam("ptseq") int ptseq, @RequestParam("paymentprice") String paymentprice, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();

        HttpSession session = request.getSession();

        MemberVO memberVO =(MemberVO)session.getAttribute("loginUser");

        if(memberVO == null){
            System.out.println("현재 subscribeyn : " + subscribeyn);
            System.out.println("현재 pmseq : " + pmseq);
            mav.setViewName("redirect:/loginForm");
        }else{
            passTicketService.passTicketUpdate1(pmseq);
            mav.setViewName("redirect:/insertPassTicket3?subscribeyn=" + subscribeyn+"&productname=" + productname+"&paymentprice=" + paymentprice+"&ptseq=" + ptseq);
        }
        return mav;
    }

    @GetMapping("/insertPassTicket3")
    public ModelAndView insertPassTicket3(@RequestParam("subscribeyn") String subscribeyn, @RequestParam("productname") String productname, @RequestParam("ptseq") int ptseq, @RequestParam("paymentprice") String paymentprice, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        MemberVO memberVO =(MemberVO)session.getAttribute("loginUser");
        if(memberVO == null){
            mav.setViewName("redirect:/loginForm");
        }else{
            passTicketService.passTicketInsert1(memberVO.getUserid(), subscribeyn, productname, paymentprice);

            mav.setViewName("redirect:/updateMemberPassTicket&ptseq="+ptseq);
        }
        return mav;
    }

}
