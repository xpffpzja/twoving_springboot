package com.himedia.twoving.dao;

import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.dto.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface INoticeDAO {

    int getAllCount();

    List<NoticeVO> getNoticeList(Paging paging);
}
