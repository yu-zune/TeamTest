/**
 *
 */
$("#addForm").validate({
  rules: {
    // 유효성 검사 규칙
    ename: {
      // 사원이름 필드
      required: true, // 필수 입력
      minlength: 2, // 최소 입력 길이
    },
    job: {
      // 직위 필드
      required: true, // 필수 입력
      minlength: 2, // 최소 입력 길이
    },
    manager: {
      // 관리자번호 필드
      required: true, // 필수 입력
      minlength: 4, // 최소 입력 길이,
      digits: true,   // 숫자 형태로만 입력가능하도록
    },
    hiredate: {
      // 입사일 필드
      required: true, // 필수 입력
      date: true, // 날짜 포맷(yyyy-MM-dd)
    },
    salary: {
      // 급여 필드
      required: true, // 필수 입력
      digits: true, // 숫자 형태로만 입력 가능하도록 설정
    },
    commission: {
      // 상여금,보너스 필드
      required: true, // 필수 체크
      digits: true, // 숫자 형태로만 입력 가능하도록 설정
    },
    dno: {
     //	부서번호 필드
      required: true,     // 필수 입력
      digits: true, // 숫자 형태로만 입력 가능하도록 설정         // 날짜 포맷(yyyy-MM-dd)
    }
  },
  messages: {
    // 오류값 발생시 출력할 메시지 수동 지정
    ename: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {2}글자 이상 입력하세요.",
    },
    job: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {2}글자 이상 입력하세요.",
    },
    manager: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {4}글자 이상 입력하세요.",
      digits: "반드시 숫자만 입력하세요.",
    },
    hiredate: {
      required: "필수 입력 항목입니다.",
      date: "날짜 포맷(YYYY-MM-dd)만 입력하세요",
    },
    salary: {
      required: "필수 입력 항목입니다.",
      digits: "반드시 숫자만 입력하세요.",
    },
    commission: {
      required: "필수 체크 항목입니다.",
      digits: "반드시 숫자만 입력하세요.",
    },
    dno: {
      required: "필수 입력 항목입니다.",
     digits: "반드시 숫자만 입력하세요.",
    }
  },
});
