package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.CHI_TIET_DVKT;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class DSACH_CHI_TIET_CLS {
    @XmlElement(name = "CHI_TIET_CLS")
    public List<CHI_TIET_CLS> ds_chi_tiet_cls;
    public DSACH_CHI_TIET_CLS(){
        ds_chi_tiet_cls=new ArrayList<>();
    }
}
