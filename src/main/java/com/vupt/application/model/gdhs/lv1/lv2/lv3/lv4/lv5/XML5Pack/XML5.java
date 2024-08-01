package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CHITIEU_CHITIET_DIENBIENLAMSANG")
public class XML5 implements XMLDETAIL {
    @XmlElement(name = "DSACH_CHI_TIET_DIEN_BIEN_BENH")
   public DSACH_CHI_TIET_DIEN_BIEN_BENH dsach_chi_tiet_dien_bien_benh;
    public XML5(){
        dsach_chi_tiet_dien_bien_benh=new DSACH_CHI_TIET_DIEN_BIEN_BENH();
    }
}
