package com.mycomy.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	/* MBSP_TBL -- 회원테이블
	 
    MBSP_ID             VARCHAR2(15),						-- 회원아이디
    MBSP_PASSWORD       VARCHAR2(60)            NOT NULL,   -- 회원비밀번호
    MBSP_NAME           VARCHAR2(30)            NOT NULL,   -- 회원이름
    MBSP_EMAIL          VARCHAR2(50)            NOT NULL,   -- 이메일
    MBSP_ZIPCODE        CHAR(5)                 NOT NULL,   -- 우편번호
    MBSP_ADDR           VARCHAR2(100)           NOT NULL,   -- 기본주소
    MBSP_DEADDR         VARCHAR2(100)           NOT NULL,   -- 상세주소
    MBSP_PHONE          VARCHAR2(15)            NOT NULL,   -- 전화번호
    MBSP_RECEIVE        CHAR(1)  DEFAULT 'Y'    NOT NULL,   -- 이메일수신여부 Y,N
    MBSP_POINT          NUMBER   DEFAULT 0      NOT NULL,   -- 적립금 (기본 0)
    MBSP_DATESUB        DATE  DEFAULT SYSDATE   NOT NULL,   -- 가입일
    MBSP_UPDATEDATE     DATE  DEFAULT SYSDATE   NOT NULL,   -- 수정일
    MBSP_LASTLOGIN      DATE  DEFAULT SYSDATE   NOT NULL,   -- 최근 접속시간
	*/
	
	private String mbsp_id;
	private String mbsp_password;
	private String mbsp_name;
	private String mbsp_email;
	private String mbsp_zipcode;
	private String mbsp_addr;
	private String mbsp_deaddr;
	private String mbsp_phone;
	private String mbsp_receive;
	private int  mbsp_point;
	private Date mbsp_datesub;
	private Date mbsp_updatedate;
	private Date mbsp_lastlogin;
}
