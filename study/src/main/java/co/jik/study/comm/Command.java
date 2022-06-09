package co.jik.study.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//HttpServletRequest, HttpServletResponse 인터페이스
	//exec실행이란 의미
	public String exec(HttpServletRequest request, HttpServletResponse response);
}
