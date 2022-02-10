package com.mycomy.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  
public class BoardVO {

	private Long brd_num;
	private String mbsp_id;
	private String brd_title;
	private String brd_content;
	
	private Date brd_regdate;
	
	private int brd_readcount;
	
	private List<BoardAttachVO> attachList; 
}
