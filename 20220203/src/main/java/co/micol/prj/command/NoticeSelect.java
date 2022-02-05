package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 공지사항 세부내용 
		NoticeService noticeDAO = new NoticeServiceImpl();
		int id = Integer.valueOf(req.getParameter("noticeId"));
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(id);
		vo = noticeDAO.noticeSelect(vo);
		if(vo != null) {
			noticeDAO.noticeHitUpdate(id);
			req.setAttribute("notice", vo);
		} else {
			req.setAttribute("message", "조회된 데이터가 없습니다.");
			return "notice/noticeError";
		}
		return "notice/noticeSelect";
	}

}
