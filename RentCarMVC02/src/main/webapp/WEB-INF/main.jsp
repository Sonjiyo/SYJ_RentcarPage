<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "util.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rentcar</title>
</head>
<body>
	<ul class="mainContent">
	<!-- header -->
		<li>
			<jsp:include page="parts/header.jsp"/>
		</li>
	<!-- content -->
		<li>
			<jsp:include page="${content}"/>
		</li>
	<!-- footer -->
		<li>
			<jsp:include page="parts/footer.jsp"/>
		</li>
	</ul>
</body>
</html>