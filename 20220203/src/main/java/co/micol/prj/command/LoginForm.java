package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class LoginForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "member/memberLoginForm";
	}

}
