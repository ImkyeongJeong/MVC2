package co.jik.bootstraptest.notice.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.jik.bootstraptest.comm.Command;
import co.jik.bootstraptest.notice.service.NoticeService;
import co.jik.bootstraptest.notice.serviceImpl.NoticeServiceImpl;
import co.jik.bootstraptest.notice.vo.NoticeVO;

public class NoticeInput implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 저장
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = "c:\\Temp\\";		// 실제로 파일 저장할 공간
		int size = 1024*1024*1024;			// 파일 최대 사이즈(100MB)
		String dirFile ="";
		String originalFile ="";
		try {
			MultipartRequest multi = new MultipartRequest(
											request,
											saveDir,
											size,
											"utf-8",
											new DefaultFileRenamePolicy()); //파일이름 중복 방지
			dirFile = multi.getFilesystemName("file"); 			//물리 공간에 저장될 파일명
			originalFile = multi.getOriginalFileName("file");   //file: 내가 업로드한 실제 파일명
			
			//multi로 변환되서 multi로 읽어야 함
			vo.setWriter(multi.getParameter("writer"));
			vo.setWdate(Date.valueOf(multi.getParameter("wdate")));
			vo.setTitle(multi.getParameter("title"));
			vo.setSubject(multi.getParameter("subject"));
			vo.setFileName(originalFile);
			vo.setDirFileName(dirFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = dao.noticeInsert(vo);
		if(n != 0) {
			request.setAttribute("message", "정상입력");
		} else {
			request.setAttribute("message", "입력실패");
		}
		return "notice/noticeMessage";
	}

}
