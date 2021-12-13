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
  <!-- .container>.row>.col>h1{회원정보} -->
  <div class="container">
    <div class="row">
      <div class="col">
        <h1>회원정보</h1>
        <!-- form>.form-group*4>label[for=input$]+input.form-control[name][value] -->
        <form method="post" id="infoForm">
          <div class="form-group">
            <label for="input1">아이디</label>
            <input type="text" required id="input1" class="form-control" name="id" value="${sessionScope.loggedInMember.id }" readonly>
          </div>
          <div class="form-group">
            <label for="input2">패스워드</label>
            <input type="text" required id="input2" class="form-control" name="password" value="${sessionScope.loggedInMember.password }">
          </div>
          <div class="form-group">
            <label for="input3">이메일</label>
            <input type="email" required id="input3" class="form-control" name="email" value="${sessionScope.loggedInMember.email }">
          </div>
          <div class="form-group">
            <label for="input4">주소</label>
            <input type="text" required id="input4" class="form-control" name="address" value="${sessionScope.loggedInMember.address }">
          </div>
          <!-- button.btn.btn-outline-secondary{수정}+button.btn.btn-outline-danger{삭제} -->
          <button class="btn btn-outline-secondary" id="modifyButton">수정</button>
          <button class="btn btn-outline-danger" id="removeButton">삭제</button>
        </form>
      </div>
    </div>
  </div>


  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

  <script>
      $(document).ready(function() {
        const infoForm = $("#infoForm");

        $("#modifyButton").click(function(e) {
          e.preventDefault();
          infoForm.attr("action", "");
          infoForm.submit();
        });

        $("#removeButton").click(function(e) {
          e.preventDefault();
          if (confirm("탈퇴하시겠습니까?")) {
            infoForm.attr("action", "remove");
            infoForm.submit();
          }
        })
      });
    </script>

</body>
</html>














