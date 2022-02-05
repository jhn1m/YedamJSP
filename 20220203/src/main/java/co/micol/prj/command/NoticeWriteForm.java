package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class NoticeWriteForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "notice/noticeWriteForm";
	}

}
