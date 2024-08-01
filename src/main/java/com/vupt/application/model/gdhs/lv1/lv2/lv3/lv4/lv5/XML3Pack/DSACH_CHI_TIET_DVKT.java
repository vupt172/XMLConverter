package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class DSACH_CHI_TIET_DVKT {
    @XmlElement(name = "CHI_TIET_DVKT")
    public List<CHI_TIET_DVKT> ds_chi_tiet_dvkt;
    public DSACH_CHI_TIET_DVKT(){
        ds_chi_tiet_dvkt=new ArrayList<>();
    }
}
