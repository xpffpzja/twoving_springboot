package com.himedia.twoving.controller;

import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.service.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/")
    public ModelAndView noticeCenterMethod(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        HashMap<String, Object> hm = noticeService.noticeSelect(request);

        mav.addObject("noticeList", hm.get("noticeList"));
        mav.addObject("paging", hm.get("paging"));


        mav.setViewName("customercenter/noticeCenter");

        return mav;
    }
}
