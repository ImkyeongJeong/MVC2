package co.jik.study.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jik.study.comm.DataSource;
import co.jik.study.notice.service.NoticeMapper;
import co.jik.study.notice.service.NoticeService;
import co.jik.study.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	//오토커밋하기 위해 true로 설정
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	//이 인터페이스가 갖고 있는 값을 map에 담음 (DB연결) getMapper를 통해서 내 클래스에 값을 넣어달라
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		return map.noticeSearchList(key, val);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeHitUpdate(int id) {
		return map.noticeHitUpdate(id);
	}

}
