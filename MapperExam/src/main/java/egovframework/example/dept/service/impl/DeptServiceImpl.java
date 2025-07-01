/**
 * 
 */
package egovframework.example.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptService;
import egovframework.example.dept.service.DeptVO;

/**
 * @author user
 *
 */
@Service
public class DeptServiceImpl implements DeptService{
//	Mapper 가져오기
	@Autowired
	private DeptMapper deptMapper;

//  전체 조회
  @Override
  public List<?> selectDeptList(Criteria criteria) {
     // TODO Auto-generated method stub
     return deptMapper.selectDeptList(criteria);
   }

// 	총 개수 구하기  
@Override
public int selectDeptListTotCnt(Criteria criteria) {
	// TODO Auto-generated method stub
	return deptMapper.selectDeptListTotCnt(criteria);
}

@Override
public int insert(DeptVO deptVO) {
	// TODO Auto-generated method stub
	return deptMapper.insert(deptVO);
}

//상세 조회
@Override
public DeptVO selectDept(int dno) {
	// TODO Auto-generated method stub
	return deptMapper.selectDept(dno);
}

// 수정
@Override
public int update(DeptVO deptVO) {
	// TODO Auto-generated method stub
	return deptMapper.update(deptVO);
}

// 삭제
@Override
public int delete(DeptVO deptVO) {
	// TODO Auto-generated method stub
	return deptMapper.delete(deptVO);
}





}
