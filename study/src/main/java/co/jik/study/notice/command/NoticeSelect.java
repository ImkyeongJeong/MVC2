package co.jik.study.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.study.comm.Command;
import co.jik.study.notice.service.NoticeService;
import co.jik.study.notice.serviceImpl.NoticeServiceImpl;
import co.jik.study.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//세부목록 보기
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(request.getParameter("id"))); //getParameter로 읽을 key값(id)의 value를 담음 request가 String이라 Integer
		vo = dao.noticeSelect(vo);
		
		//JSP페이지에서 사용할 이름
		request.setAttribute("notice", vo);
		
		//보여줄페이지
		return "notice/noticeSelect"; 
	}
}
