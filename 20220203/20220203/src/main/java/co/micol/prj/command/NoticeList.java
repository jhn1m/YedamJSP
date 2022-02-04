package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 공지사항 목록
		NoticeService noticeDAO = new NoticeServiceImpl();
		req.setAttribute("notices", noticeDAO.noticeList());
		return "notice/noticeList";
	}

}
