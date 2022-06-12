package co.jik.bookstore.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.bookstore.comm.Command;

public class HomeCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "home/home";
	}

}
