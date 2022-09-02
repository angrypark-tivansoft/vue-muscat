package com.tivansoft.muscat.common.vo;


import lombok.Data;


@Data
public class ReceiptVO {

    private String cardNo;
    private String ordNo;
    private String itemNm;
    private String buyCnt;
    private String amt;

    private String totAmt;
    private String vat;


}
