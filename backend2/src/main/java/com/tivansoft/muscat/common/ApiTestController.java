package com.tivansoft.muscat.common;


import com.tivansoft.muscat.common.vo.CommonVO;
import com.tivansoft.muscat.common.vo.ReceiptVO;
import com.tivansoft.muscat.common.vo.RestTempVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiTestController {

    private static final Logger logger = LoggerFactory.getLogger(ApiTestController.class);

    @Autowired
    HttpURLConnectionService httpURLConnectionService;

    @Autowired
    RestTemplateService restTemplateService;

    @PostMapping("/vue/getListHttp")
    public Map<String,Object> getListHttp(@RequestBody CommonVO commonVO){

        Map<String,Object> result = new HashMap<String,Object>();

        try {

            JSONObject resJson = httpURLConnectionService.testServiceApi();

            if ( resJson != null ) {

                ReceiptVO receiptVO = null;
                JSONObject itemInfo = null;

                JSONObject recInfo = resJson.getJSONObject("receiptInfo");

                // 영수증 통합정보
                ReceiptVO receiptInfo = new ReceiptVO();
                receiptInfo.setCardNo(recInfo.getString("cardNo"));
                receiptInfo.setTotAmt(recInfo.getString("totAmt"));
                receiptInfo.setVat(recInfo.getString("vat"));

                result.put("receiptInfo", receiptInfo);

                // 영수증 항목정보
                JSONArray itemList = resJson.getJSONArray("itemList");

                List<ReceiptVO> itemInfoList = new ArrayList<ReceiptVO>();

                for ( int idx = 0; idx < itemList.length(); idx++ ) {

                    itemInfo = itemList.getJSONObject(idx);

                    receiptVO = new ReceiptVO();
                    receiptVO.setCardNo(itemInfo.getString("cardNo"));
                    receiptVO.setItemNm(itemInfo.getString("itemNm"));
                    receiptVO.setAmt(itemInfo.getString("amt"));
                    receiptVO.setCnt(itemInfo.getString("cnt"));
                    receiptVO.setTotAmt(itemInfo.getString("totAmt"));

                    itemInfoList.add(receiptVO);
                }

                result.put("itemInfoList", itemInfoList);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    

         return result;
    }

    @PostMapping("/vue/getListRest")
    public Map<String,Object> getListRest(@RequestBody CommonVO commonVO){

        Map<String,Object> result = new HashMap<String,Object>();

        try {

            RestTempVO restTempVO = restTemplateService.getObject();

            result.put("itemInfoList", restTempVO.getItemList());
            result.put("receiptInfo", restTempVO.getReceiptInfo());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    @PostMapping("/vue/postListRest")
    public Map<String,Object> postListRest(@RequestBody CommonVO commonVO){

        Map<String,Object> result = new HashMap<String,Object>();

        try {

            RestTempVO restTempVO = restTemplateService.postObject();

            result.put("itemInfoList", restTempVO.getItemList());
            result.put("receiptInfo", restTempVO.getReceiptInfo());
            result.put("commonVO", restTempVO.getCommonVO());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }


}
