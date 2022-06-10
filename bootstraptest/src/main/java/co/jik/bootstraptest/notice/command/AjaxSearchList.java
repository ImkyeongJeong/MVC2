package co.jik.bootstraptest.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.jik.bootstraptest.comm.Command;
import co.jik.bootstraptest.notice.service.NoticeService;
import co.jik.bootstraptest.notice.serviceImpl.NoticeServiceImpl;
import co.jik.bootstraptest.notice.vo.NoticeVO;

public class AjaxSearchList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 검색
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		//json을 string으로 만들기 위해 선언
		ObjectMapper mapper = new ObjectMapper();
		
		//form의 name이 key, val인 값
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		System.out.println(key);
		System.out.println(val);
		list = dao.noticeSearchList(key, val);
		
		
		//리스트를 json String으로
		String jsonData = "";
		try {
			jsonData = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonData);
		return "ajax:" + jsonData; //service로 리턴
	}
}
