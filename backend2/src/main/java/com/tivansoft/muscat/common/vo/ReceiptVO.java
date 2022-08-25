package com.tivansoft.muscat.common.vo;


import lombok.Data;


@Data
public class ReceiptVO {

    private String cardNo;
    private String itemNm;
    private String cnt;
    private String amt;

    private String totAmt;
    private String vat;


}
