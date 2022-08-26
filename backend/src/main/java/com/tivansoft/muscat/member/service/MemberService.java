package com.tivansoft.muscat.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tivansoft.muscat.member.mapper.MemberMapper;
import com.tivansoft.muscat.member.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	public List<MemberVO> getMemberList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return memberMapper.getMemberList(paramMap);
		
	}

	public int insertMember(MemberVO memberVO) {
		return memberMapper.insertMember(memberVO);
		
	}

}
