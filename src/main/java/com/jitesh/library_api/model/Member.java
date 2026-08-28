package com.jitesh.library_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long memberId ;
    @Column(nullable=false,length=50)
    private String memberName;
    @Column(nullable=false,length=50)
    private String email;

    public Member(){
    }

    public Member(String memberName,String email){
        this.memberName = memberName;
        this.email = email;
    }
    
     public Long getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setMemberName(String  memberName) {
        this.memberName = memberName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
