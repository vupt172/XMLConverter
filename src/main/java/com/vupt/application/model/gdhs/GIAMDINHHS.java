package com.vupt.application.model.gdhs;

import com.vupt.application.constant.DatetimePattern;
import com.vupt.application.model.gdhs.lv1.THONGTINDONVI;
import com.vupt.application.model.gdhs.lv1.THONGTINHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.concurrent.CompletableFuture;

@XmlRootElement(name = "GIAMDINHHS")
public class GIAMDINHHS {
    @XmlElement(name = "THONGTINDONVI")
    public THONGTINDONVI thongtindonvi;
    @XmlElement(name = "THONGTINHOSO")
    public THONGTINHOSO thongtinhoso;

    public GIAMDINHHS() {
        thongtindonvi = new THONGTINDONVI();
        thongtinhoso = new THONGTINHOSO();
    }

    public void showInformationConsole() {
//        CompletableFuture.runAsync(()->{
        System.out.println("--------------------------------------------------");
        System.out.println("THÔNG TIN GIÁM ĐỊNH HỒ SƠ XML");
        System.out.println("--------------------------------------------------");
//            System.out.println("- Thông tin đơn vị");
        System.out.println("+ Mã CSKCB: " + this.thongtindonvi.MACSKCB);
//            System.out.println("- Thông tin hồ sơ");
        System.out.println("+ Ngày lập: " + this.thongtinhoso.NGAYLAP);
        System.out.println("+ Số lượng hồ sơ: " + this.thongtinhoso.SOLUONGHOSO);
//        System.out.println("*----------------------------------------------------------------------------------------------------*");
//        });
    }

    public String getXMLAll(HOSO hoso) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
        xml.append("<GIAMDINHHS>\n");
        xml.append("  <THONGTINDONVI>\n");
        xml.append(String.format("    <MACSKCB>%s</MACSKCB>\n", thongtindonvi.MACSKCB));
        xml.append("  </THONGTINDONVI>\n");
        xml.append("  <THONGTINHOSO>\n");
        xml.append(String.format("    <NGAYLAP>%s</NGAYLAP>\n", thongtinhoso.NGAYLAP));
        xml.append(String.format("    <SOLUONGHOSO>%d</SOLUONGHOSO>\n", 1));
        xml.append("    <DANHSACHHOSO>\n");
        xml.append("      <HOSO>\n");
        hoso.dsfilehoso.forEach(fhs -> {
            xml.append("        <FILEHOSO>\n");
            xml.append(String.format("          <LOAIHOSO>%s</LOAIHOSO>\n", fhs.LOAIHOSO));
            xml.append(String.format("          <NOIDUNGFILE>%s</NOIDUNGFILE>\n", fhs.decodedXML));
            xml.append("        </FILEHOSO>\n");
        });
        xml.append("      </HOSO>\n");
        xml.append("    </DANHSACHHOSO>\n");
        xml.append("  </THONGTINHOSO>\n");
        xml.append("</GIAMDINHHS>\n");
        return xml.toString();
    }
}
