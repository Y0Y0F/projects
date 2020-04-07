package com.demo.commonutil.pojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "custom")
@XmlAccessorType(XmlAccessType.FIELD)
public class Custom {
    private String verifyJoinFlag="0";
    private String Language="zh_CN";
}
