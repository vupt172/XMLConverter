package com.vupt.application.model.gdhs.lv1.lv2.lv3;

import com.vupt.application.constant.XMLType;
import com.vupt.application.mapper.MapstructMapper;

import com.vupt.application.mapper.MapstructMapperImpl;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.FILEHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.HoSoInfo;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.xml.XMLConverter;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Component
public class HOSO {
    /*@Autowired
    MapstructMapper mapstructMapper;*/
    @XmlElement(name = "FILEHOSO")
    public List<FILEHOSO> dsfilehoso;
    @Ignore
    public HoSoInfo hosoInfo;

    public HOSO() {
    }

    public HOSO(List<FILEHOSO> dsfilehoso) {
        this.dsfilehoso = dsfilehoso;
    }

    public void buildHoSoInfo() {
        FILEHOSO fhs = findXMLFile(XMLType.XML1);
        fhs.decodeXML();
        XML1 xml1 = (XML1) XMLConverter.convertXMLToObject(fhs.LOAIHOSO, fhs.decodedXML);
        MapstructMapper mapstructMapper = new MapstructMapperImpl();
        this.hosoInfo = mapstructMapper.XML1ToHoSoInfo(xml1);
//        CompletableFuture.runAsync(() -> System.out.println(hosoInfo.STT+"  :"+hosoInfo.MA_BN + " " + hosoInfo.HO_TEN));
    }



    public void encodeXMLs() {
        dsfilehoso.stream().forEach(fhs -> {
            fhs.encodeXML();
        });
    }

    public void decodeXMLs() {
        dsfilehoso.stream().forEach(fhs -> {
            fhs.decodeXML();
        });
    }

    public void buildDecodedXMLFromXMLDetails() {
        dsfilehoso.stream().forEach(fhs -> fhs.buildDecodedXMLFromXMLDetail());
    }

    public void buildXMLDetails() {
        dsfilehoso.stream().forEach(fhs -> {
            fhs.buildXMLDetail();
        });
    }

    public FILEHOSO findXMLFile(XMLType type) {
        FILEHOSO fhs = dsfilehoso.stream().filter(f -> f.LOAIHOSO == type).findFirst().orElse(null);
        return fhs;
    }

    public boolean containXMLFileWithType(XMLType type) {
        return dsfilehoso.stream().anyMatch(fhs -> fhs.LOAIHOSO == type);
    }

}
