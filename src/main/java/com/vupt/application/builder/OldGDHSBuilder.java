package com.vupt.application.builder;

import com.vupt.application.constant.XMLType;
import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.model.gdhs.lv1.THONGTINDONVI;
import com.vupt.application.model.gdhs.lv1.THONGTINHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.DANHSACHHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.FILEHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class OldGDHSBuilder {
    private Element rootElement;
    private GIAMDINHHS giamDinhHS;
    public OldGDHSBuilder(Element rootElement) {
        this.rootElement = rootElement;
    }

    public static OldGDHSBuilder getInstance(Element rootElement) {
        return new OldGDHSBuilder(rootElement);
    }

    public OldGDHSBuilder buildGIAMDINHHS() {
        this.giamDinhHS = new GIAMDINHHS();
        return this;

    }

    public OldGDHSBuilder buildTHONGTINDONVI() {
        THONGTINDONVI thongTinDonVi = new THONGTINDONVI();
        NodeList ttdvNodeList = rootElement.getElementsByTagName("THONGTINDONVI");
        Element mcskcbElement = (Element) ttdvNodeList.item(0);
        thongTinDonVi.MACSKCB=mcskcbElement.getTextContent().trim();

        this.giamDinhHS.thongtindonvi=thongTinDonVi;
        return this;
    }

    public OldGDHSBuilder buildTHONGTINHOSO() {
        THONGTINHOSO thongTinHoSo = new THONGTINHOSO();
        Element tthsElement = (Element) rootElement.getElementsByTagName("THONGTINHOSO").item(0);

        String ngaylap = tthsElement.getElementsByTagName("NGAYLAP").item(0).getTextContent();
        thongTinHoSo.NGAYLAP=ngaylap;
        String soluonghoso = tthsElement.getElementsByTagName("SOLUONGHOSO").item(0).getTextContent();
        thongTinHoSo.SOLUONGHOSO=Integer.valueOf(soluonghoso);

        this.giamDinhHS.thongtinhoso=thongTinHoSo;


        return this;
    }

    public GIAMDINHHS result() {
        return this.giamDinhHS;
    }


    public OldGDHSBuilder buildDANHSACHHOSO() throws JAXBException {
        DANHSACHHOSO danhSachHoSo = new DANHSACHHOSO();
        List<HOSO> hsList=new ArrayList<>();
        Element dshsElement = (Element) rootElement.getElementsByTagName("DANHSACHHOSO").item(0);
        NodeList hsNodeList = dshsElement.getElementsByTagName("HOSO");


        for (int i = 0; i < hsNodeList.getLength(); i++) {
            Node hsNode = hsNodeList.item(i);
            if (hsNode.getNodeType() == Node.ELEMENT_NODE) {
                Element hsElement = (Element) hsNode;
                HOSO hoso = getHOSO(hsElement);
                hsList.add(hoso);
            }

        }
        danhSachHoSo.dshoso=hsList;

        this.giamDinhHS.thongtinhoso.danhsachhoso=danhSachHoSo;
        return this;
    }

    private HOSO getHOSO(Element hsElement) throws JAXBException {
        HOSO hoso = new HOSO();
        List<FILEHOSO> fhsList=new ArrayList<>();
        NodeList fhsNodeList = hsElement.getElementsByTagName("FILEHOSO");
        for (int i = 0; i < fhsNodeList.getLength(); i++) {
            FILEHOSO fhs = new FILEHOSO();
            Element fhsElement = (Element) fhsNodeList.item(i);
            String loaiHs=fhsElement.getElementsByTagName("LOAIHOSO").item(0).getTextContent().trim();
            fhs.LOAIHOSO=XMLType.valueOf(loaiHs);
            fhs.NOIDUNGFILE=fhsElement.getElementsByTagName("NOIDUNGFILE").item(0).getTextContent();
            fhs.decodeXML();
            fhsList.add(fhs);
        }

        hoso.dsfilehoso=fhsList;
        hoso.buildHoSoInfo();
        return hoso;
    }


}
