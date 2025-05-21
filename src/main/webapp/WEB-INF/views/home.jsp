<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  
     <div>
         <h2>Hiển thị</h2>
         <table style="border: solid;cellspacing: 0" >
           <tr>
               <th>STT</th>
               <th>username</th>
               <th>password</th>
               <th>avatar</th>
           </tr>
           <c:forEach var="it" items="${userList}">
                <tr>
                   <td>${it.getId()}</td>
                   <td>${it.getUsername()}</td>
                   <td>${it.getPassword()}</td>
                   <td><img src="/images/${it.getImage()}" width="100px" height="100px"/></td>
                </tr>
           </c:forEach>
         </table>
     </div>
     <div>
         <c:forEach begin="${1}" end="${totalPage}" var="i">
                    <a class="${i==pageNo?"active":""}" href="user-list?pageNo=${i}">${i}</a>
         </c:forEach>
     </div>
     <a href="/edit" onclick="">edit user</a>
</body>
</html>