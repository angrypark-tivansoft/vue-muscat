package com.tivansoft.muscat.common;


import com.tivansoft.muscat.common.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private CommonService commonService;

    @GetMapping("/vue/login")
    public Map<String,Object> login(){
        Map<String,Object> result = new HashMap<String,Object>();
        CommonVO commonVO = new CommonVO();
        result.put("commonVO", commonVO);
        return result;
    }


    @PostMapping("/vue/test")
    public Map<String,Object> getLogin(@RequestBody CommonVO commonVO) throws Exception {
        Map<String,Object> result = new HashMap<String,Object>();
        List<CommonVO> list =commonService.users(commonVO);
        result.put("MemberList", list);
        return result;
    }
}
