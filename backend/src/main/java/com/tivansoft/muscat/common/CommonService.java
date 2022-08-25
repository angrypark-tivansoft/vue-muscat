package com.tivansoft.muscat.common;

import com.tivansoft.muscat.common.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class CommonService {
   @Autowired
   private CommonMapper mapper;


    public List<CommonVO> users(CommonVO commonVO) throws Exception {
        List<CommonVO> list = mapper.selectMemberList(commonVO);
        return list;
    }


}
