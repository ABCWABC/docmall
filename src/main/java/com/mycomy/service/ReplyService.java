package com.mycomy.service;

import java.util.List;

import com.mycomy.domain.Criteria;
import com.mycomy.domain.ReplyPageDTO;
import com.mycomy.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);
	
	public List<ReplyVO> getList(Criteria cri, Long brd_num);
	
	public ReplyPageDTO getListPage(Criteria cri, Long brd_num);
	
	public int modifyReply(ReplyVO vo);
	
	public int deleteReply(Long brd_num, Long rly_num);
}
