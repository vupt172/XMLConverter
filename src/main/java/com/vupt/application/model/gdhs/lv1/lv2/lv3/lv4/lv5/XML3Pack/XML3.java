package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CHITIEU_CHITIET_DVKT_VTYT")
public class XML3 implements XMLDETAIL {
    @XmlElement(name = "DSACH_CHI_TIET_DVKT")
    public DSACH_CHI_TIET_DVKT dsach_chi_tiet_dvkt;
    public XML3(){
        dsach_chi_tiet_dvkt=new DSACH_CHI_TIET_DVKT();
    }
}
