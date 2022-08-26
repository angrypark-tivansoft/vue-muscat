package com.tivansoft.muscat.member.vo;

import lombok.Data;

@Data
public class MemberVO {
	private int userSeq; // 사용자SEQ (일련번호 1 ~ 9999999999까지 1씩 증가하는 일련번호)
	private int frstWrtrSeq; // 최초작성자SEQ
	private String frstWrtDtim; // 최초수정일시
	private int lastChngSeq; // 최종수정자SEQ
	private String lastChngDtim; // 최종수정일시
	private String useYn;
	private String delYn;
	private String userId;
	private String pswd;
	private String initPswdYn;
	private String userNm;
	private String pstn;
	private String blngTo;
	private String cellNo;
	private String mail;
	private String entrDate;
	private int pswdErrCnt;
	private String localYn;
	
}
