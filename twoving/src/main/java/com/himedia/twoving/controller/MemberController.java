package com.himedia.twoving.controller;

import com.google.gson.Gson;
import com.himedia.twoving.dao.IMemberDao;
import com.himedia.twoving.dto.OAuthToken;
import com.himedia.twoving.dto.KakaoProfile;
import com.himedia.twoving.dto.MemberVO;
import com.himedia.twoving.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class MemberController {

    @Autowired
    MemberService ms;

    @GetMapping("/index")
    public String index() {
        return "member/indexForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "member/loginForm";
    }


    @GetMapping("/mypage")
    public String mypage() {
        return "mypage/mypage";
    }

    @GetMapping("/updateMemberForm")
    public String updateMemberForm() {
        return "mypage/updateMember";
    }

    @PostMapping("/updateMember")
    public String updateMember(@ModelAttribute("dto") @Valid MemberVO memberdto, BindingResult result, Model model,
                              HttpServletRequest request){
        String url = "mypage/updateMember";
        if (result.getFieldError("pwd")!=null) {
            model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
        } else if (result.getFieldError("name")!=null) {
            model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
        } else if (result.getFieldError("phone")!=null) {
            model.addAttribute("message", result.getFieldError("phone").getDefaultMessage());
        } else if (result.getFieldError("email")!=null) {
            model.addAttribute("message", result.getFieldError("email").getDefaultMessage());
//

        }else {
            ms.updateMember(memberdto);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", memberdto);
            url="redirect:/mypage";
        }

        return url;
    }



    @PostMapping("/login")
    public String login(@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result,
                        Model model, HttpServletRequest request ) {
        String url = "member/loginForm";
        if(result.getFieldError("userid")!=null)
            model.addAttribute("message", result.getFieldError("userid").getDefaultMessage());
        else if( result.getFieldError("pwd")!=null)
            model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
        else{
            MemberVO mvo = ms.getMember( membervo.getUserid() );
            if( mvo == null )
                model.addAttribute("message", "아이디/비번을 확인하세요");
            else if( !mvo.getPwd().equals( membervo.getPwd() ) )
                model.addAttribute("message", "아이디/비번을 확인하세요");
            else if( mvo.getPwd().equals( membervo.getPwd() ) ){
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", mvo);
                model.addAttribute("message","회원정보 수정이 완료되었습니다.");
                url = "redirect:/Tmain";
                model.addAttribute("showAlert", true);
            }
        }
        return url;
    }

    @GetMapping("/deleteMemberForm")
    public String deleteMemberForm(){
        return "mypage/deleteMember";
    }

    @GetMapping("/deleteMember")
    public String deleteMember(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        MemberVO mdto = (MemberVO)session.getAttribute("loginUser");
        ms.deleteMember(mdto.getUserid());
        model.addAttribute("message", "회원탈퇴가 완료되었습니다.");
        return "member/loginForm";
    }

    @GetMapping("/findIdForm")
    public String findIdForm() {
        return "mypage/findId";
    }

    @GetMapping("/findPwdForm")
    public String findPwdForm() {
        return "mypage/findPwd";
    }



    @GetMapping("/kakaostart")
    public @ResponseBody String kakaostart() {
        String a = "<script type='text/javascript'>"
                + "location.href='https://kauth.kakao.com/oauth/authorize?"
                + "client_id=4fde1cbde4d82ed7b25bd2a750d98d3c"
                + "&redirect_uri=http://localhost:8070/kakaoLogin"
                + "&response_type=code'"
                + "</script>";
        return a;
    }

    @GetMapping("/kakaoLogin")
    public String login( HttpServletRequest request  ) throws IOException {
        String code = request.getParameter("code");
        System.out.println(code);  // 토큰 출력

        // 실제 User info 를 요청할 url 과 전달인수 설정
        String endpoint="https://kauth.kakao.com/oauth/token";
        URL url =new URL(endpoint);  //import java.net.URL;   예외처리  add throws 로 처리
        String bodyData="grant_type=authorization_code";
        bodyData += "&client_id=4fde1cbde4d82ed7b25bd2a750d98d3c";
        bodyData += "&redirect_uri=http://localhost:8070/kakaoLogin";
        bodyData += "&code="+code;

        //Stream 연결  // import - java.net.HttpURLConnection;
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        //http header 값 넣기(요청 내용에 헤더 추가)
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        conn.setDoOutput(true);

        //인증절차를 완료하고 User info 요청을 위한 정보를 요청 및 수신합니다
        BufferedWriter bw=new BufferedWriter(
                new OutputStreamWriter(conn.getOutputStream(),"UTF-8")
        );
        bw.write(bodyData);
        bw.flush();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8")
        );

        String input="";
        StringBuilder sb=new StringBuilder();  // 조각난 String 을 조립하기위한 객체
        while((input=br.readLine())!=null){
            sb.append(input);
            System.out.println(input);
        }

        // 사용자가 실제로 동의한 항목들만 요청하고 받을 수 있도록 권한을 갖고 있는 새로운 토큰으로 구성
        // {"access_token":"tEbj6Ck2JLTV65c8BscVS-3h0SCluSHnAAAAAQo9dJgAAAGQLmafSwGXonZVdqHq","token_type":"bearer","refresh_token":"CyWRQ79bVdveeRjJVhFdFDxMGVL7BpjSAAAAAgo9dJgAAAGQLmafRwGXonZVdqHq","expires_in":21599,"scope":"account_email profile_nickname","refresh_token_expires_in":5183999}

        // 수신내용을  GSon 으로 변경(파싱)하고 준비된 객체에 옮겨 담습니다
        Gson gson=new Gson();
        OAuthToken oAuthToken=gson.fromJson(sb.toString(), OAuthToken.class);
        // oAuthToken <- sb{"access_token":"HCqlu2GvtRSqZxYLVfvI_hS5UWBqR ....
        // sb 내용을 항목에 맞춰서  OAuthToken 객체에 옮겨 담습니다



        // 실제 정보 요청 및 수신
        String endpoint2="https://kapi.kakao.com/v2/user/me";
        URL url2 =new URL(endpoint2);
        // import java.net.HttpURLConnection
        HttpsURLConnection conn2=(HttpsURLConnection)url2.openConnection();
        //header 값 넣기
        conn2.setRequestProperty("Authorization", "Bearer "+oAuthToken.getAccess_token());
        conn2.setDoOutput(true);
        // UserInfo 수신
        BufferedReader br2=new BufferedReader(
                new InputStreamReader(conn2.getInputStream(),"UTF-8")
        );
        String input2="";
        StringBuilder sb2=new StringBuilder();
        while((input2=br2.readLine())!=null) {
            sb2.append(input2);
            System.out.println(input2);
        }
        // 수신내용
        // {"id":2844973154, "connected_at":"2023-06-15T12:52:20Z", "properties":{"nickname":"강희준"}, "kakao_account":{"profile_nickname_needs_agreement":false, "profile":{"nickname":"강희준","is_default_nickname":false}, "has_email":true, "email_needs_agreement":false,"is_email_valid":true,"is_email_verified":true,"email":"heejoon73@daum.net"}}

        Gson gson2=new Gson();
        KakaoProfile kakaoProfile=gson2.fromJson(sb2.toString(), KakaoProfile.class);

        System.out.println(kakaoProfile.getId());
        KakaoProfile.KakaoAccount ac = kakaoProfile.getAccount();
        System.out.println( ac.getEmail() );
        KakaoProfile.KakaoAccount.Profile pf = ac.getProfile();
        System.out.println( pf.getNickname() );

        MemberVO mvo = ms.getMember( kakaoProfile.getId() );
        if( mvo == null){
            mvo = new MemberVO();
            mvo.setUserid( kakaoProfile.getId() );
            mvo.setEmail( ac.getEmail() );
            // mvo.setEmail( "kakao" );
            mvo.setName( pf.getNickname() );
            mvo.setProvider("kakao");
            mvo.setPwd("kakao");
            mvo.setPhone("");
            ms.insertMember( mvo );
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", mvo);
        return "redirect:/mypage";

    }
    
    
    
    
    @GetMapping("/joinForm")
    public String joinForm()  {
        return "member/joinForm";
    }

    @GetMapping("/idcheckForm")
    public ModelAndView idcheckForm(@RequestParam("userid") String userid)  {
        ModelAndView mav = new ModelAndView();
        MemberVO mvo = ms.getMember( userid );
        if( mvo == null)
            mav.addObject("result" , -1);
        else
            mav.addObject("result" , 1);
        mav.addObject("userid", userid);
        mav.setViewName("member/idcheck");
        return mav;
    }


    @PostMapping("/join")
    public String join( @ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result, @RequestParam(value="reid", required=false) String reid, @RequestParam(value="pwdCheck", required=false) String pwdCheck, Model model) {
        String url = "member/joinForm";
        if( result.getFieldError("userid") != null)
            model.addAttribute("message", result.getFieldError("userid").getDefaultMessage());
        else if( result.getFieldError("pwd") != null)
            model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
        else if( result.getFieldError("name") != null)
            model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
        else if( result.getFieldError("email") != null)
            model.addAttribute("message", result.getFieldError("email").getDefaultMessage());
       else {
            url = "member/loginForm";
            model.addAttribute("message", "회원가입이 완료되었습니다. 로그인하세요");
            ms.insertMember( membervo );
        }
        return url;
    }


}
