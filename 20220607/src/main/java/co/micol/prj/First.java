package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/First") //어노테이션 매핑방법 http://localhost/20220607/First 호출 주소
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public First() {
        super();
    }

    //변수명과 변수값을 달아서 요청 www.naver.com?id=ㅇㅇ&pass=ㅇㅇ; (모두 노출되어 보안에 취약)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //response객체에서 Writer갖고 옴
		out.print("<h1>Hello~</h1>");
	}

	//Form을 이용해서 form이 request객체에 실려서 요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
