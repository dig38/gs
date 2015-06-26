<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:import url="/view/header.jsp" />

	<div class="container">
		<div class="jumbotron">
			<h1>
				${title}
			</h1>
		</div>
		${message}
		
		<c:if test="${orderflag == true}">
			<c:import url="/view/orderItemsCustInfo.jsp" />
			<c:import url="/view/orderItemsList.jsp" />
		</c:if>		
		<c:if test="${custflag == true}">
			<c:import url="/view/customerBody.jsp" />
		</c:if>
    </div><!-- /.container -->
</body>
</html>