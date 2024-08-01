package com.vupt.application.xml;

import com.vupt.application.constant.XMLType;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML10Pack.XML10;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML11Pack.XML11;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.XML2;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.XML3;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.XML4;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.XML5;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML7Pack.XML7;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML8Pack.XML8;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.XML9;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/*
 * Class XMLConverter chuyển đổi các chuỗi XML thành kiểu XMLDETAIL(Các bảng kê trong giám định) và ngược lại
 * */
public class XMLConverter {
    // Phương thức convertXMLToObject chuyển đổi chuỗi XML và kiểu bảng kê cho trước thành XMLDETAIL (Các bảng kê trong giám định)
    public static XMLDETAIL convertXMLToObject(XMLType type, String xmlStr) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = getJAXBContextInstance(type);
            if (jaxbContext == null) return null;
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XMLDETAIL xmldetail = getXMLInstance(jaxbUnmarshaller, type, xmlStr);
            return xmldetail;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
   // Phương thức convertObjectToXML chuyển đổi XMLDETAIL và kiểu bảng kê cho trước thành chuỗi XML
    public static String convertObjectToXML(XMLType type, XMLDETAIL xmldetail) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = getJAXBContextInstance(type);
            if (jaxbContext == null) return null;

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            jaxbMarshaller.marshal(xmldetail, stringWriter);
            String decodedXMLString = stringWriter.toString();
            decodedXMLString = decodedXMLString.replaceAll(" xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
            return decodedXMLString;
        } catch (JAXBException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static JAXBContext getJAXBContextInstance(XMLType type) throws JAXBException {
        JAXBContext jaxbContext;
        switch (type) {
            case XML1:
                jaxbContext = JAXBContext.newInstance(XML1.class);
                break;
            case XML2:
                jaxbContext = JAXBContext.newInstance(XML2.class);
                break;
            case XML3:
                jaxbContext = JAXBContext.newInstance(XML3.class);
                break;
            case XML4:
                jaxbContext = JAXBContext.newInstance(XML4.class);
                break;
            case XML5:
                jaxbContext = JAXBContext.newInstance(XML5.class);
                break;
            case XML7:
                jaxbContext = JAXBContext.newInstance((XML7.class));
                break;
            case XML8:
                jaxbContext = JAXBContext.newInstance((XML8.class));
                break;
            case XML9:
                jaxbContext = JAXBContext.newInstance(XML9.class);
                break;
            case XML10:
                jaxbContext = JAXBContext.newInstance(XML10.class);
            case XML11:
                jaxbContext = JAXBContext.newInstance(XML11.class);
                break;
            default:
                jaxbContext = null;
        }
        return jaxbContext;
    }

    private static XMLDETAIL getXMLInstance(Unmarshaller jaxbUnmarshaller, XMLType type, String xmlStr) throws JAXBException {
        XMLDETAIL xmlObj;
        switch (type) {
            case XML1:
                XML1 xml1 = (XML1) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml1;
            case XML2:
                XML2 xml2 = (XML2) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml2;
            case XML3:
                XML3 xml3 = (XML3) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml3;
            case XML4:
                XML4 xml4 = (XML4) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                xml4.doWork();
                return xml4;
            case XML5:
                XML5 xml5 = (XML5) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml5;
            case XML7:
                XML7 xml7 = (XML7) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml7;
            case XML8:
                XML8 xml8 = (XML8) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml8;
            case XML9:
                XML9 xml9 = (XML9) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml9;
            case XML10:
                XML10 xml10 = (XML10) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml10;
            case XML11:
                XML11 xml11 = (XML11) jaxbUnmarshaller.unmarshal(new StringReader(xmlStr));
                return xml11;
            default:
                return null;
        }
    }
}
