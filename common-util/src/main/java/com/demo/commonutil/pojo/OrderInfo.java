package com.demo.commonutil.pojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "orderInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderInfo {
        private String orderDate;
        private String orderid;
        private String amount;
        private String installmentTimes="1";
        private String curType="001";
        private String merID;
        private String merAcct;
        private String expireTime;
        private String unipassID="";
        private String shopAppID;
        private String icbcappid="";



}
