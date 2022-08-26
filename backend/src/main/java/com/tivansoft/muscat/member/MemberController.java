package com.tivansoft.muscat.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tivansoft.muscat.member.service.MemberService;
import com.tivansoft.muscat.member.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memverService;
	
    @PostMapping("/vue/memberList")
    public Map<String,Object> getMemberList(){
    	logger.debug("MemberController [getMemberList] START");
    	
        Map<String,Object> result = new HashMap<String,Object>();
        
        List<MemberVO> memberList = memverService.getMemberList();
        result.put("memberList", memberList);
        
        return result;
    }
    
    @PostMapping("/vue/insertMember")
    public Map<String,Object> insertMember(@RequestBody MemberVO memberVO){
    	logger.debug("MemberController [insertMember] START");
    	
        Map<String,Object> resultMap = new HashMap<String,Object>();
        
        resultMap.put("result", memverService.insertMember(memberVO));
        
        return resultMap;
    }
}
