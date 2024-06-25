package com.himedia.twoving.controller;

import com.himedia.twoving.dto.CustomerInquiryVO;
import com.himedia.twoving.service.CustomerInquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerInquiryController {
    @Autowired
    CustomerInquiryService customerInquiryService;

    @PostMapping("/qnaList")
    public String qnaList(@ModelAttribute("customerInquiryVO") @Valid CustomerInquiryVO customerInquiryVO, BindingResult bindingResult, HttpServletRequest request, Model model){

        String url="customercenter/customerInquiry";

        if(bindingResult.getFieldError("inquirytitle") != null){
            model.addAttribute("message", bindingResult.getFieldError("inquirytitle").getDefaultMessage());
        }else if(bindingResult.getFieldError("inquirycontent") != null) {
            model.addAttribute("message", bindingResult.getFieldError("inquirycontent").getDefaultMessage());
        }else {
            String emailid = request.getParameter("emailid");
            String emailid2 = request.getParameter("emailid2");

            String email = emailid + "@" + emailid2;

            customerInquiryVO.setEmail(email);

            String phone = request.getParameter("phone");
            String phone1 = request.getParameter("phone1");
            String phone2 = request.getParameter("phone2");

            String phoneNum = phone + "-" + phone1 + "-" + phone2;

            customerInquiryVO.setPhone(phoneNum);
            url = "customercenter/noticeAlert";
            customerInquiryService.cisInsert(customerInquiryVO);
        }

        return url;
    }
}
