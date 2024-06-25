package com.himedia.twoving.dao;

import com.himedia.twoving.dto.FaqVO;
import com.himedia.twoving.dto.NoticeVO;
import com.himedia.twoving.dto.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFaqDAO {
    int getFaqAllCount();

    List<FaqVO> getFaqList(Paging paging);

    int getMemberCustomerLoginAllCount(String inquirylist);

    List<FaqVO> getFaqMemberCustomerLoginList(Paging paging, String inquirylist);

    int getPassTicketAllCount(String inquirylist);

    List<FaqVO> getFaqPassTicketList(Paging paging, String inquirylist);

    int getLoadingErrorAllCount(String inquirylist);

    List<FaqVO> getFaqLoadingErrorList(Paging paging, String inquirylist);

    int getNonPayAllCount(String inquirylist);

    List<FaqVO> getFaqNonPayList(Paging paging, String inquirylist);

    int getServiceRunAllCount(String inquirylist);

    List<FaqVO> getFaqServiceRunList(Paging paging, String inquirylist);
}
