<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  

     <form:form modelAttribute="userList">
		<div>
			<display:table name="userList.listReult" solid; cellspacing: 0" size="${userList.} }">
				<tr>
					<th>STT</th>
					<th>username</th>
					<th>password</th>
					<th>avatar</th>
					<th>action</th>
				</tr>
				<c:forEach var="it" items="${userList}">
					<tr>
						<td>${it.getId()}</td>
						<td>${it.getUsername()}</td>
						<td>${it.getPassword()}</td>
						<td><img src="/images/${it.getImage()}" width="100px"
							height="100px" /></td>
						<td><a href="/admin/user-edit-${it.getId()}">sửa</a>| <a
							href="/admin/user-list?deleteById=${it.getId()}">xóa</a></td>
					</tr>
				</c:forEach>
			</display:table>
		</div>
	</form:form>
     
     <div>
         <c:forEach begin="${1}" end="${totalPage}" var="i">
                    <a class="${i==pageNo?"active":""}" href="/admin/user-list?pageNo=${i}">${i}</a>
         </c:forEach>
     </div>
     
     <a href="/admin/user-edit">edit user</a>
</body>
</html>