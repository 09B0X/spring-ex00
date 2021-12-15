<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="b" tagdir="/WEB-INF/tags/board"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/icon/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
  <b:navBar></b:navBar>

  <!-- .container>.row>.col>h1{회원 목록} -->
  <div class="container">
    <div class="row">
      <div class="col">
        <h1>회원 목록</h1>

        <!-- table.table>thead>tr>th*5^^tbody -->
        <table class="table">
          <thead>
            <tr>
              <th>아이디</th>
              <th>패스워드</th>
              <th>닉네임</th>
              <th>이메일</th>
              <th>주소</th>
              <th>가입일시</th>
              <th><i class="far fa-sticky-note"></i></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${memberList }" var="member">
              <tr>
                <td>${member.id }</td>
                <td><c:out value="${member.password }"/></td>
                <td><c:out value="${member.nickName }"/></td>
                <td><c:out value="${member.email }"/></td>
                <td><c:out value="${member.address }"/></td>
                <td>${member.inserted }</td>
                <th>${member.numberOfBoard }</th>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>


  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>


















