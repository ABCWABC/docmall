package com.mycomy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomy.domain.BoardVO;
import com.mycomy.domain.Criteria;
import com.mycomy.domain.MemberVO;
import com.mycomy.mapper.MemberMapper;

import lombok.Setter;

//수정사항 남아있음
@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public int join(MemberVO vo) throws Exception {
		return mapper.join(vo);
	}
	
	@Override
	public String checkID(String mbsp_id) throws Exception {
		return mapper.checkID(mbsp_id);
	}

	@Override
	public MemberVO login(String mbsp_id) throws Exception {
		return mapper.login(mbsp_id);
	}
	
	@Override
	public int modify(MemberVO vo) throws Exception {
		return mapper.modify(vo);
	}

	
	
	
	@Override
	public MemberVO member_info(String mbsp_id) throws Exception {
		return mapper.member_info(mbsp_id);
	}

	@Override
	public String find_id(String mbsp_name) throws Exception {
		return mapper.find_id(mbsp_name);
	}

	@Override
	public MemberVO find_pwd(String mbsp_id, String mbsp_name) throws Exception {
		return mapper.find_pwd(mbsp_id, mbsp_name);
	}

	@Override
	public void deleteUser(String mbsp_id) throws Exception {
		mapper.deleteUser(mbsp_id);
	}

//	@Override
//	public List<UserInfoVO> userinfo_list() throws Exception {
//		return mapper.userinfo_list();
//	}

	@Override
	public int getTotalCount(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardVO> getListWithSearchPaging(Criteria cri) {
		return mapper.getListWithSearchPaging(cri);
	}

//	@Override
//	public void update_pw(LoginDTO dto) throws Exception {
//		mapper.update_pw(dto);
//	}

}
