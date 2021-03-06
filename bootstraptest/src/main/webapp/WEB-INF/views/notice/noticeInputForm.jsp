<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>공지사항 등록</h1></div>
		<div>
			<form id="frm" action="noticeInput.do" method="post" enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="150">작성자</th>
							<td width="150">
								<input type="text" id="writer" name="writer" required="required">
							</td>
							<th width="150">작성일자</th>
							<td width="150">
								<input type="date" id="wdate" name="wdate" required="required">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">
								<input type="text" size="69" id="title" name="title" required="required">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">
								<textarea rows="10" cols="71" id="subject" name="subject" required="required"></textarea>
							</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">
								<!-- filename과 상관없는 것 값 담기지 않음 vo객체 이름과 동일하게 하면 헷갈림-->
								<input type="file" id="file" name="file">
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="저장">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
					<input type="button" value="목록으로" onclick="location.href='noticeList.do'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>