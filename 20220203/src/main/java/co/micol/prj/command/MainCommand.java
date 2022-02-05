package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "main/main"; // 처음시작하는 페이지를 돌려줌
	}

}
