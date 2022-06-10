package co.jik.bootstraptest.notice.service;

import java.util.List;

import co.jik.bootstraptest.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(); 	//전체조회
	List<NoticeVO> noticeSearchList(String key, String val);
	NoticeVO noticeSelect(NoticeVO vo); //상세보기
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(int id);
}
