package com.vupt.application.xml;

import com.vupt.application.builder.OldGDHSBuilder;
import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.utils.DateTimeUtils;
import com.vupt.application.utils.FileUtils;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;


/*
 * Class GHDSConverter dùng để chuyển đổi dữ liệu xml thành đối tượng trong java và ngược lại
 * */
public class GDHSConverter {
    // Method convertXLMToGDHS chuyển đổi dữ liệu một file xml thành đối tượng GIAMDINHHS trong java
    public static GIAMDINHHS convertXMLToGDHS(String xmlFilePath) throws JAXBException, FileNotFoundException {
        String xmlString = FileUtils.readFileToString(xmlFilePath);
        xmlString = xmlString.substring(xmlString.indexOf("<?xml"));
        JAXBContext jaxbContext = JAXBContext.newInstance(GIAMDINHHS.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        GIAMDINHHS gdhs = (GIAMDINHHS) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
        return gdhs;
    }

    // Method convertGDHSToXML chuyển đổi dữ liệu từ đối tượng GIAMDINHHS ra file xml
    public static String convertGDHSToXML(GIAMDINHHS giamdinhhs) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(GIAMDINHHS.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String filePath = String.format("output/%s.xml", DateTimeUtils.includeTimeToString("GIAMDINHHS"));
        File outputFile = new File(filePath);
        jaxbMarshaller.marshal(giamdinhhs, outputFile);
        return outputFile.getAbsolutePath();

    }


    // Old method
/*    public static GIAMDINHHS convertGDHSXmlToObject(String filePath) {
        try {
            //build Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(filePath);
            doc.getDocumentElement().normalize();
            // build GDHS Object
            Element rootElement = doc.getDocumentElement();
            GIAMDINHHS giamDinhHS = OldGDHSBuilder.getInstance(rootElement)
                    .buildGIAMDINHHS()
                    .buildTHONGTINDONVI()
                    .buildTHONGTINHOSO()
                    .buildDANHSACHHOSO()
                    .result();
            giamDinhHS.showInformationConsole();
            return giamDinhHS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
