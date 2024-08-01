package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4;

import com.vupt.application.constant.XMLType;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;
import com.vupt.application.xml.XMLConverter;
import com.vupt.application.xml.XMLStringEncoder;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.xml.bind.annotation.XmlTransient;



public class FILEHOSO {
    public XMLType LOAIHOSO;
    public String NOIDUNGFILE;
    @XmlTransient
    @Ignore
    public String decodedXML;
    @XmlTransient
    @Ignore
    public XMLDETAIL xmlDetail;

    public FILEHOSO(){}
    public FILEHOSO(XMLType type,XMLDETAIL XMLDetail){
        this.LOAIHOSO=type;
        this.xmlDetail=XMLDetail;
    }
    public void decodeXML() {
        decodedXML = XMLStringEncoder.decodeXML(NOIDUNGFILE);
        decodedXML = decodedXML.substring(decodedXML.indexOf("<?xml"));
        /*CompletableFuture.runAsync(()->System.out.println(loaiHoSo.getType()));*/
   /*    if(loaiHoSo==XmlDetailType.XML10){
           System.out.println(decodedXML);
           System.out.println("==================");
       }*/
    }
    public void encodeXML(){
        NOIDUNGFILE=XMLStringEncoder.encodeXML(this.decodedXML);
    }
    public void buildDecodedXMLFromXMLDetail(){
       this.decodedXML= XMLConverter.convertObjectToXML(LOAIHOSO,xmlDetail);
    }

    public void buildXMLDetail() {
            xmlDetail = XMLConverter.convertXMLToObject(LOAIHOSO, decodedXML);
    }
}
