<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:url var="userUrlEdit" value="/user-edit"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <div>
         <h2>Add or update user</h2>
         <form method="POST" action="${userUrl}" enctype="multipart/form-data">
              <div>
                  <label>username</label>
                  <input type="text" name="username"/>
              </div>      
              <div>
                  <label>password</label>
                  <input type="password" name="password"/>
              </div> 
              <div>
                  <label>ảnh đại diện</label>
                  <input type="file" name="image"/>
              </div>     
              <div>
                  <button>thêm người dùng</button>
              </div>
         </form>
     </div>
</body>
</html>