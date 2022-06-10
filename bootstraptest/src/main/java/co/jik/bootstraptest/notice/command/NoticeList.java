package co.jik.bootstraptest.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jik.bootstraptest.comm.Command;
import co.jik.bootstraptest.notice.service.NoticeService;
import co.jik.bootstraptest.notice.serviceImpl.NoticeServiceImpl;
import co.jik.bootstraptest.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 목록 가져오기
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		list = dao.noticeSelectList();
		
		request.setAttribute("list", list);
		return "notice/noticeList";
	}

}
