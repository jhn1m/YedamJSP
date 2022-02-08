package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class IdCheck implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 아이디 중복체크(Ajax 방법으로)
		MemberService memberDao = new MemberServiceImpl();
		String id = req.getParameter("id");
//		System.out.println(id + "================");
		boolean b = memberDao.isIdCheck(id);
		System.out.println(b);
		if(!b) { // 0은 false 1은 true 
			return "ajax:0"; // 존재할때
		} else {
			return "ajax:1"; // 존재하지 않을때
		}
	}

}
