package com.himedia.twoving.controller;

import com.himedia.twoving.dao.IsteamedDao;
import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.dto.ProductVO;
import com.himedia.twoving.dto.steamedVO;
import com.himedia.twoving.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ProductController {

  @Autowired
    ProductService ps;

  @Autowired
  IsteamedDao sdao;


  @GetMapping("/Tmain")
    public ModelAndView Tmain(HttpServletRequest request, Model model) {

      ModelAndView mav = new ModelAndView();

      HttpSession session = request.getSession();
      MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
      session.setAttribute("loginUser", loginUser);

      HashMap<String, Object> result = ps.getBestNewList();
      ArrayList<Integer> list = ps.getKindList();

      mav.addObject("mainList", result.get("mainList"));

      mav.addObject("newList", result.get("newList"));
      mav.addObject("bestList", result.get("bestList"));

      mav.addObject("newList2", result.get("newList2"));
      mav.addObject("bestList2", result.get("bestList2"));

      mav.addObject("kindList", list);


      mav.setViewName("product/Tmain");
      return mav;
  }

  @GetMapping("/Tkind")
  public ModelAndView kind(@RequestParam("kind") int kind, HttpServletRequest request, Model model){
      ModelAndView mav = new ModelAndView();

    ArrayList<Integer> kindList = ps.getKindList();

    ArrayList<ProductVO> list = ps.selectKindProduct(kind);

    HashMap<String, Object> result = ps.getBestNewList();

    mav.addObject("kindList", kindList);
    mav.addObject("kindProduct", list);

    mav.addObject("bestList", result.get("bestList"));
    mav.addObject("newList2", result.get("newList2"));


    String kindLists[] = {"시리즈","영화"};
    String SgenreList[] = {"사극", "멜로", "예능", "애니메이션", "교양(다큐)", "스포츠", "키즈", "공연", "오리지널", "해외"};
    String MgenreList[] = {"사극", "멜로", "액션", "히어로", "공포", "범죄", "판타지", "코미디", "애니메이션", "스릴러" };


    mav.addObject("kind", kindLists[kind]);
    mav.addObject("Sgenre", SgenreList);
    mav.addObject("Mgenre", MgenreList);

    mav.setViewName("product/Tkind");
    return mav;
  }

  @GetMapping("/genre")
  public ModelAndView genre(@RequestParam("genre") String genre,
                            @RequestParam("kind") String kind,
                            HttpServletRequest request, Model model){
    ModelAndView mav = new ModelAndView();

    ArrayList<Integer> kindList = ps.getKindList();

    ArrayList<ProductVO> slist = ps.selectSeriesProduct(genre);
    ArrayList<ProductVO> mlist = ps.selectMovieProduct(genre);


    mav.addObject("sProduct", slist);
    mav.addObject("mProduct", mlist);
    mav.addObject("genre", genre);
    mav.addObject("kind", kind);
    mav.addObject("kindList", kindList);

    mav.setViewName("product/genre");
    return mav;
  }

  @GetMapping("/Tdetail")
  public ModelAndView Tdetail(@RequestParam("pseq") int pseq,
                              HttpServletRequest request, Model model){

    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

    ModelAndView mav = new ModelAndView();
    ArrayList<Integer> kindList = ps.getKindList();

    ArrayList<steamedVO> list = sdao.steamedview(loginUser.getUserid(), pseq);

    mav.addObject("productVO", ps.getProduct(pseq));
    mav.addObject("kindList", kindList);
    mav.addObject("ccc",list);


    if ("view".equals(request.getParameter("action"))){
      ps.Count(pseq);
    }


    mav.setViewName("product/Tdetail");
    return mav;
  }

  @GetMapping("/searchList")
  public ModelAndView searchList(@RequestParam("key") String key , HttpServletRequest request, Model model){

    ModelAndView mav = new ModelAndView();

    HttpSession session = request.getSession();
    if( request.getParameter("key") != null) {
      key = request.getParameter("key");
      session.setAttribute("key", key);
    }else if( session.getAttribute("key") != null ) {
      key = (String)session.getAttribute("key");
    }

    ArrayList<Integer> kindList = ps.getKindList();
    ArrayList<ProductVO> searchList = ps.searchList( key );

    mav.addObject("searchList", searchList);
    mav.addObject("kindList", kindList);
    mav.setViewName("product/searchlist");
    return mav;
  }





}
