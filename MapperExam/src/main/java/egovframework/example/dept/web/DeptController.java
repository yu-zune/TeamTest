/**
 * 
 */
package egovframework.example.dept.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptService;
import egovframework.example.dept.service.DeptVO;
import lombok.extern.log4j.Log4j2;

/**
 * @author user
 *
 */

@Log4j2
@Controller
public class DeptController {

//	서비스 가져오기
	@Autowired
	private DeptService deptService;
	
	
//	전체 조회
	@GetMapping("/dept/dept.do")
	public String name(@ModelAttribute Criteria criteria,
			Model model) {
//		1) 등차자동계산 클래스 : paginationInfo
//			- 필요정보 :  1) 현재페이지번호(pageIndex), 2) 보일개수(pageUnit) : 3
		PaginationInfo paginationInfo=new PaginationInfo();
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit());
//		등차를 자동 계산:firstRecordIndex 필드에 있음
		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());

		
//		 전체조회 서비스 메소드 실행
			
			List<?> depts=deptService.selectDeptList(criteria);
		      log.info("테스트 : "+depts);
		      model.addAttribute("depts", depts);		
		
//		페이지 번호 그리기: page plugin(전체테이블 행 갯수)		
		int totCnt=deptService.selectDeptListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);
		
		log.info("테스트2 : "+totCnt);
		
//		페이지 모든정보: paginationInfo
		model.addAttribute("paginationInfo", paginationInfo);
		
	      return "dept/dept_all";
	    }
	

//		추가 페이지 열기
	@GetMapping("/dept/addition.do")
	public String createDeptView(Model model) {
		model.addAttribute("deptVO", new DeptVO());
		return "dept/add_dept";
	}
	
	
//  insert : 저장 버튼 클릭시
  @PostMapping("/dept/add.do")
  public String insert(@ModelAttribute DeptVO deptVO) {
//     deptVO 내용확인
	  log.info("테스트3 :+deptVO;");
//	  서비스의 insert 실행
	  deptService.insert(deptVO);
	  	 	  
	 return "redirect:/dept/dept.do";
  }
	
//  수정페이지 열기 (상세조회)
  @GetMapping("/dept/edition.do")
  public String updateDeptView(@RequestParam int dno, Model model) {
    
     //  서비스의 상세조회
     	DeptVO deptVO=deptService.selectDept(dno);
     	model.addAttribute("deptVO", deptVO);
     	return "dept/update_dept";
   } 
  
//수정: 버튼 클릭시 실행
@PostMapping("/dept/edit.do")
public String update(@RequestParam int dno,
       @ModelAttribute DeptVO deptVO) {
	  
//	서비스의 수정실행
	deptService.update(deptVO);
	return "redirect:/dept/dept.do";
}

//삭제 : 버튼 클릭시 실행
@PostMapping("/dept/delete.do")
public String delete(@RequestParam int dno,
	       @ModelAttribute DeptVO deptVO) {
//	서비스의 삭제 메소드 실행
	deptService.delete(deptVO);
	return "redirect:/dept/dept.do";
}
@PostMapping("/dept/quit.do")
public String name() {
	return "redirect:/dept/dept.do";
}




  
	
	
}
