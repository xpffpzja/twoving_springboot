package com.himedia.twoving.dao;

import com.himedia.twoving.dto.AdminVO;
import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.dto.Paging;
import com.himedia.twoving.dto.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAdminDao {

    AdminVO getAdmin(String adminid);

    int getAllCount(String product, String name, String key);

    List<ProductVO> getProductList(Paging paging, String key);

    void insertProduct(ProductVO productvo);

    List<NoticeVO> getNoticeList(Paging paging, String key);

    void insertNotice(NoticeVO noticevo);

    NoticeVO getNotice(int nseq);

    void deleteNotice(int nseq);
}
