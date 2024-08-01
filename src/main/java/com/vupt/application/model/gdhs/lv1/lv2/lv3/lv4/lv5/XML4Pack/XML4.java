package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CHITIEU_CHITIET_DICHVUCANLAMSANG")
public class XML4 implements XMLDETAIL {
    @XmlElement(name = "DSACH_CHI_TIET_CLS")
    public DSACH_CHI_TIET_CLS dsach_chi_tiet_cls;

    public XML4(){
        dsach_chi_tiet_cls=new DSACH_CHI_TIET_CLS();
    }
    public void doWork(){
        dsach_chi_tiet_cls.ds_chi_tiet_cls.stream().forEach(chi_tiet_cls -> chi_tiet_cls.doFormat());
    }
}
