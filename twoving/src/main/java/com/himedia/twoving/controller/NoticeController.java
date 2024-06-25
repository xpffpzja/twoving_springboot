package com.himedia.twoving.controller;

import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.service.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notice")
    public ModelAndView noticeCenterMethod(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        HashMap<String, Object> hm = noticeService.noticeSelect(request);

        mav.addObject("noticeList", hm.get("noticeList"));
        mav.addObject("paging", hm.get("paging"));


        mav.setViewName("customercenter/noticeCenter");

        return mav;
    }

    @GetMapping("/noticeDetail")
    public String noticeDetail(@RequestParam("nseq") int nseq, Model model){
        noticeService.updateCount(nseq);

        NoticeVO noticeVO = noticeService.getOneList(nseq);

        model.addAttribute("noticeVO", noticeVO);

        return "customercenter/noticeDetail";
    }

    @GetMapping("/servicepolicy")
    public ModelAndView noticeServicePolicy(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("customercenter/savePolicy");

        return mav;
    }

    @GetMapping("/customerinquiry")
    public ModelAndView noticeCustomerInquiry(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("customercenter/customerInquiry");

        return mav;
    }

    @GetMapping("/nexttimedefuse")
    public ModelAndView noticeNextTimeDefuse(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("customercenter/nextTimeDefuse");

        return mav;
    }
}
