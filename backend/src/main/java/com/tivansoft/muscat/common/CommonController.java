package com.tivansoft.muscat.common;


import com.tivansoft.muscat.common.vo.CommonVO;

import com.tivansoft.muscat.common.vo.ReceiptVO;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);


    @GetMapping("/vue/login")
    public Map<String,Object> login(){

        logger.debug("login");

        Map<String,Object> result = new HashMap<String,Object>();
        CommonVO commonVO = new CommonVO();
        result.put("commonVO", commonVO);
        return result;
    }


    @PostMapping("/vue/test")
    public Map<String,Object> getLogin(@RequestBody CommonVO commonVO){

        logger.debug("test");

        Map<String,Object> result = new HashMap<String,Object>();
        
        
        if ( commonVO == null || commonVO.getUserId() == null ) {
            commonVO.setUserId("test");
            commonVO.setMsg("세팅되었습니다.");
        }
        
        result.put("commonVO", commonVO);
        
        
        return result;
    }

    @PostMapping("/vue/receipt")
    public Map<String,Object> getReceipt(@RequestBody CommonVO commonVO){

        Map<String,Object> result = new HashMap<String,Object>();


        ReceiptVO receiptInfo = new ReceiptVO();
        receiptInfo.setCardNo("1242-1221-3312-2165");
        receiptInfo.setTotAmt("84,000");
        receiptInfo.setVat("3,000");

        result.put("receiptInfo", receiptInfo);

        List<ReceiptVO> receiptVOList = new ArrayList<ReceiptVO>();

        ReceiptVO receiptVO = new ReceiptVO();
        receiptVO.setCardNo("1242-1221-3312-2165");
        receiptVO.setItemNm("땅콩카라멜");
        receiptVO.setAmt("30,000");
        receiptVO.setCnt("1");
        receiptVO.setTotAmt("30,000");

        receiptVOList.add(receiptVO);

        receiptVO = new ReceiptVO();
        receiptVO.setCardNo("1242-1221-3312-2165");
        receiptVO.setItemNm("마이쮸");
        receiptVO.setAmt("12,000");
        receiptVO.setCnt("2");
        receiptVO.setTotAmt("24,000");

        receiptVOList.add(receiptVO);

        receiptVO = new ReceiptVO();
        receiptVO.setCardNo("1242-1221-3312-2165");
        receiptVO.setItemNm("생크림빵");
        receiptVO.setAmt("10,000");
        receiptVO.setCnt("3");
        receiptVO.setTotAmt("30,000");

        receiptVOList.add(receiptVO);

        result.put("itemList", receiptVOList);

        result.put("commonVO", commonVO); // request


        return result;
    }

    @GetMapping("/vue/getReceipt")
    public Map<String,Object> getReceipt2(){

        Map<String,Object> result = new HashMap<String,Object>();


        ReceiptVO receiptInfo = new ReceiptVO();
        receiptInfo.setCardNo("1242-1221-3312-2165");
        receiptInfo.setTotAmt("84,000");
        receiptInfo.setVat("3,000");

        result.put("receiptInfo", receiptInfo);

        List<ReceiptVO> receiptVOList = new ArrayList<ReceiptVO>();

        ReceiptVO receiptVO = new ReceiptVO();
        receiptVO.setCardNo("1242-1221-3312-2165");
        receiptVO.setItemNm("땅콩카라멜123123123");
        receiptVO.setAmt("30,000");
        receiptVO.setCnt("1");
        receiptVO.setTotAmt("30,000");

        receiptVOList.add(receiptVO);

        receiptVO = new ReceiptVO();
        receiptVO.setCardNo("1242-1221-3312-2165");
        receiptVO.setItemNm("마이쮸123123123");
        receiptVO.setAmt("12,000");
        receiptVO.setCnt("2");
        receiptVO.setTotAmt("24,000");

        receiptVOList.add(receiptVO);

        receiptVO = new ReceiptVO();
        receiptVO.setCardNo("1242-1221-3312-2165");
        receiptVO.setItemNm("생크림빵123123123");
        receiptVO.setAmt("10,000");
        receiptVO.setCnt("3");
        receiptVO.setTotAmt("30,000");

        receiptVOList.add(receiptVO);

        result.put("itemList", receiptVOList);


        return result;
    }

}
