package com.tivansoft.muscat.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tivansoft.muscat.member.vo.MemberVO;

@Mapper
public interface MemberMapper {

	public List<MemberVO> getMemberList(Map<String, Object> paramMap);

	public int insertMember(MemberVO memberVO);
	
}
