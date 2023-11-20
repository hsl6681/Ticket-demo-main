//package com.example.demo.dto;
//
////import com.example.demo.domain.Member;
//import com.example.demo.entity.MemberEntity;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//public class MemberDTO {
//    private Long Mno;
//    @NotBlank(message = "비밀번호가 비어있습니다.")
//    @Size(min = 1, max = 30, message = "비밀번호는 1 ~ 30자 이여야 합니다!")
//    private String MemberPassword;
//    private String MemberPasswordCheck;
//    @NotBlank(message = "이름이 비어있습니다.")
//    @Size(min = 1, max = 10, message = "이름은 1 ~ 10자 이여야 합니다!")
//    private String MemberName;
//    @NotBlank(message = "로그인 아이디가 비어있습니다.")
//    @Size(min = 1, max = 50, message = "이메일은 1 ~ 50자 이여야 합니다!")
//    @Email
//    private String MemberEmail;
//
////    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
////        MemberDTO memberDTO = new MemberDTO();
////        memberDTO.setMno(memberEntity.getMno());
////        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
////        memberDTO.setMemberName(memberEntity.getMemberName());
////        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
////
////        return memberDTO;
////    }
//    public MemberEntity toMemberEntity(String encodedPassword) {
//        return MemberEntity.builder()
//                .loginEmail(this.loginEmail)
//                .password(encodedPassword)
//                .nickname(this.nickname)
//                .role(UserRole.USER)
//                .build();
//    }
//}
