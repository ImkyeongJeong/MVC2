package co.jik.bookstore.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.bookstore.comm.Command;
import co.jik.bookstore.home.HomeCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Map컬렉션 이용하여 요청&처리<Key(요청 *.do), Value>
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI(); 				// /bookstore/home.do
		String contextPath = request.getContextPath(); 		// /bookstore
		String page = uri.substring(contextPath.length());  // /home.do

		Command command = map.get(page);					//Key값을 던지고 value 얻음(Home()) command에 담김
		String viewPage = command.exec(request, response);	//command.exec실행하고 Home()에서 리턴해준 home/home을 viewPage에 담음
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			//viewPage = viewPage + ".tiles";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);// viewResolve로 인해 viewPage의 값은 /WEB-INF/jsp/test1.jsp를 찾아서 결과로 돌려보냄
		dispatcher.forward(request, response); //forward 보여줄 페이지 던져줌 (/WEB-INF/jsp/test1.jsp)
	}

}
