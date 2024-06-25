package com.himedia.twoving.service;

import com.himedia.twoving.dao.IProductDao;
import com.himedia.twoving.dto.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


@Service
public class ProductService {

    @Autowired
    IProductDao pdao;

    public HashMap<String, Object> getBestNewList() {
        HashMap<String, Object> result = new HashMap<>();


        //result.put("kindList", pdao.getKindList());

        result.put("mainList", pdao.getMainList());

        result.put("bestList", pdao.getBestList());
        result.put("newList", pdao.getNewList());

        result.put("bestList2", pdao.getBestList2());
        result.put("newList2", pdao.getNewList2());

        return result;
    }


    public ArrayList<Integer> getKindList() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        return result;
    }


    public ArrayList<ProductVO> selectKindProduct(int kind) {
        ArrayList<ProductVO> result = new ArrayList<>();
        result.addAll(pdao.selectKindProduct(kind));
        return result;
    }


    public ArrayList<ProductVO> selectSeriesProduct(String genre) {
        ArrayList<ProductVO> result = new ArrayList<>();
        result.addAll(pdao.selectSeriesProduct(genre));
        return result;
    }

    public ArrayList<ProductVO> selectMovieProduct(String genre) {
        ArrayList<ProductVO> result = new ArrayList<>();
        result.addAll(pdao.selectMovieProduct(genre));
        return result;
    }


    public ProductVO getProduct(int pseq) {
        ProductVO result = pdao.getProduct(pseq);
        return result;
    }


    public ArrayList<ProductVO> searchList(String key) {
        ArrayList<ProductVO> result = pdao.searchList(key);
        return result;
    }

    public void Count(int pseq) {
        pdao.Count(pseq);

    }
}
