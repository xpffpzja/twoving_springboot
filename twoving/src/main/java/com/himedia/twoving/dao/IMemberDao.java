package com.himedia.twoving.dao;

import com.himedia.twoving.dto.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberDao {

    MemberVO getMember(String userid);
    void insertMember(MemberVO mvo);

    void updateMember(MemberVO memberdto);

    void deleteMember(String userid);
}
