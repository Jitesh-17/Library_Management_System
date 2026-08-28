package com.jitesh.library_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitesh.library_api.dto.MemberRequest;
import com.jitesh.library_api.model.Member;
import com.jitesh.library_api.service.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
        public ResponseEntity<Member> addMember(
            @Valid @RequestBody MemberRequest request) {

        Member member = new Member(
            request.getMemberName(),
            request.getEmail()
    );

    Member savedMember = memberService.addMember(member);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {

        return ResponseEntity.ok(
                memberService.getAllMembers()
        );
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberById(
            @PathVariable Long memberId) {

        return ResponseEntity.ok(
                memberService.getMemberById(memberId)
        );
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable Long memberId,@Valid @RequestBody MemberRequest request){

        Member member = new Member(request.getMemberName(),request.getEmail());

        Member updatedMember = memberService.updateMember(memberId,member);

        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(
        @PathVariable Long memberId) {

        memberService.deleteMember(memberId);

        return ResponseEntity.noContent().build();
    }


}
