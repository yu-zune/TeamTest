<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>사원 추가 페이지</title>
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
        <div class="mb3">
            <label for="ename" class="form-label">ename</label>
            <input  
                  class="form-control"
                  id="ename"
                  name="ename"
                  placeholder="ename" />
        </div>
        <div class="mb3">
            <label for="job" class="form-label">job</label>
            <input 
                    class="form-control"
                    id="job"
                    name="job"
                   placeholder="job" />
        </div>
        <div class="mb3">
            <label for="manager" class="form-label">manager</label>
            <input 
                    class="form-control"
                    id="manager"
                    name="manager"
                   placeholder="manager" />
        </div>
        <div class="mb3">
            <label for="hiredate" class="form-label">hiredate</label>
            <input 
                    class="form-control"
                    id="hiredate"
                    name="hiredate"
                   placeholder="hiredate" />
        </div>
        <div class="mb3">
            <label for="salary" class="form-label">salary</label>
            <input 
                    class="form-control"
                    id="salary"
                    name="salary"
                   placeholder="salary" />
        </div>
        <div class="mb3">
            <label for="commission" class="form-label">commission</label>
            <input 
                    class="form-control"
                   id="commission"
                    name="commission"
                   placeholder="commission" />
        </div>
        <div class="mb3">
            <label for="dno" class="form-label">dno</label>
            <input 
                    class="form-control"
                    id="dno"
                    name="dno"
                   placeholder="dno" />
        </div>
        <div class="mb3">
            <button type="button"
            class="btn btn-primary"
            onclick="fn_save()"
            >저장</button>
        </div>
    </form>
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 유효성 체크 플러그인 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/emp/emp-validation-config.js"></script>


<script type="text/javascript">
function fn_save() {
		 alert("사원정보가 저장되었습니다.") 
	/* 저장 함수 : 저장 url : (/dept/add.do)"*/
	$("#addForm").attr("action",'<c:out value="/emp/add.do" />').submit();
}
</script>


<jsp:include page="/common/footer.jsp"/>
</body>
</html>
