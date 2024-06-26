package com.himedia.twoving.controller;

import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.dto.PaymentVO;
import com.himedia.twoving.dto.steamedVO;
import com.himedia.twoving.service.PassTicketService;
import com.himedia.twoving.service.PaymentService;
import com.himedia.twoving.service.ProductService;
import com.himedia.twoving.service.steamedService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class steamedController {

    @Autowired
    steamedService ss;

    @Autowired
    ProductService ps;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/steamedInsert")
    public String steamedInsert(@RequestParam("pseq") int pseq,
                                @RequestParam("result") String result,
                                HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");


        if (loginUser == null) {
            return "redirect:/login";
        } else {

            steamedVO svo = new steamedVO();
            svo.setPseq(pseq);
            svo.setResult(result);
            svo.setUserid(loginUser.getUserid());
            ss.insertsteamed(svo);

            return "redirect:/Tdetail?pseq=" + pseq;
        }
    }

    @GetMapping("/steamedDelete")
    public String steamedDelete(@RequestParam("pseq") int pseq,
                                @RequestParam("result") String result,
                                HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        ModelAndView mav = new ModelAndView();

        if (loginUser == null) {
            return "redirect:/login";
        } else {

            ss.deletsteamed(pseq);

            return "redirect:/Tdetail?pseq=" + pseq;
        }
    }

    @GetMapping("/steamedlist")
    public ModelAndView steamedlist(
                                    @RequestParam("kind") int kind,
                                    HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
        ModelAndView mav = new ModelAndView();

        if (loginUser == null) {
            mav.setViewName("redirect:/login");
        } else {



            ArrayList<Integer> kindList = ps.getKindList();
            mav.addObject("kindList",kindList);

            ArrayList<steamedVO> list = ss.steamedview2(loginUser.getUserid());
            ArrayList<steamedVO> Alist = ss.selectKindProduct(kind);

            MemberVO memberVO = paymentService.selectOneTicket(loginUser.getUserid());
            PaymentVO paymentVO = paymentService.paymentOneSelect(loginUser.getUserid());

            mav.addObject("memberVO", memberVO);
            mav.addObject("paymentVO", paymentVO);
            mav.addObject("kind", kind);
            mav.addObject("list", list);
            mav.addObject("Alist", Alist);



            mav.setViewName("product/steamedlist");


        }
        return mav;
    }
}

