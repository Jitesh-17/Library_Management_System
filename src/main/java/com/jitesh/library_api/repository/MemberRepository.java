package com.jitesh.library_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitesh.library_api.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}