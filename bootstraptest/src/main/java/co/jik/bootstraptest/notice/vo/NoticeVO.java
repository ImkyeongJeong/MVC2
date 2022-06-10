package co.jik.bootstraptest.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id;
	private String writer;
	private String title;
	private String subject;
	
	//변수 위에 있는 어노테이션은 다음줄에만 영향을 미침
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	
	private Date wdate;
	private int hit;
	private String fileName;
	private String dirFileName;
}
