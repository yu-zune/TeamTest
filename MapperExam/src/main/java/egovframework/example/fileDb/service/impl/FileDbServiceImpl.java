	/**
 * 
 */
package egovframework.example.fileDb.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.FileDbService;
import egovframework.example.fileDb.service.FileDbVO;

/**
 * @author user
 *
 */
@Service
public class FileDbServiceImpl implements FileDbService {
   @Autowired
   FileDbMapper fileDbMapper;

//   전체 조회
   @Override
   public List<?> selectFileDbList(Criteria criteria) {
      // TODO Auto-generated method stub
      return fileDbMapper.selectFileDbList(criteria);
   }

   
//   총 개수 구하기
@Override
public int selectFileDbListTotCnt(Criteria criteria) {
	// TODO Auto-generated method stub
	return fileDbMapper.selectFileDbListTotCnt(criteria);
}


//   추가(insert)
   
@Override
public int insert(FileDbVO fileDbVO) {
	// TODO 1) uuid 만들기 ( 기본키):자바에서 중복없이 무작위생성 
		String newUuid=UUID.randomUUID().toString();
//			2) 다운로드url 만들기 아래 메소드
		String downloadURL=generateDownloadUrl(newUuid);
//			3) FileDbVO 에 위의 uuid,URL을 저장
		fileDbVO.setUuid(newUuid);
		fileDbVO.setFileUrl(downloadURL);
//			4) DB에 INSERT
		return fileDbMapper.insert(fileDbVO);
}

// 다운로드 URL을 만들어주는 메소드
//URL : 웹브라우저 주소창 또는 img 태그-> 해당하는 컨트롤러 메소드가 이미지를 전송해줌
public String generateDownloadUrl(String uuid) {
//  인터넷주소 체계        : http://localhost:8080/경로(path)?쿼리스트링
//  기본주소(ContextPath): http://localhost:8080
//  URL 만드는 클래스      : ServletUriComponentsBuilder
    return ServletUriComponentsBuilder      
      .fromCurrentContextPath()
      .path("/fileDb/download.do")
      .query("uuid="+uuid)
      .toUriString();
}

//	 상세조회
@Override
public FileDbVO selectFileDb(String uuid) {
	// TODO Auto-generated method stub
	return fileDbMapper.selectFileDb(uuid);
}

//		삭제
@Override
public int delete(String uuid) {
	// TODO Auto-generated method stub
	return fileDbMapper.delete(uuid);
}
   
   



}




