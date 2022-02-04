package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("id");
		String author = (String) session.getAttribute("author");
		String name = (String) session.getAttribute("name");
		System.out.println(id);
		System.out.println(author);
		System.out.println(name);
		
		req.setAttribute("message", name+"님 로그아웃 하였습니다.");
		session.invalidate(); // session 전부 삭제;
		
		return "member/memberLogoutResult";
	}

}
