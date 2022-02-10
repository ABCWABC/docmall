package com.mycomy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycomy.domain.BoardVO;
import com.mycomy.domain.Criteria;
import com.mycomy.domain.MemberVO;

// 수정사항 남아있음
public interface MemberMapper {
	
	// 회원가입
	public int join(MemberVO vo) throws Exception;
	
	// 아이디 중복체크
	public String checkID(String mbsp_id) throws Exception;
	
	// 로그인인증
	public MemberVO login(String mbsp_id) throws Exception;
	
	// 회원 수정 저장
	public int modify(MemberVO vo) throws Exception;
	
	
	
	
	// 회원수정 폼
	public MemberVO member_info(String mbsp_id) throws Exception;
	
	// 아이디 찾기 : 화면출력
	public String find_id(String mbsp_name) throws Exception;
	
	// 비밀번호 찾기 : 메일전송
	public MemberVO find_pwd(@Param("mbsp_id") String mbsp_id, @Param("mbsp_name") String mbsp_name) throws Exception;
	
	// 회원 삭제
	public void deleteUser(String mbsp_id) throws Exception;
	
	// admin 회원목록
	//public List<UserInfoVO> userinfo_list() throws Exception;
	
	public int getTotalCount(Criteria cri);
	
	// 책에 없는 부분 추가
	public List<BoardVO> getListWithSearchPaging(Criteria cri);
	
	// 난수발생한 비번 업데이트
	//public void update_pw(LoginDTO dto) throws Exception;
}
