package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 내용보기
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo = noticeDao.noticeSelect(vo);
//		request.setAttribute("notice", noticeDao.noticeSelect(vo));

		//
		if (vo != null) {
			noticeDao.noticeHitUpdate(vo.getNoticeId());
			request.setAttribute("notice", vo);
		} else {
			request.setAttribute("message", "조회된 데이터가 없습니다.");
			return "notice/noticeError";
		}

		// 처리하는 방법 1(오류발생위험)
		// 읽기전에 조회수를 증가시킬것인가
		// if (vo != null) {
		// noticeDao.noticeHitUpdate(vo.getNoticeId());
		// }
		return "notice/noticeSelect";
	}
}