package com.jitesh.library_api.service;

import java.util.List;

import com.jitesh.library_api.model.Member;

public interface MemberService {

    Member addMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(Long memberId);

    Member updateMember(Long memberId, Member member);

    void deleteMember(Long memberId);
}