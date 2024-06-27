package com.himedia.twoving.controller;

import com.himedia.twoving.dto.*;
import com.himedia.twoving.service.AdminService;
import com.himedia.twoving.service.PaymentService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

@Controller
public class AdminController {
    @Autowired
    AdminService as;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/admin")
    public String admin() {
        return "admin/adminLoginForm";
    }

    @PostMapping("/adminlogin")
    public String adminLogin(@Valid @ModelAttribute("dto") AdminVO adminvo, BindingResult result,
                             Model model, HttpServletRequest request) {
        String url = "admin/adminLoginForm";
        if(result.getFieldError("adminid") != null){
            model.addAttribute("message", "아이디를 입력하세요.");
        }else if(result.getFieldError("pwd") != null){
            model.addAttribute("message", "패스워드를 입력하세요.");
        }else{
            AdminVO avo = as.getAdmin(adminvo.getAdminid());
            if(avo == null){
                model.addAttribute("message", "아이디 비번을 확인하세요.");
            } else if( !avo.getPwd().equals(adminvo.getPwd()) ){
                model.addAttribute("message", "아이디 비번을 확인하세요.");
            } else if(avo.getPwd().equals(adminvo.getPwd())){
                HttpSession session = request.getSession();
                session.setAttribute("loginAdmin", avo);
                url = "redirect:/adminProductList";
            }
        }
        return url;
    }

    @GetMapping("/adminLogout")
    public String adminLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("loginAdmin");
        return "redirect:/admin";
    }

    //Product
    @GetMapping("/adminProductList")
    public ModelAndView productList(HttpServletRequest request) { //, @RequestParam("key") String key
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else{
            HashMap<String,Object> result = as.getAdminProductList(request);
            mav.addObject("productList", result.get("productList"));
            mav.addObject("paging", result.get("paging"));
            mav.addObject("key", result.get("key"));
            mav.setViewName("admin/product/productList");
        }
        return mav;
    }

    @GetMapping("/adminProductWriteForm")
    public String productWriteForm(HttpServletRequest request, Model model) {
        return "admin/product/productWrite";
    }

    @PostMapping("/adminProductWrite")
    public String adminProductWrite(@ModelAttribute("dto") @Valid ProductVO productvo, BindingResult result) {
        //이미지 2개 추가.
        as.insertProduct(productvo);
        return "redirect:/adminProductList";
    }

    @Autowired
    ServletContext context;

    @PostMapping("/fileup")
    @ResponseBody //자신을 호출하는 곳으로 "리턴되는 데이터"를 갖고 이동하여 페이지에 표시하라는 뜻
    public HashMap<String, Object> fileup(@RequestParam("fileimage") MultipartFile file,
                                          HttpServletRequest request, Model model){
        String path = context.getRealPath("/images");
        Calendar today = Calendar.getInstance();
        long t = today.getTimeInMillis();
        String filename = file.getOriginalFilename();
        String fn1 = filename.substring(0, filename.indexOf(".")); //파일 이름과 확장장 분리
        String fn2 = filename.substring(filename.indexOf("."));
        String uploadPath = path + "/" + fn1 + t + fn2;
        System.out.println("파일 저장 경로 = " + uploadPath);

        HashMap<String,Object> result = new HashMap<String, Object>();
        try{
            file.transferTo(new File(uploadPath)); //파일이 업로드 및 저장되는 명령
            result.put("STATUS", 1); // 파일 전송 상태
            result.put("IMAGE", filename);
            result.put("SAVEFILENAME", fn1 + t + fn2);
        } catch (IllegalStateException e) {
            e.printStackTrace(); result.put("STATUS", 0);
        } catch (IOException e) {
            e.printStackTrace(); result.put("STATUS", 0);
        }
        return result;
    }

    @GetMapping("/adminProductDetail")
    public ModelAndView adminProductDetail(@RequestParam("pseq") int pseq, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else {
            mav.addObject("productVO", as.getProduct(pseq));
            mav.setViewName("admin/product/productDetail");
        }
        return mav;
    }

    @GetMapping("/adminProductDelete")
    public String adminProductDelete(@RequestParam("pseq") int pseq, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            return "redirect:/admin";
        }else {
            as.deleteProduct(pseq);
            return "redirect:/adminProductList";
        }
    }

    @GetMapping("/adminProductUpdateForm")
    public ModelAndView adminProductUpdateForm(@RequestParam("pseq") int pseq){
        ModelAndView mav = new ModelAndView();
        mav.addObject("productVO", as.getProduct(pseq));
        mav.setViewName("admin/product/productUpdate");
        return mav;
    }

    @PostMapping("/adminProductUpdate")
    public String adminProductUpdate(@ModelAttribute("dto") ProductVO productvo,
                                    HttpServletRequest request, BindingResult result, Model model){
        String url="redirect:/adminProductDetail?pseq="+productvo.getPseq();
        as.updateProduct(productvo);
        return url;
    }

    //파일 업로드 (Ajax 2개?) --나중에...

    //notice
    @GetMapping("/adminNoticeList")
    public ModelAndView noticeList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else{
            HashMap<String,Object> result = as.getAdminNoticeList(request);
            mav.addObject("noticeList", result.get("noticeList"));
            mav.addObject("paging", result.get("paging"));
            mav.addObject("key", result.get("key"));
            mav.setViewName("admin/notice/noticeList");
        }
        return mav;
    }

    @GetMapping("/adminNoticeWriteForm")
    public String adminNoticeWriteForm(HttpServletRequest request, Model model) {
        return "admin/notice/noticeWrite";
    }

    @PostMapping("/adminNoticeWrite")
    public String adminNoticeWrite(@ModelAttribute("dto") @Valid NoticeVO noticevo, BindingResult result,
                                   HttpServletRequest request) {
        HttpSession session = request.getSession();
        AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
        noticevo.setUserid(avo.getAdminid());
        as.insertNotice(noticevo);
        return "redirect:/adminNoticeList";
    }

    @GetMapping("/adminNoticeDetail")
    public ModelAndView adminNoticeDetail(@RequestParam("nseq") int nseq, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else {
            mav.addObject("NoticeVO", as.getNotice(nseq));
            mav.setViewName("admin/notice/noticeDetail");
        }
        return mav;
    }

    @GetMapping("/adminNoticeDelete")
    public String adminNoticeDelete(@RequestParam("nseq") int nseq, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            return "redirect:/admin";
        }else {
            as.deleteNotice(nseq);
            return "redirect:/adminNoticeList";
        }
    }

    @GetMapping("/adminNoticeUpdateForm")
    public ModelAndView adminNoticeUpdateForm(@RequestParam("nseq") int nseq){
        ModelAndView mav = new ModelAndView();
        mav.addObject("noticeVO", as.getNotice(nseq));
        mav.setViewName("admin/notice/noticeUpdate");
        return mav;
    }

    @PostMapping("/adminNoticeUpdate")
    public String adminNoticeUpdate(@ModelAttribute("dto") @Valid NoticeVO noticevo,
                                    HttpServletRequest request, BindingResult result, Model model){
        String url = "admin/notice/noticeUpdate";
        model.addAttribute("noticeVO", as.getNotice(noticevo.getNseq()));
        if(result.getFieldError("title") != null){
            model.addAttribute("message", "제목은 필수 사항입니다.");
        }else if(result.getFieldError("content") != null){
            model.addAttribute("message","내용은 필수 사항입니다.");
        }else{
            url="redirect:/adminNoticeDetail?nseq="+noticevo.getNseq();
            as.updateNotice(noticevo);
        }
        return url;
    }

    //faq
    @GetMapping("/adminFaqList")
    public ModelAndView adminFaqList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else{
            HashMap<String,Object> result = as.getAdminFaqList(request);
            mav.addObject("faqList", result.get("faqList"));
            mav.addObject("paging", result.get("paging"));
            mav.addObject("key", result.get("key"));
            mav.setViewName("admin/faq/faqList");
        }
        return mav;
    }

    @GetMapping("/adminFaqWriteForm")
    public String adminFaqWriteForm(HttpServletRequest request, Model model) {
        return "admin/faq/faqWrite";
    }

    @PostMapping("/adminFaqWrite")
    public String adminFaqWrite(@ModelAttribute("dto") @Valid FaqVO faqvo, BindingResult result,
                                HttpServletRequest request) {
        HttpSession session = request.getSession();
        AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
        as.insertFaq(faqvo);
        return "redirect:/adminFaqList";
    }

    @GetMapping("/adminFaqDetail")
    public ModelAndView adminFaqDetail(@RequestParam("qseq") int qseq, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else {
            mav.addObject("faqVO", as.getFaq(qseq));
            mav.setViewName("admin/faq/faqDetail");
        }
        return mav;
    }

    @GetMapping("/adminFaqDelete")
    public String adminFaqDelete(@RequestParam("qseq") int qseq, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            return "redirect:/admin";
        }else {
            as.deleteFaq(qseq);
            return "redirect:/adminFaqList";
        }
    }

    @GetMapping("/adminFaqUpdateForm")
    public ModelAndView adminFaqUpdateForm(@RequestParam("qseq") int qseq){
        ModelAndView mav = new ModelAndView();
        mav.addObject("FaqVO", as.getFaq(qseq));
        mav.setViewName("admin/faq/faqUpdate");
        return mav;
    }

    @PostMapping("/adminFaqUpdate")
    public String adminFaqUpdate(@ModelAttribute("dto") @Valid FaqVO faqvo,
                                    HttpServletRequest request, BindingResult result, Model model){
        String url = "admin/faq/faqUpdate";
        model.addAttribute("FaqVO", as.getFaq(faqvo.getQseq()));
        if(result.getFieldError("subject") != null){
            model.addAttribute("message", "제목은 필수 사항입니다.");
        }else if(result.getFieldError("content") != null){
            model.addAttribute("message","내용은 필수 사항입니다.");
        }else{
            url="redirect:/adminFaqDetail?qseq="+faqvo.getQseq();
            as.updateFaq(faqvo);
        }
        return url;
    }

    //customerinquiry
    @GetMapping("/adminCustomerInquiryList")
    public ModelAndView adminCustomerInquiryList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else{
            HashMap<String,Object> result = as.getAdminCustomerList(request);
            mav.addObject("inquiryList", result.get("inquiryList"));
            mav.addObject("paging", result.get("paging"));
            mav.addObject("key", result.get("key"));
            mav.setViewName("admin/inquiry/inquiryList");
        }
        return mav;
    }

    @GetMapping("/adminCustomerInquiryDetail")
    public ModelAndView adminCustomerInquiryDetail(@RequestParam("ciseq") int ciseq, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginAdmin") == null){
            mav.setViewName("admin/adminLoginForm");
        }else {
            mav.addObject("cvo", as.getCustomerInquiry(ciseq));
            mav.setViewName("admin/inquiry/inquiryView");
        }
        return mav;
    }

    @PostMapping("/adminCustomerInquiryReplyUpdate")
    public String adminCustomerInquiryReplyUpdate(@ModelAttribute("dto") CustomerInquiryVO customervo,
                                    HttpServletRequest request, BindingResult result, Model model){
        String url="redirect:/adminCustomerInquiryDetail?ciseq="+customervo.getCiseq();
        as.updateInquiryReply(customervo);
        return url;
    }


    //admin아님
    //mypage - 문의내역, 원래는 member별로 관리
    @GetMapping("/customerInquiryListMypage")
    public ModelAndView customerInquiryListMypage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
        if(memberVO == null){
            mav.setViewName("member/loginForm");
        }else{
            HashMap<String,Object> result = as.getCustomerInquiryListMypage(request);
            MemberVO memberVO1 = paymentService.selectOneMemberVO(memberVO.getUserid());
            PaymentVO paymentVO = paymentService.selectOnePaymentVO(memberVO.getUserid());

            mav.addObject("memberVO", memberVO1);
            mav.addObject("paymentVO", paymentVO);
            mav.addObject("inquiryList", result.get("inquiryList"));
            mav.addObject("paging", result.get("paging"));
            mav.addObject("key", result.get("key"));
            mav.setViewName("mypage/inquiryListMypage");
        }
        return mav;
    }

    @GetMapping("/customerInquiryMypageDetail")
    public ModelAndView customerInquiryMypageDetail(@RequestParam("ciseq") int ciseq, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser") == null){
            mav.setViewName("member/loginForm");
        }else {
            mav.addObject("cvo", as.getCustomerInquiry(ciseq));
            mav.setViewName("mypage/inquiryDetail");
        }
        return mav;
    }
}
