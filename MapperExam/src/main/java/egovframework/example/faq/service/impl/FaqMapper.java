/**
 * 
 */
package egovframework.example.faq.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;

/**
 * @author user
 *
 */
@Mapper
public interface FaqMapper {
	public List<?> selectFaqList(Criteria criteria); //전체조회
}
