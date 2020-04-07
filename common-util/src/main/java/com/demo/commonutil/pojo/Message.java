package com.demo.commonutil.pojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    private String goodsID="";
    private String goodsName="zh_CN";
    private String goodsNum="";
    private String carriageAmt="";
    private String merHint="";
    private String remark1="";
    private String remark2="";
    private String merURL;
    private String merVAR;
    private String notifyType="HS";
    private String resultType="1";
    private String limitPay="";
    private String backup1="";
    private String backup2="";
    private String backup3="";
    private String backup4="";
    private String isSupportDISCOUFlag="0";
    private String thirdPartyFlag="1";

}
