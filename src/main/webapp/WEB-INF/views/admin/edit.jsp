<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:url var="userUrlEdit" value="/admin/user-edit"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <div>
         <h2>Add or update user</h2>
         <c:set var="it" value="${getUserById}"/>
         <form modelAttribute="getUserById" method="POST" action="${userUrlEdit}" enctype="multipart/form-data">
              <div>
                  <label>username</label>
                  <input type="text" name="username" value="${getUserById.getUsername()}"/>
              </div>      
              <div>
                  <label>password</label>
                  <input type="text" name="password" value="${getUserById.getPassword()}"/>
                  <img src="/images/${getUserById.getImage()}" width="100px" height="100px"/>
              </div> 
              <div>
                  <label>ảnh đại diện</label>
                  <input type="file" name="image"/>
              </div>     
              <div>
                  <c:if test="${not empty getUserById.getId()}">
                       <button>sửa người dùng</button>
                  </c:if>
                  <c:if test="${empty getUserById.getId()}">
                       <button>thêm người dùng</button>
                  </c:if>
              </div>
         </form>
     </div>
</body>
</html>