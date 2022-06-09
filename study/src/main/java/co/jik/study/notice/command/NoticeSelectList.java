package co.jik.study.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.study.comm.Command;
import co.jik.study.notice.service.NoticeService;
import co.jik.study.notice.serviceImpl.NoticeServiceImpl;
import co.jik.study.notice.vo.NoticeVO;

public class NoticeSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//공지사항 목록
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		notices = dao.noticeSelectList();
		//JSP페이지에서 사용할 이름
		request.setAttribute("notices", notices);
		return "notice/noticeSelectList";
	}

}
