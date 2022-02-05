package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceIml.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(); // 세션 객체를 가져옴

		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		vo.setId(req.getParameter("id"));
		vo.setPassword(req.getParameter("password"));

		vo = memberDAO.memberSelect(vo);

		if (vo != null) {
			session.setAttribute("id", vo.getId()); // 아이디 저장
			session.setAttribute("author", vo.getAuthor()); // 권한 저장
			session.setAttribute("name", vo.getName()); // 이름 저장
			req.setAttribute("message", vo.getId() + "환영합니다.");
		} else {
			req.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		return "member/memberLoginResult";
	}

}
