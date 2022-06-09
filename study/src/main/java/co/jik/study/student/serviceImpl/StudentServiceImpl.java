package co.jik.study.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jik.study.comm.DataSource;
import co.jik.study.student.service.StudentMapper;
import co.jik.study.student.service.StudentService;
import co.jik.study.student.vo.StudentVO;


public class StudentServiceImpl implements StudentService {
	//mybatis세션이용
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);
	
	@Override
	public List<StudentVO> studentSelectList() {
		return map.studentSelectList(); //자기 자신과 똑같은 메서드명 입력
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		return map.studentSelect(vo);
	}

	@Override
	public int studentInsert(StudentVO vo) {
		return map.studentInsert(vo);
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		return map.studentUpdate(vo);
	}

	@Override
	public int studentDelete(StudentVO vo) {
		return map.studentDelete(vo);
	}

}
