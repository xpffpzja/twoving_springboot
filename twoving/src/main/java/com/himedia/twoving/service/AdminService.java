package com.himedia.twoving.service;

import com.himedia.twoving.dao.IAdminDao;
import com.himedia.twoving.dto.AdminVO;
import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.dto.Paging;
import com.himedia.twoving.dto.ProductVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    IAdminDao adao;

    public AdminVO getAdmin(String adminid) {
        return adao.getAdmin(adminid);
    }

    public HashMap<String, Object> getAdminProductList(HttpServletRequest request) {
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
        int count = adao.getAllCount("product", "title", key);
        paging.setTotalCount(count);
        paging.calPaging();
        paging.setStartNum( paging.getStartNum() -1 );

        List<ProductVO> list = adao.getProductList(paging, key);
        System.out.println("레코드 갯수 " + list.size());

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("productList", list);
        result.put("paging", paging);
        result.put("key", key);
        return result;
    }

    public void insertProduct(ProductVO productvo) {
        adao.insertProduct(productvo);
    }

    public HashMap<String, Object> getAdminNoticeList(HttpServletRequest request) {
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
        int count = adao.getAllCount("notice", "title", key);
        paging.setTotalCount(count);
        paging.calPaging();
        paging.setStartNum( paging.getStartNum() -1 );

        List<NoticeVO> list = adao.getNoticeList(paging, key);
        System.out.println("레코드 갯수 " + list.size());

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("noticeList", list);
        result.put("paging", paging);
        result.put("key", key);
        return result;
    }

    public void insertNotice(NoticeVO noticevo) {
        adao.insertNotice(noticevo);
    }

    public NoticeVO getNotice(int nseq) {
        return adao.getNotice(nseq);
    }

    public void deleteNotice(int nseq) {
        adao.deleteNotice(nseq);
    }
}
