package co.jik.study.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.study.comm.Command;
import co.jik.study.home.HomeCommand;
import co.jik.study.notice.command.NoticeSelect;
import co.jik.study.notice.command.NoticeSelectList;
import co.jik.study.student.command.Login;
import co.jik.study.student.command.LoginForm;
import co.jik.study.student.command.Logout;


//모든 요청을 받아서 처리하는 곳
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Map컬렉션 이용하여 요청&처리<Key(요청 *.do), Value>
	private HashMap<String, Command> map = new HashMap<String, Command>(); 
	
    public FrontController() {
        super();
    }

    //요청과 처리를 연결하는 부분 Command mapper
	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand());
		map.put("/noticeSelectList.do", new NoticeSelectList()); //공지사항
		map.put("/noticeSelect.do", new NoticeSelect());		 //세부내역 보기
		map.put("/loginForm.do", new LoginForm());				 //로그인 폼
		map.put("/login.do", new Login());						 //로그인 처리
		map.put("/logout.do", new Logout());					 //로그아웃 처리
	}

	//여기서 들어온 요청을 분석하고 명령을 실행해서 결과(view page)를 돌려보내주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 		   		//모든 요청 한글깨짐 방지
		String uri = request.getRequestURI(); 		   		//요청 URI 구함(/study/home.do)
		String contextPath = request.getContextPath(); 		//디렉토리 정보 (/study)
		String page = uri.substring(contextPath.length());	//uri가 갖고 있는 데이터 중 contextPath길이 자르면 실제 요청한 페이지 (home.do)
		
		Command command = map.get(page); 					//실행할 명령객체(command)를 찾음 map.get(key)를 던지고 value를 받는다.
		String viewPage = command.exec(request, response);	//명령을 실행(new HomeCommand())하고 결과를 보여줄 페이지가 담긴다. (viewPage: home/home)
		//command.exec가 돌려주는 값이 String이라 viewPage앞에 String이라 선언
		
		//viewResolve(view들 중 어떤 jsp가 적절한가 선택하는 것)생성
		//endsWith: 대상 문자열이 특정 문자 또는 문자열로 끝나는지 체크하는 함수 (.do로 끝나냐)
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
//			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";	//viewPage에 경로와 확장자를 붙인 값 대입
			viewPage = viewPage + ".tiles"; //.tiles를 붙임
		}
		
		//결과 페이지를 돌려준다.
		//dispatcher: 권한위임 (내가만든 request객체를 갖고 감)
		//리다이렉트는 url 주소가 달라지고, 포워드는 url 주소가 달라지지 않는다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);// viewResolve로 인해 viewPage의 값은 /WEB-INF/jsp/test1.jsp를 찾아서 결과로 돌려보냄
		dispatcher.forward(request, response); //forward 보여줄 페이지 던져줌 (/WEB-INF/jsp/test1.jsp)
	}

}
