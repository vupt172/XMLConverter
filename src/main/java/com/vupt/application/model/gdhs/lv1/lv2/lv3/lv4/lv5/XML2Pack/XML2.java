package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack;

import com.vupt.application.model.gdhs.lv1.lv2.DANHSACHHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "CHITIEU_CHITIET_THUOC")
public class XML2 implements XMLDETAIL {
    @XmlElement(name = "DSACH_CHI_TIET_THUOC")
   public DSACH_CHI_TIET_THUOC dsach_chi_tiet_thuoc;
    public XML2(){
        dsach_chi_tiet_thuoc=new DSACH_CHI_TIET_THUOC();
    }
}
