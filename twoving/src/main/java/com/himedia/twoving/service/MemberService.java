package com.himedia.twoving.service;


import com.himedia.twoving.dao.IMemberDao;
import com.himedia.twoving.dto.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    IMemberDao mdao;

    public MemberVO getMember(String userid) {
        return mdao.getMember(userid);
    }

    public void insertMember(MemberVO mvo) {
        mdao.insertMember(mvo);
    }

    public void updateMember(MemberVO memberdto) {
        mdao.updateMember(memberdto);
    }

    public void deleteMember(String userid) {
        mdao.deleteMember(userid);
    }

//    public void updateMember(MemberVO memberdto) {
//        mdao.updateMember(memberdto);
//    }
}
