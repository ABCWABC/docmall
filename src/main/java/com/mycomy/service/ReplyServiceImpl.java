package com.mycomy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycomy.domain.Criteria;
import com.mycomy.domain.ReplyPageDTO;
import com.mycomy.domain.ReplyVO;
import com.mycomy.mapper.BoardMapper;
import com.mycomy.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper mapper;
	private BoardMapper boardMapper;

	@Transactional
	@Override
	public int register(ReplyVO vo) {
		log.info("register.... " + vo);
		boardMapper.updateReplyCnt(vo.getBrd_num(), 1);
		return mapper.insert(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long brd_num) {
		return mapper.getListWithPaging(cri, brd_num);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long brd_num) {
		return new ReplyPageDTO(mapper.getCountByBno(brd_num), mapper.getListWithPaging(cri, brd_num));
	}

	@Override
	public int modifyReply(ReplyVO vo) {
		return mapper.update(vo);
	}
	
	@Transactional
	@Override
	public int deleteReply(Long brd_num, Long rly_num) {
		boardMapper.updateReplyCnt(brd_num, -1);
		return mapper.delete(rly_num);
	}
}
