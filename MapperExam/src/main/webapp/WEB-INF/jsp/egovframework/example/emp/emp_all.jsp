<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c 라이브러리 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 사원 목록 페이지 </title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <!--    부트스트랩 css  -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!--    개발자 css -->
   <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>

<div class="page mt3">
   <form id="listForm" name="listForm" method="get">
    <!-- 수정페이지 열기때문에 필요 -->
       <input type="hidden" id="eno" name="eno">
   		<!-- 컨트롤러로 보낼 페이지 번호 -->
       	<input type="hidden" id="pageIndex" name="pageIndex">
       
      <div class="input-group mb3 mt3">
        <input type="text" 
               class="form-control"
               id="searchKeyword"
               name="searchKeyword" 
               placeholder="사원명입력"
        >
        <button class="btn btn-primary" 
                type="button"
                onclick="fn_egov_selectList()" 
        		>
                검색
        </button>
      </div>
       <div id="result"></div>
      
      <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">사원번호</th>
            <th scope="col">사원명</th>
            <th scope="col">직위</th>
            <th scope="col">관리자</th>
            <th scope="col">입사일</th>
            <th scope="col">급여</th>
            <th scope="col">상여금</th>
            <th scope="col">부서번호</th>
          </tr>
        </thead>
        <tbody>
        <!-- 반복문 -->
        <c:forEach var="data" items="${emps}">
              <tr>
               <td>
               <a href="javascript:fn_select('<c:out value="${data.eno}" />')">
                  <c:out value="${data.eno}"></c:out>
               </a>
               </td>
               <td><c:out value="${data.ename}"></c:out></td>
               <td><c:out value="${data.job}"></c:out></td>
               <td><c:out value="${data.manager}"></c:out></td>
               <td>${fn:substring(data.hiredate, 0, 10)}</td>
               <td><c:out value="${data.salary}"></c:out></td>
               <td><c:out value="${data.commission}"></c:out></td>
               <td><c:out value="${data.dno}"></c:out></td>
             </tr>
             </c:forEach>
        </tbody>
      </table>
      <!-- 페이지네이션 페이지 번호 태그 -->
      <div class="flex-center">
      <ul class="pagination" id="pagination"></ul>
      </div>
   </form>

</div>
<!-- 꼬리말 -->
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 페이징 라이브러리 -->
<script src="/js/jquery.twbsPagination.js" type="text/javascript"></script>

<jsp:include page="/common/footer.jsp"></jsp:include>
<script type="text/javascript">
/* 수정 페이지 열기 */
function fn_select(dno) {
	$("#eno").val(dno);		// 부서번호(기본키)
	$("#listForm").attr("action",'<c:out value="/emp/edition.do" />')
	.submit();
}	


function fn_egov_link_page(pageNo) {
	/* 현재페이지번호 저장 */
	$("#pageIndex").val(pageNo);
	$("#listForm").attr("action",'<c:out value="/emp/emp.do" />')
	.submit();
}
	/* 전체 조회 */
function fn_egov_selectList() {
	$("#pageIndex").val(1);
	$("#listForm").attr("action",'<c:out value="/emp/emp.do" />')
	.submit();
}</script>


<!-- /* 페이징 처리 */ -->
<script type="text/javascript">

    $('#pagination').twbsPagination({
        totalPages: "${paginationInfo.totalPageCount}",
        startPage:parseInt("${paginationInfo.currentPageNo}"),
        visiblePages: "${paginationInfo.recordCountPerPage}",
        initiateStartPageClick: false,
        onPageClick: function (event, page) {
            /* 재조회 함수 실행 */
            fn_egov_link_page(page);
        }
    });

</script>




</body>
</html>