package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 요청을 받아서 처리하는 곳
@WebServlet("*.do")
public class FrontContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//Map컬렉션 이용하여 요청&처리<Key(요청 *.do), Value>
	private HashMap<String, Command> map = new HashMap<String, Command>(); 
	
    public FrontContoller() {
        super();
    }

    //요청과 처리 명령어를 연결하는 부분 Command mapper
	public void init(ServletConfig config) throws ServletException {
		map.put("/test.do", new TestCommand()); //test.do로 요청 들어오면 TestCommand를 실행 시켜 결과가 리턴될 것이다. WEB-INF/jsp/test1.jsp
		map.put("/memberList.do", new MemberListCommand());
	}
	
	//여기서 들어온 요청을 분석하고 명령을 실행해서 결과(view page)를 돌려보내주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request에는 요청한 모든 정보를 갖고 있다.
		request.setCharacterEncoding("utf-8"); 		   		//모든 요청을 한글깨짐 방지
		String uri = request.getRequestURI(); 		   		//요청 URI 구함
		String contextPath = request.getContextPath(); 		//루트 디렉토리 정보
		String page = uri.substring(contextPath.length());	//contextPath를 빼면 실제 요청한 페이지 test.do를 page에 담음
		
		Command command = map.get(page); 					//실행할 명령객체(command)를 찾음 (new TestCommand(); value값이 담겨있음) map.get(key값(요청))하면 value를 얻을 수 있다.
		String viewPage = command.exec(request, response);	//명령을 실행(TestCommand())하고 결과를 보여줄 페이지가 담긴다. (viewPage: test1)
		
		//viewResolve(view들 중 어떤 jsp가 적절한가 선택하는 것)생성
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";	//viewPage에 경로와 확장자를 붙인 값 대입
		}
		
		//결과 페이지를 돌려준다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);// viewResolve로 인해 viewPage의 값은 /WEB-INF/jsp/test1.jsp를 찾아서 결과로 돌려보냄
		dispatcher.forward(request, response); //forward 보여줄 페이지 던져줌 (/WEB-INF/jsp/test1.jsp)
	}
}
