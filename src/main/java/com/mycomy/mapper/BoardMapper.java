package com.mycomy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycomy.domain.BoardVO;
import com.mycomy.domain.Criteria;

public interface BoardMapper {

	public void insert(BoardVO board);
	
	public Integer insertSelectKey(BoardVO board);
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	
	public BoardVO get(Long brd_num);
	
	public int update(BoardVO board);
	
	public int delete(Long brd_num);
	
	public void updateReplyCnt(@Param("bno") Long brd_num, @Param("amount") int amount);
}
