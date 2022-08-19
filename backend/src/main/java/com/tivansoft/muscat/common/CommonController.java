package com.tivansoft.muscat.common;


import com.tivansoft.muscat.common.vo.CommonVO;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);


    @GetMapping("/vue/login")
    public Map<String,Object> login(){
        Map<String,Object> result = new HashMap<String,Object>();
        CommonVO commonVO = new CommonVO();
        result.put("commonVO", commonVO);
        return result;
    }


    @PostMapping("/vue/test")
    public Map<String,Object> getLogin(@RequestBody CommonVO commonVO){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("commonVO", commonVO);
        return result;
    }
}
