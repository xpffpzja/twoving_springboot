package com.himedia.twoving.controller;

import com.himedia.twoving.dto.AdminVO;
import com.himedia.twoving.dto.FaqVO;
import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.dto.ProductVO;
import com.himedia.twoving.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class AdminController {
    @Autowired
    AdminService as;

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

    @GetMapping("/adminProductList")
    public ModelAndView productList(HttpServletRequest request) {
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
        //추가 수정 해야함.
        as.insertProduct(productvo);
        return "redirect:/adminProductList";
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
        System.out.println("여기옴?");
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
        mav.addObject("faqVO", as.getFaq(qseq));
        mav.setViewName("admin/faq/faqUpdate");
        return mav;
    }

    @PostMapping("/adminFaqUpdate")
    public String adminFaqUpdate(@ModelAttribute("dto") @Valid FaqVO faqvo,
                                    HttpServletRequest request, BindingResult result, Model model){
        String url = "admin/faq/faqUpdate";
        model.addAttribute("faqVO", as.getFaq(faqvo.getQseq()));
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
}
