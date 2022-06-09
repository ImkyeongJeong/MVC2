package co.jik.study.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jik.study.comm.Command;
import co.jik.study.student.service.StudentService;
import co.jik.study.student.serviceImpl.StudentServiceImpl;
import co.jik.study.student.vo.StudentVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StudentService dao = new StudentServiceImpl();
		HttpSession session = request.getSession(); //HttpSession은 인터페이스라 초기화 불가 내 브라우저가 갖고 있는 session으로 초기화 해준다.
													//session은 jsp파일 전역에서 다 사용할 수 있음
		
		StudentVO vo = new StudentVO();
		vo.setStudentId(request.getParameter("studentId"));
		vo.setPassword(request.getParameter("password"));
		
		//id만 넘기면 한 명의 데이터 조회/ id&pw넘기면 로그인
		vo = dao.studentSelect(vo);
		
		if(vo != null) {
			//세션에 ID, 이름, 권한을 담음
			session.setAttribute("id", vo.getStudentId()); 
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			//session.setAttribute("vo", vo); //한번에 모두 지정해 줄 수 있음 (${key.필드명} 입력하면 해당 데이터 추출 가능)
			//message변수 생성해서 셋팅
			request.setAttribute("message", vo.getName()+"님 환영합니다.");
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "student/login"; //로그인페이지 리턴
	}

}
