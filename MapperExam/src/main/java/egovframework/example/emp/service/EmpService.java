/**
 * 
 */
package egovframework.example.emp.service;

import java.util.List;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;

/**
 * @author user
 *
 */
public interface EmpService {
	public List<?> selectEmpList(Criteria criteria); //전체조회
	 int selectEmpListTotCnt(Criteria criteria); //총 개수 구하기
	 int insert(EmpVO empVO);
	 EmpVO selectEmp(int eno);	// 상세조회
	 int update(EmpVO empVO);	// update 메소드 기존DB 수정
	 int delete(EmpVO empVO);   // delete 메소드
}
