package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class DSACH_CHI_TIET_THUOC {
    @XmlElement(name = "CHI_TIET_THUOC")
    public List<CHI_TIET_THUOC> ds_chi_tiet_thuoc;
    public DSACH_CHI_TIET_THUOC(){
        ds_chi_tiet_thuoc=new ArrayList<>();
    }
}
