package com.vupt.application.xml;

import net.sf.jasperreports.util.Base64Util;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 * Class XMLStringEnder dùng để chuyển đổi giữa mã hóa và giải nén xml
 * */
public class XMLStringEncoder {

    //    Method decodeXML dùng giải nén một chuỗi đặc biệt thành chuỗi xml
    public static String decodeXML(String encodedXMLString) {
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(encodedXMLString);
        String decodedXMLString = new String(decodedBytes, StandardCharsets.UTF_8);
        return decodedXMLString;
    }


    //     Method encodeXML dùng mã hóa một chuỗi xml thành chuỗi nén đặc biệt
    public static String encodeXML(String decodedXMLString) {
        //add BOM
        decodedXMLString = "\ufeff" + decodedXMLString;
        try {
            // Mã hóa chuỗi XML thành byte array
            byte[] xmlBytes = decodedXMLString.getBytes("UTF-8");
            String encodedString = Base64.getEncoder().encodeToString(xmlBytes);
            return encodedString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
