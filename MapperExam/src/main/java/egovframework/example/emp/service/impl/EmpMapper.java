/**
 * 
 */
package egovframework.example.emp.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;
import egovframework.example.emp.service.EmpVO;

/**
 * @author user
 *		
 *	마이바티스 
 * * 1)인터페이스:메소드명 2) xml 파일 :sql문 
 *	sql 작성할 인터페이스
 *	DeptVO
 */
@Mapper
public interface EmpMapper {
	public List<?> selectEmpList(Criteria criteria); //전체조회
	public int selectEmpListTotCnt(Criteria criteria); //총 개수 구하기
	public int insert(EmpVO empVO);
	public EmpVO selectEmp(int eno);	// 상세조회
	public int update(EmpVO empVO);	// update 메소드 기존DB 수정
	public int delete(EmpVO empVO);   // delete 메소드

}
