package com.himedia.twoving.controller;

import com.himedia.twoving.service.FaqService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class FaqController {

    @Autowired
    FaqService faqService;

    @GetMapping("/faq")
    public ModelAndView faq(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HashMap<String, Object> hm = faqService.faqSelect(request);

        mav.addObject("faqList", hm.get("faqList"));
        mav.addObject("paging", hm.get("paging"));
        mav.setViewName("faq/faqForm");

        return mav;
    }

    @GetMapping("/memberCustomerLogin")
    public ModelAndView memberCustomerLogin(HttpServletRequest request, @RequestParam("inquirylist") String inquirylist) {
        ModelAndView mav = new ModelAndView();

        HashMap<String, Object> hm = faqService.faqMemberCustomerLoginMethod(request, inquirylist);

        mav.addObject("memberCustomer", hm.get("memberCustomerList"));
        mav.addObject("paging", hm.get("paging"));
        mav.setViewName("faq/faqMemberCustomerList");

        return mav;
    }

    @GetMapping("/passTicket")
    public ModelAndView passTicket(HttpServletRequest request, @RequestParam("inquirylist") String inquirylist) {
        ModelAndView mav = new ModelAndView();

        HashMap<String, Object> hm = faqService.faqPassTicketMethod(request, inquirylist);

        mav.addObject("passTicket", hm.get("passTicket"));
        mav.addObject("paging", hm.get("paging"));
        mav.setViewName("faq/faqPassTicketList");

        return mav;
    }

    @GetMapping("/loadingError")
    public ModelAndView loadingError(HttpServletRequest request, @RequestParam("inquirylist") String inquirylist) {
        ModelAndView mav = new ModelAndView();

        HashMap<String, Object> hm = faqService.faqLoadingErrorMethod(request, inquirylist);

        mav.addObject("loadingErrorList", hm.get("loadingErrorList"));
        mav.addObject("paging", hm.get("paging"));
        mav.setViewName("faq/faqloadingErrorList");

        return mav;
    }

    @GetMapping("/nonpay")
    public ModelAndView nonpay(HttpServletRequest request, @RequestParam("inquirylist") String inquirylist) {
        ModelAndView mav = new ModelAndView();

        HashMap<String, Object> hm = faqService.faqNonPayMethod(request, inquirylist);

        mav.addObject("nonpayList", hm.get("nonpayList"));
        mav.addObject("paging", hm.get("paging"));
        mav.setViewName("faq/faqNonPayList");

        return mav;
    }

    @GetMapping("/servicerun")
    public ModelAndView servicerun(HttpServletRequest request, @RequestParam("inquirylist") String inquirylist) {
        ModelAndView mav = new ModelAndView();

        HashMap<String, Object> hm = faqService.faqServiceRunMethod(request, inquirylist);

        mav.addObject("serviceRunList", hm.get("serviceRunList"));
        mav.addObject("paging", hm.get("paging"));
        mav.setViewName("faq/faqServiceRunList");

        return mav;
    }
}
