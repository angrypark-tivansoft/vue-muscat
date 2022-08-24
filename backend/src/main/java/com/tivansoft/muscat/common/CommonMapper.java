package com.tivansoft.muscat.common;

import com.tivansoft.muscat.common.vo.CommonVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CommonMapper {
    List<CommonVO> selectMemberList(CommonVO commonVO) throws Exception;
}


