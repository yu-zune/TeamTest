/**
 * 
 */
package egovframework.example.faq.service;

import java.util.List;

import egovframework.example.common.Criteria;

/**
 * @author user
 *
 */
public interface FaqService {
	 List<?> selectFaqList(Criteria criteria);
}
