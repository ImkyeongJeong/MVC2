package co.jik.bootstraptest.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.bootstraptest.comm.Command;
import co.jik.bootstraptest.home.Home;
import co.jik.bootstraptest.notice.command.AjaxSearchList;
import co.jik.bootstraptest.notice.command.NoticeInput;
import co.jik.bootstraptest.notice.command.NoticeInputForm;
import co.jik.bootstraptest.notice.command.NoticeList;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		//실행명령 두는 곳
		map.put("/home.do", new Home());	//처음 들어오는 곳 처리
		map.put("/noticeInputForm.do", new NoticeInputForm());
		map.put("/noticeInput.do", new NoticeInput());
		map.put("/noticeList.do", new NoticeList());
		map.put("/ajaxSearchList.do", new AjaxSearchList());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청분석, 실행 및 결과를 리턴하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		//command를 실행시키면 String으로 돌아옴
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) { 
				//ajax 처리하는 곳
				response.setContentType("text/html; charset=UTF-8");
				viewPage = viewPage.substring(5); 		//앞5개 잘라서 넘겨줌
				response.getWriter().append(viewPage);  //호출한 쪽에 추가해서 던짐
				return;//끝까지 내려가지 말라는 용도
			}else {
				//viewPage = viewPage + ".tiles"; //모든 view를 tiles를 태우는 것
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
