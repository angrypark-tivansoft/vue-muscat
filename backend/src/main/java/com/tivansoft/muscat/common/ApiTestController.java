package com.tivansoft.muscat.common;


import com.tivansoft.muscat.common.vo.CommonVO;
import com.tivansoft.muscat.common.vo.ReceiptVO;
import com.tivansoft.muscat.common.vo.RestTempVO;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ApiTestController {

    private static final Logger logger = LoggerFactory.getLogger(ApiTestController.class);

    @Autowired
    HttpURLConnectionService httpURLConnectionService;

    @Autowired
    RestTemplateService restTemplateService;

    @Autowired
    WebClientService webClientService;

    @Autowired
    CommonService commonService;

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
                    receiptVO.setBuyCnt(itemInfo.getString("cnt"));
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

            List<ReceiptVO> itemList = restTempVO.getItemList();

            result.put("itemInfoList", restTempVO.getItemList());
            result.put("receiptInfo", restTempVO.getReceiptInfo());
            result.put("commonVO", restTempVO.getCommonVO());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    @PostMapping("/vue/postListWc")
    public Map<String,Object> postListWc(@RequestBody CommonVO commonVO){

        Map<String,Object> result = new HashMap<String,Object>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");


        try {

            Date now = new Date();
            System.out.println("시작!!!!!!!!!!!!!!!!!!! " + formatter.format(now));

            WebClient webClient = webClientService.getWebClient();
            String ordNo = "";

            RestTempVO restTempVO = null;

            for ( int rowIdx = 0; rowIdx < 5; rowIdx++ ) {

                ordNo = "20220830" + StringUtils.leftPad(Integer.toString(rowIdx + 1), 8, "0");

                restTempVO = webClientService.getReceiptInfo(webClient, commonVO, "/vue/receipt");

                for (ReceiptVO itemVo : restTempVO.getItemList()) {

                    itemVo.setCardNo(StringUtils.remove(itemVo.getCardNo(), "-"));
                    itemVo.setOrdNo(ordNo);

                    commonService.insertApiTest(itemVo);
                }


            }

            now = new Date();
            System.out.println("종료!!!!!!!!!!!!!!!!!!! " + formatter.format(now));

            //result.put("itemInfoList", restTempVO.getItemList());
            //result.put("receiptInfo", restTempVO.getReceiptInfo());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }


}
