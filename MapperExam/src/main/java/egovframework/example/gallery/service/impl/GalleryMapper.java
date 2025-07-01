/**
 * 
 */
package egovframework.example.gallery.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.FileDbVO;
import egovframework.example.gallery.service.GalleryVO;

/**
 * @author user
 *마이바티스 : 1)인터페이스(함수명) 2)xml(sql)
 */
@Mapper
public interface GalleryMapper {
	List<?> selectGalleryList(Criteria criteria);	//전체 조회
	public int selectGalleryListTotCnt(Criteria criteria); //총 개수 구하기
	public int insert(GalleryVO galleryVO);					//추가
	public GalleryVO selectGallery(String uuid);			//상세조회

}
