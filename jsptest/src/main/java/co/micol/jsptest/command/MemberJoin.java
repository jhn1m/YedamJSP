package co.micol.jsptest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.jsptest.common.Command;
import co.micol.jsptest.member.service.MemberService;
import co.micol.jsptest.member.service.MemberVO;
import co.micol.jsptest.member.serviceImpl.MemberServiceImpl;

public class MemberJoin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setAddress(request.getParameter("address"));
		vo.setAuthor(request.getParameter("author"));

		int a = memberDao.memberInsert(vo);

		if (a != 0) {
			request.setAttribute("message", vo.getName() + "님 회원가입 완료");
		} else {
			request.setAttribute("message", "회원가입 실패");
		}
		return "member/memberJoinResult";
	}

}
