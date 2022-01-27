package co.micol.jsptest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.jsptest.common.Command;
import co.micol.jsptest.member.service.MemberService;
import co.micol.jsptest.member.service.MemberVO;
import co.micol.jsptest.member.serviceImpl.MemberServiceImpl;

public class memberSearch implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {

		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		vo.setId("hong"); // 검색할 아이디 입력
		request.setAttribute("member", memberDao.memberSelect(vo));
		return "member/memberSearch";
	}

}
