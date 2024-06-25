package com.himedia.twoving.service;

import com.himedia.twoving.dao.INoticeDAO;
import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.dto.Paging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    INoticeDAO noticeDAO;

    public HashMap<String, Object> noticeSelect(HttpServletRequest request) {
        HashMap<String, Object> hm = new HashMap<String, Object>();
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

        int count = noticeDAO.getAllCount();
        paging.setTotalCount(count);
        paging.calPaging();

        System.out.println("count : " + count);

        paging.setStartNum(paging.getStartNum()-1);

        List<NoticeVO> list = noticeDAO.getNoticeList(paging);

        hm.put("noticeList", list);
        hm.put("paging", paging);
        return hm;
    }
}
