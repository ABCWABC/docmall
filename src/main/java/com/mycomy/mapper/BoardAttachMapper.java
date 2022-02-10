package com.mycomy.mapper;

import java.util.List;

import com.mycomy.domain.BoardAttachVO;

public interface BoardAttachMapper {

	public void insert(BoardAttachVO vo);
	
	public List<BoardAttachVO> findByBrd_num(Long brd_num);
	
	public void delete(String uuid);
	
	public void deleteAll(Long brd_num);
	
	public List<BoardAttachVO> getOldFiles();
}
