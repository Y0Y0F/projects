package com.demo.commonutil.pojo;

import com.demo.commonutil.xmlOperation.XMLUtils;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * XmlAccessType.FIELD：映射这个类中的所有字段到XML
 * XmlAccessType.PROPERTY：映射这个类中的属性（get/set方法）到XML
 * XmlAccessType.PUBLIC_MEMBER：将这个类中的所有public的field或property同时映射到XML（默认）
 * XmlAccessType.NONE：不映射
 */

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="B2CReq") //XML文件中的根标识
@XmlType // 控制JAXB 绑定类中属性和字段的排序
public class ICBCPojo {

    private String interfaceName;
    private String interfaceVersion;
    private OrderInfo orderInfo;
    private Custom custom;
    private Message message;
    public static void main(String[] args) {

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderDate("2020-04-07 17:26:22");
        orderInfo.setOrderid("1231sffdwqq");
        orderInfo.setAmount("100.00");
        orderInfo.setMerID("123232131");
        orderInfo.setMerAcct("321313131");
        orderInfo.setExpireTime("3221321313");
        orderInfo.setShopAppID("12321313");


        Message message = new Message();
        message.setMerURL("www.baidu.com");
        message.setMerVAR("12312");

        ICBCPojo icbcPojo = new ICBCPojo();
        icbcPojo.setInterfaceName("HAHA");
        icbcPojo.setInterfaceVersion("1");
        icbcPojo.setCustom(new Custom());
        icbcPojo.setMessage(message);
        icbcPojo.setOrderInfo(orderInfo);
        String str = XMLUtils.convertToXml(icbcPojo);
        String replace = str.replace("standalone=\"yes\"", "standalone=\"no\"");
        // 输出
        System.out.println(replace);
        System.out.println("---将对象转换成string类型的xml End---");


        ICBCPojo icbc=(ICBCPojo)XMLUtils.convertXmlStrToObject(ICBCPojo.class, replace);
        System.out.println(icbc.toString());


    }

}
