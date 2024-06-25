package com.himedia.twoving.service;

import com.himedia.twoving.dao.IFaqDAO;
import com.himedia.twoving.dto.FaqVO;
import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.dto.Paging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FaqService {

    @Autowired
    IFaqDAO faqDAO;

    public HashMap<String, Object> faqSelect(HttpServletRequest request) {
        HashMap<String, Object> hm = new HashMap<>();

        HttpSession session = request.getSession();

        int page = 1;

        if( request.getParameter("page") != null ) {
            page = Integer.parseInt( request.getParameter("page") );
            session.setAttribute("page", page);
        }else if( session.getAttribute("page") != null ) {
            page = (Integer)session.getAttribute("page");
        }else {
            session.removeAttribute("page");
        }

        String key="";
        if( request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if( session.getAttribute("key") != null ) {
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = faqDAO.getFaqAllCount();
        paging.setTotalCount(count);
        paging.calPaging();

        System.out.println("count : " + count);

        paging.setStartNum(paging.getStartNum()-1);

        List<FaqVO> list = faqDAO.getFaqList(paging);

        hm.put("faqList", list);
        hm.put("paging", paging);

        return hm;

    }

    public HashMap<String, Object> faqMemberCustomerLoginMethod(HttpServletRequest request, String inquirylist) {
        HashMap<String, Object> hm = new HashMap<>();

        HttpSession session = request.getSession();

        int page = 1;

        if( request.getParameter("page") != null ) {
            page = Integer.parseInt( request.getParameter("page") );
            session.setAttribute("page", page);
        }else if( session.getAttribute("page") != null ) {
            page = (Integer)session.getAttribute("page");
        }else {
            session.removeAttribute("page");
        }

        String key="";
        if( request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if( session.getAttribute("key") != null ) {
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = faqDAO.getMemberCustomerLoginAllCount(inquirylist);
        paging.setTotalCount(count);
        paging.calPaging();

        System.out.println("count : " + count);

        paging.setStartNum(paging.getStartNum()-1);

        List<FaqVO> list = faqDAO.getFaqMemberCustomerLoginList(paging, inquirylist);

        hm.put("memberCustomerList", list);
        hm.put("paging", paging);

        return hm;
    }

    public HashMap<String, Object> faqPassTicketMethod(HttpServletRequest request, String inquirylist) {
        HashMap<String, Object> hm = new HashMap<>();

        HttpSession session = request.getSession();

        int page = 1;

        if( request.getParameter("page") != null ) {
            page = Integer.parseInt( request.getParameter("page") );
            session.setAttribute("page", page);
        }else if( session.getAttribute("page") != null ) {
            page = (Integer)session.getAttribute("page");
        }else {
            session.removeAttribute("page");
        }

        String key="";
        if( request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if( session.getAttribute("key") != null ) {
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = faqDAO.getPassTicketAllCount(inquirylist);
        paging.setTotalCount(count);
        paging.calPaging();

        System.out.println("count : " + count);

        paging.setStartNum(paging.getStartNum()-1);

        List<FaqVO> list = faqDAO.getFaqPassTicketList(paging, inquirylist);

        hm.put("passTicket", list);
        hm.put("paging", paging);

        return hm;
    }

    public HashMap<String, Object> faqLoadingErrorMethod(HttpServletRequest request, String inquirylist) {
        HashMap<String, Object> hm = new HashMap<>();

        HttpSession session = request.getSession();

        int page = 1;

        if( request.getParameter("page") != null ) {
            page = Integer.parseInt( request.getParameter("page") );
            session.setAttribute("page", page);
        }else if( session.getAttribute("page") != null ) {
            page = (Integer)session.getAttribute("page");
        }else {
            session.removeAttribute("page");
        }

        String key="";
        if( request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if( session.getAttribute("key") != null ) {
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = faqDAO.getLoadingErrorAllCount(inquirylist);
        paging.setTotalCount(count);
        paging.calPaging();

        System.out.println("count : " + count);

        paging.setStartNum(paging.getStartNum()-1);

        List<FaqVO> list = faqDAO.getFaqLoadingErrorList(paging, inquirylist);

        hm.put("loadingErrorList", list);
        hm.put("paging", paging);

        return hm;
    }

    public HashMap<String, Object> faqNonPayMethod(HttpServletRequest request, String inquirylist) {
        HashMap<String, Object> hm = new HashMap<>();

        HttpSession session = request.getSession();

        int page = 1;

        if( request.getParameter("page") != null ) {
            page = Integer.parseInt( request.getParameter("page") );
            session.setAttribute("page", page);
        }else if( session.getAttribute("page") != null ) {
            page = (Integer)session.getAttribute("page");
        }else {
            session.removeAttribute("page");
        }

        String key="";
        if( request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if( session.getAttribute("key") != null ) {
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = faqDAO.getNonPayAllCount(inquirylist);
        paging.setTotalCount(count);
        paging.calPaging();

        System.out.println("count : " + count);

        paging.setStartNum(paging.getStartNum()-1);

        List<FaqVO> list = faqDAO.getFaqNonPayList(paging, inquirylist);

        hm.put("nonpayList", list);
        hm.put("paging", paging);

        return hm;
    }

    public HashMap<String, Object> faqServiceRunMethod(HttpServletRequest request, String inquirylist) {
        HashMap<String, Object> hm = new HashMap<>();

        HttpSession session = request.getSession();

        int page = 1;

        if( request.getParameter("page") != null ) {
            page = Integer.parseInt( request.getParameter("page") );
            session.setAttribute("page", page);
        }else if( session.getAttribute("page") != null ) {
            page = (Integer)session.getAttribute("page");
        }else {
            session.removeAttribute("page");
        }

        String key="";
        if( request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        }else if( session.getAttribute("key") != null ) {
            key = (String)session.getAttribute("key");
        }else {
            session.removeAttribute("key");
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = faqDAO.getServiceRunAllCount(inquirylist);
        paging.setTotalCount(count);
        paging.calPaging();

        System.out.println("count : " + count);

        paging.setStartNum(paging.getStartNum()-1);

        List<FaqVO> list = faqDAO.getFaqServiceRunList(paging, inquirylist);

        hm.put("serviceRunList", list);
        hm.put("paging", paging);

        return hm;
    }
}
