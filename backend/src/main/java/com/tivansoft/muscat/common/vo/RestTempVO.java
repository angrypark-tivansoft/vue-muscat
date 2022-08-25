package com.tivansoft.muscat.common.vo;


import lombok.Data;

import java.util.List;


@Data
public class RestTempVO {

    private ReceiptVO receiptInfo;
    private List<ReceiptVO> itemList;

    private CommonVO commonVO;



}
