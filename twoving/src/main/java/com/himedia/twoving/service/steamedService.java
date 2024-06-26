package com.himedia.twoving.service;

import com.himedia.twoving.dao.IsteamedDao;
import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.dto.ProductVO;
import com.himedia.twoving.dto.steamedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Service
public class steamedService {

    @Autowired
    IsteamedDao sdao;

    public void insertsteamed(steamedVO svo) {
        sdao.insertsteamed(svo);



    }

    public void deletsteamed(int pseq) {
        sdao.deletsteamed(pseq);
    }

    public ArrayList<steamedVO> steamedview2(String userid) {
        ArrayList<steamedVO> result = new ArrayList<>();
        result.addAll(sdao.steamedview2(userid));
        return result;
    }

    public ArrayList<steamedVO> selectKindProduct(int kind) {
        ArrayList<steamedVO> result = new ArrayList<>();
        result.addAll(sdao.selectKindProduct(kind));
        return result;
    }
}
