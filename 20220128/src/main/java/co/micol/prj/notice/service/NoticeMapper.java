package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();

	NoticeVO noticeSelect(NoticeVO vo); // 한개의 게시글 가져오기

	int noticeInsert(NoticeVO vo);

	int noticeDelete(NoticeVO vo);

	int noticeUpdate(NoticeVO vo);

	void noticeHitUpdate(int id); // 조회수 증가

	// 검색기능, 검색할 필드와 데이터를 전달받음
	// 매퍼에선 전달인자가 2개 이상일때 @Param을 써야함
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("str") String str);
}