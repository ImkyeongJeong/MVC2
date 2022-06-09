package co.jik.study.student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jik.study.comm.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate(); //세션객체를 완전히 삭제
		request.setAttribute("message", "정상적으로 로그아웃 완료");
		return "student/logout";
	}
}
