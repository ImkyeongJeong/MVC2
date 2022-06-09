<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<style type="text/css">
tr:hover {
	background-color: lightyellow;
}
</style>
<body>
	<div align="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">공지사항</h1>
		<p class="mb-4">
			DataTables is a third party plugin that is used to generate the demo
			table below. For more information about DataTables, please visit the
			<a target="_blank" href="https://datatables.net">official
				DataTables documentation</a>.
		</p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항목록</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>글번호</th>
								<th>작성자</th>
								<th>제목</th>
								<th>작성일자</th>
								<th>조회수 date</th>
							</tr>
						</thead>
						<tbody>
							<!-- el표현식 notices: 서버에서 request객체에 담은 변수 / NoticeSelectList의 request.setAttribute("notices", notices)-->
							<!-- notices중 한 레코드를 notice로 읽겠다. -->
							<c:forEach items="${notices}" var="n">
								<!-- 클릭했을 때 상세보기 (나의 id를 갖고 가라)-->
								<tr onclick="noticeSelect(${n.id})">
									<!-- notice.vo객체가 갖고 있는 값 -->
									<td align="center">${n.id}</td>
									<td align="center">${n.writer}</td>
									<td>${n.title}</td>
									<td align="center">${n.wdate}</td>
									<td align="center">${n.hit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- post방식 위한 hidden form 생성 -->
		<!-- id:js가 사용하는 변수 / name:자바가 이용하는 변수  -->
		<div>
			<form id="frm" action="noticeSelect.do" method="post">
				<input type="hidden" id="id" name="id">
			</form>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		function noticeSelect(id){
			//get방식(보안취약)
			//location.href = "noticeSelect.do?id=" + id;
			
			//post방식
			frm.id.value = id; 
			frm.submit(); //submit하면 noticeSelect.do로 이동
		}
	</script>
	
	<!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
</body>
</html>