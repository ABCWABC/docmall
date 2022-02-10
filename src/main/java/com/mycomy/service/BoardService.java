package com.mycomy.service;

import java.util.List;

import com.mycomy.domain.BoardAttachVO;
import com.mycomy.domain.BoardVO;
import com.mycomy.domain.Criteria;

public interface BoardService {

	public void register(BoardVO vo);
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public BoardVO get(Long brd_num);
	
	public void modify(BoardVO board);
	
	public boolean delete(Long brd_num);
	
	public List<BoardAttachVO> getAttachList(Long brd_num);
	
	public void removeAttach(Long brd_num);
	
}
