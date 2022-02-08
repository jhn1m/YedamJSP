package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class LoginCommand implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 로그인
		MemberService memberDao = new MemberServiceImpl();
		HttpSession session = req.getSession();
		MemberVO vo = new MemberVO();
		
		vo.setId(req.getParameter("id"));
		vo.setPassword(req.getParameter("password"));
		
		String page = null;
		vo = memberDao.memberSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			req.setAttribute("member", vo);
			page = "main.do";
		} else {
			req.setAttribute("message", "아이디 또는 패스워드가 틀립니다.");
			page = "member/memberError";
		}
		return page;
	}

}
