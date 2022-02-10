package com.mycomy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycomy.domain.Criteria;
import com.mycomy.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rly_num);
	
	public int update(ReplyVO reply);
	
	public int delete(Long rly_num);
	
	public void deleteAll(Long brd_num);
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("brd_num") Long brd_num);
	
	public int getCountByBno(Long brd_num);

	
	
	
	
}
