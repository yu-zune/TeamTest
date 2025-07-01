/**
 * 
 */
package egovframework.example.auth.web;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.example.auth.service.MemberService;
import egovframework.example.auth.service.MemberVO;

/**
 * @author user
 *
 */
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
//	로그인 화면 열기
	@GetMapping("/login.do")
	public String loginView() {
		return "auth/login";
	}
	
//	로그인 처리 (보안목적으로 Post 사용)
//	@GetMapping 1)조회(로그인) => id,  암호(주소창에 표시)
//	@PostMapping 2)입력/수정/삭제 => id, 암호(주소창에 표시안됨)
	@PostMapping("/loginProcess.do")
	public String login(HttpSession session, @ModelAttribute MemberVO 
			loginVO) throws Exception {
//		1)DB에 입력된 유저가 있는지 확인 :  서비스의 로그인 메소드 실행
		MemberVO memberVO=memberService.authenticate(loginVO);
//		2)세션을 만듦 : 유저저장(세션 :  정보를 임시로 저장하는 공간 : 서버컴퓨터(스프링)에 저장)
//		사용법 : session.setAttribute("key",value);
		session.setAttribute("memberVO", memberVO);
//		(DB(영구적) vs 세션 (임시:컴퓨터리부트,웹브라우저종료 시 사라짐))
//		2-2) 보안코딩: CSRF(사이트 위조) 공격 방어 : 인증 토큰(세션)
		session.setAttribute("CSRF_TOKEN", UUID.randomUUID().toString());

//		3)통과하면 이동할 페이지 강제 이동
		return  "redirect:/";
	}
	
//	로그 아웃
	@GetMapping("/logout.do")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();			//무효화
		return "redirect:/login.do";	//로그인페이지로 강제이동
	}
//  회원가입 페이지 열기
  @GetMapping("/register.do")
  public String registerView() {
     return "auth/register";
  }	
	
//  	회원가입 처리
  @PostMapping("/register/addition.do")
   public String register(Model model, @ModelAttribute MemberVO 
		   memberVO) throws Exception {
//	  서비스의 회원가입 메소드 실행
	  memberService.register(memberVO);
//	  성공메시지 jsp전달
	  model.addAttribute("msg", "회원 가입을 성공했습니다.");
	return "auth/register";
}
  
  
  
	
}
