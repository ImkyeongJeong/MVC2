package co.micol.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//test.do로 요청이 들어왔을 때 처리하는 곳
		
		return "test1"; //처리했을 때 이 페이지를 보여줘라.
	}

}
