package co.jik.study.student.service;

import java.util.List;

import co.jik.study.student.vo.StudentVO;

public interface StudentService {
	List<StudentVO> studentSelectList();   	//전체조회
	StudentVO studentSelect(StudentVO vo); 	//한명조회
	int studentInsert(StudentVO vo); 		//추가
	int studentUpdate(StudentVO vo); 		//변경
	int studentDelete(StudentVO vo); 		//삭제
}
