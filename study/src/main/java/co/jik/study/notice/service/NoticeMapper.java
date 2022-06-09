package co.jik.study.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jik.study.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	//Mybatis의 SQL 문장에 다수의 파라미터를 전달할 때는 전달되는 변수들에 꼭 @Param 어노테이션을 붙여줘야한다.
	//Mapper인터페이스에서 전달인자 두개이상일 때 인식을 못함 @Param을 쓰면 넘어온 값을 Pram이 받아서 처리한다. 
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val")String val);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeHitUpdate(int id);
}
