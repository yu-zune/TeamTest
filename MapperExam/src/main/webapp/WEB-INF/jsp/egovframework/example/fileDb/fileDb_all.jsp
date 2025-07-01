<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
   <title>fileDb</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <!--    부트스트랩 css  -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!--    개발자 css -->
   <link rel="stylesheet" href="/css/style.css">


</head>
<body>

   <jsp:include page="/common/header.jsp" />
   <form class="page mt3" id="listForm" name="listForm" method="get">
   		<!-- 수정페이지 열기때문에 필요 -->
       	<input type="hidden" id="uuid" name="uuid">
       	<!-- 컨트롤러로 보낼 페이지 번호 -->
       	<input type="hidden" id="pageIndex" name="pageIndex">

      <div class="input-group mb3 mt3">
         <input type="text" class="form-control" 
         	id="searchKeyword"
         	name="searchKeyword"
         	placeholder="검색어입력">
         <button class="btn btn-primary" 
                 type="button"
                 onclick="fn_egov_selectList()"
         >
           검색
         </button>
      </div>
      <!-- 카드 디자인  반 복 문 -->
      <c:forEach var="data" items="${fileDbs}">
         <div class="col3">
            <div class="card">
               <img src="<c:out value='${data.fileUrl}' />" class="card-img-top"
                  alt="이미지">
               <div class="card-body">
                  <h5 class="card-title"><c:out value='${data.fileTitle}' /></h5>
                  <p class="card-text"><c:out value='${data.fileContent}' /></p>
                  <a href="#" class="btn btn-danger"
                  	onclick="fn_delete('${data.uuid}')"
                  >삭제</a>
               </div>
            </div>
         </div>
         </c:forEach>
	 <!-- 페이네이션 페이지번호 -->
      <div class="flex-center">
      <ul class="pagination" id="pagination"></ul></div>
   </form>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 페이징 라이브러리 -->
<script src="/js/jquery.twbsPagination.js" type="text/javascript"></script>

<script type="text/javascript">
<!-- 전체조회 -->
function fn_egov_selectList() {
	 $("#pageIndex").val(1); 
	$("#listForm").attr("action",'<c:out value="/fileDb/fileDb.do" />')
	.submit();
}

/* 삭제: /fileDb/delete.do */
function fn_delete(uuid) {
   /* 전체조회: method="get" -> "post" 변경해서 전달 */
   $("#uuid").val(uuid);
   $("#listForm").attr("action",'<c:out value="/fileDb/delete.do" />')
              .attr("method","post")
   .submit();
}
</script>
<!-- 페이지 번호클릭시 전체조회 -->
<script type="text/javascript">
	function fn_egov_link_page(page) {
		/* 현재페이지번호 저장 */
		$("#pageIndex").val(page);
		$("#listForm").attr("action",'<c:out value="/fileDb/fileDb.do" />')
		.submit();
	}
</script>


<script type="text/javascript">
/* 페이징 처리 */
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

<jsp:include page="/common/footer.jsp" />

</body>
</html>
