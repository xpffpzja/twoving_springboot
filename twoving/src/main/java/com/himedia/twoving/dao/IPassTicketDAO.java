package com.himedia.twoving.dao;

import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.dto.PassTicketVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IPassTicketDAO {
    MemberVO selectOnePassTicket(String userid);
}
