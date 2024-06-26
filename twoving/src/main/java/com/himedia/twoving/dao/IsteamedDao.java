package com.himedia.twoving.dao;

import com.himedia.twoving.dto.steamedVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Collection;

@Mapper
public interface IsteamedDao {

    void insertsteamed(steamedVO svo);

    ArrayList<steamedVO> steamedview(String userid, int pseq);

    void deletsteamed(int pseq);

    ArrayList<steamedVO> steamedview2(String userid);

    ArrayList<steamedVO> selectKindProduct(int kind);
}
