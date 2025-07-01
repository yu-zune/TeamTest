<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>부서 추가 페이지</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <!--    부트스트랩 css  -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!--    개발자 css -->
   <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page mt3">
   <form id="addForm" name="addForm" method="post">
   <!-- 보안토큰 -->
   <input type="hidden" name="csrf" value="${sessionScope.CSRF_TOKEN}">
        <div class="mb3">
            <label for="dname" class="form-label">dname</label>
            <input  
                  class="form-control"
                  id="dname"
                  name="dname"
                  placeholder="dname" />
        </div>
        <div class="mb3">
            <label for="loc" class="form-label">loc</label>
            <input 
                   class="form-control"
                   	id="loc"
                  name="loc"
                   placeholder="loc" />
        </div>
        <div class="mb3">
            <button class="btn btn-primary"
            		onclick="fn_save()"
            >저장</button>
            <button class="btn btn-dark"
            		onclick="history.back()"
          		>취소</button>
        </div>
    </form> 
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 유효성 체크 플러그인 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/dept/dept-validation-config.js"></script>

<script type="text/javascript">
function fn_save() {
	
	/* 저장 함수 : 저장 url : (/dept/add.do)"*/
	$("#addForm").attr("action",'<c:out value="/dept/add.do" />')
	.submit();
}
function fn_back() {
	$("#addForm").attr("action",'<c:out value="/dept/quit.do" />')
	.submit();
}
</script>



<jsp:include page="/common/footer.jsp"/>
</body>
</html>
