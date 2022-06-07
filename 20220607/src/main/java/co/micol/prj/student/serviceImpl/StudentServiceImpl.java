package co.micol.prj.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.DataSource;
import co.micol.prj.student.service.StudentMapper;
import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.vo.StudentVO;

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
