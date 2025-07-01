/**
 * 
 */
package egovframework.example.faq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.faq.service.FaqService;

/**
 * @author user
 *
 */
@Service
public class FaqServiceImpl implements FaqService {
//	Mapper 가져오기
	@Autowired
	private FaqMapper faqMapper;
	
	@Override
	  public List<?> selectFaqList(Criteria criteria) {
	     // TODO Auto-generated method stub
	     return faqMapper.selectFaqList(criteria);
	   }

}
