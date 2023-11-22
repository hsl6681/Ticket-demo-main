package com.example.demo.controller;

//import com.example.demo.domain.Member;
//import com.example.demo.dto.MemberDTO;

import com.example.demo.dto.JoinRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.MemberEntity;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @GetMapping("/members/new")
    public String createFrom(Model model) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        model.addAttribute("joinRequest", new JoinRequest());
        return "/members/createAccount";
    }
    @PostMapping("/members/new")
    public String create(@ModelAttribute JoinRequest joinRequest, Model model, BindingResult bindingResult){
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        // Email 중복 체크
        if(memberService.checkMemberEmailDuplicate(joinRequest.getMemberEmail())) {
            bindingResult.addError(new FieldError("joinRequest", "MemberEmail", "이메일이 중복됩니다."));
        }

        // password와 passwordCheck가 같은지 체크
        if(!joinRequest.getMemberPassword().equals(joinRequest.getMemberPasswordCheck())) {
            bindingResult.addError(new FieldError("joinRequest", "MemberPasswordCheck", "비밀번호가 일치하지 않습니다."));
        }

        if(bindingResult.hasErrors()) {
            return "/members/createAccount";
        }

        memberService.join(joinRequest);
        return "redirect:/members/login";
    }


/*    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return  "members/memberList";
    }*/

    @GetMapping("/members/login")
    public String loginForm(Model model) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");
        model.addAttribute("LoginRequest", new LoginRequest());

        return "/members/login";
    }

    @PostMapping("/members/login")
    public String login(@ModelAttribute LoginRequest loginRequest, HttpSession session, Model model, BindingResult bindingResult,
                        HttpServletRequest httpServletRequest) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");
        model.addAttribute("LoginRequest", new LoginRequest());

        MemberEntity memberEntity = memberService.login(loginRequest);
        if (memberEntity == null){
            // 로그인 실패
            bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            // 로그인 실패
            return "/members/login";
        }
        // 로그인 성공 => 세션 성공
        httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        assert memberEntity != null;
        session.setAttribute("userId", memberEntity.getMno());
        session.setMaxInactiveInterval(1800); // Session이 30분동안 유지



        return "redirect:/main";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/members/login";
    }

    @GetMapping("/mypage")
    public String mypage(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");


        MemberEntity loginUser = memberService.getLoginUserByMno(userId);

        if(loginUser != null) {
            model.addAttribute("name", loginUser.getMemberName());
            model.addAttribute("email", loginUser.getMemberEmail());
            model.addAttribute("role", loginUser.getRole());
        }
        return "/mypage";
    }
    @GetMapping("/changePassword")
    public String changePassword(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");


        MemberEntity loginUser = memberService.getLoginUserByMno(userId);

        if(loginUser != null) {
            model.addAttribute("name", loginUser.getMemberName());
            model.addAttribute("email", loginUser.getMemberEmail());
            model.addAttribute("role", loginUser.getRole());
        }
        return "/changepassword";
    }
    @GetMapping("/recentBooking")
    public String recentBooking(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");


        MemberEntity loginUser = memberService.getLoginUserByMno(userId);

        if(loginUser != null) {
            model.addAttribute("name", loginUser.getMemberName());
            model.addAttribute("email", loginUser.getMemberEmail());
            model.addAttribute("role", loginUser.getRole());
        }
        return "/recentBooking";
    }

    @GetMapping("/cInformation")
    public String clnformation(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");


        MemberEntity loginUser = memberService.getLoginUserByMno(userId);

        if(loginUser != null) {
            model.addAttribute("name", loginUser.getMemberName());
            model.addAttribute("email", loginUser.getMemberEmail());
            model.addAttribute("role", loginUser.getRole());
        }
        return "/cInformation";
    }

    @GetMapping("/consertSelect")
    public String consertSelect(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");


        MemberEntity loginUser = memberService.getLoginUserByMno(userId);

        if(loginUser != null) {
            model.addAttribute("name", loginUser.getMemberName());
            model.addAttribute("email", loginUser.getMemberEmail());
            model.addAttribute("role", loginUser.getRole());
        }
        return "/consertSelect";
    }

    @GetMapping("/seatChoose")
    public String seatChoose(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");


        MemberEntity loginUser = memberService.getLoginUserByMno(userId);

        if(loginUser != null) {
            model.addAttribute("name", loginUser.getMemberName());
            model.addAttribute("email", loginUser.getMemberEmail());
            model.addAttribute("role", loginUser.getRole());
        }
        return "/seatChoose";
    }


}

