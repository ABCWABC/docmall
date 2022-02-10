package com.mycomy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycomy.domain.BoardAttachVO;
import com.mycomy.domain.BoardVO;
import com.mycomy.domain.Criteria;
import com.mycomy.mapper.BoardAttachMapper;
import com.mycomy.mapper.BoardMapper;
import com.mycomy.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
	@Transactional
	@Override
	public void register(BoardVO board) {
		
		log.info("register...." + board);
		mapper.insertSelectKey(board);
		
		log.info("bno: " + board.getBrd_num());
		
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		board.getAttachList().forEach(attach -> {
			attach.setBrd_num(board.getBrd_num());
			attachMapper.insert(attach);
		});
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public BoardVO get(Long brd_num) {
		return mapper.get(brd_num);
	}

	@Transactional
	@Override
	public void modify(BoardVO board) {
		
		attachMapper.deleteAll(board.getBrd_num()); 
		boolean modifyResult = mapper.update(board) == 1;
		
		if(modifyResult && board.getAttachList() != null && board.getAttachList().size() >= 0) {
			board.getAttachList().forEach(attach -> {
				attach.setBrd_num(board.getBrd_num());
				attachMapper.insert(attach);
			});
		}
	}

	@Transactional
	@Override
	public boolean delete(Long Brd_num) {
		
		replyMapper.deleteAll(Brd_num);
		attachMapper.deleteAll(Brd_num);
		
		return mapper.delete(Brd_num) == 1;
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long Brd_num) {
		return attachMapper.findByBrd_num(Brd_num);
	}

	@Override
	public void removeAttach(Long Brd_num) {
		attachMapper.deleteAll(Brd_num);
	}
}
