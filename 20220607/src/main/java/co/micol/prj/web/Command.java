package co.micol.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Command: 명령이 들어왔을 때 요청을 수행
public interface Command {
	public String exec(HttpServletRequest request, HttpServletResponse response);
}