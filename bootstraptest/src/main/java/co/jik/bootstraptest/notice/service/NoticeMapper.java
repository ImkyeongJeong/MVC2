package co.jik.bootstraptest.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jik.bootstraptest.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(); 	//전체조회
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val); //전달인자 2개 이상이면 Param필요
	NoticeVO noticeSelect(NoticeVO vo); //상세보기
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(int id);
}
