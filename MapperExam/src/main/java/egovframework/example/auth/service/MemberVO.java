/**
 * 
 */
package egovframework.example.auth.service;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)

public class MemberVO extends Criteria{
//	EMAIL	VARCHAR2(1000 BYTE)
//	PASSWORD	VARCHAR2(1000 BYTE)
//	NAME	VARCHAR2(1000 BYTE)
//	

	private String email;		//	이메일
	private String password;	//	비밀번호
	private String name;		//	이름
	
}
