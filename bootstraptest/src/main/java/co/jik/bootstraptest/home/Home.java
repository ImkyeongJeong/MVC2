package co.jik.bootstraptest.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.bootstraptest.comm.Command;

public class Home implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//홈페이지 보여준다
		return "home/home";
	}

}
