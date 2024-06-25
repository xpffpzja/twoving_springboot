package com.himedia.twoving.dao;

import com.himedia.twoving.dto.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface IProductDao {

    public List<ProductVO> getMainList();

    public List<ProductVO> getBestList();
    public List<ProductVO> getNewList();

    public List<ProductVO> getBestList2();
    public List<ProductVO> getNewList2();

    //public Integer getKindList(int kind);

    public List<ProductVO> selectKindProduct(int kind);

    public List<ProductVO> selectSeriesProduct(String genre);

    public List<ProductVO> selectMovieProduct(String genre);

    ProductVO getProduct(int pseq);

    public ArrayList<ProductVO> searchList(String key);

    void Count(int pseq);
}
