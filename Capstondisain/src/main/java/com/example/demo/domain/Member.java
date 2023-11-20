/*
package com.example.demo.domain;

import com.example.demo.dto.MemberDTO;
import lombok.Getter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Getter
@EnableJpaRepositories
public class Member {

    private Long key;
    private String id;
    private String pw;
    private String name;
    private String email;

    public void setKey(Long key) {
        this.key = key;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Member toMember(MemberDTO memberDTO){
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setEmail(memberDTO.getEmail());
        member.setName(memberDTO.getName());
        member.setPw(memberDTO.getPw());
        return member;
    }
}
*/
