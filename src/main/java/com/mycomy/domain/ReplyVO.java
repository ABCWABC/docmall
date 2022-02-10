package com.mycomy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	// rly_num, brd_num, reply, replyer, replydate
	private Long rly_num;
	private Long brd_num;  
	
	private String reply;
	private String replyer;
	private Date replydate;
}
