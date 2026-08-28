package com.jitesh.library_api.service.impl;

import org.springframework.stereotype.Service;

import com.jitesh.library_api.exception.MemberNotFoundException;
import com.jitesh.library_api.model.Member;
import com.jitesh.library_api.repository.MemberRepository;
import com.jitesh.library_api.service.MemberService;

import java.util.List;


@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public Member addMember(Member member){
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(()->new MemberNotFoundException(
                    "Member with ID "+ memberId + " not found"
                ));
    }

    @Override
    public Member updateMember(Long memberId,Member member){
        Member existingMember = memberRepository.findById(memberId)
                    .orElseThrow(()-> new MemberNotFoundException("Member with Id "+ memberId +" not found"));

        existingMember.setMemberName(member.getMemberName());
        existingMember.setEmail(member.getEmail());

        return memberRepository.save(existingMember);
    }

    @Override
    public void deleteMember(Long memberId) {

        Member existingMember = memberRepository.findById(memberId)
            .orElseThrow(() ->
                    new MemberNotFoundException(
                            "Member with ID " + memberId + " not found"
                    ));

        memberRepository.delete(existingMember);
    }


}
