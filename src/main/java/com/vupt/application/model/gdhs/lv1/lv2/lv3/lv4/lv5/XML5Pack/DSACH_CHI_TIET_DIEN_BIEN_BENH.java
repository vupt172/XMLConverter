package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class DSACH_CHI_TIET_DIEN_BIEN_BENH {
    @XmlElement(name ="CHI_TIET_DIEN_BIEN_BENH")
    public List<CHI_TIET_DIEN_BIEN_BENH>  ds_chi_tiet_dien_bien_benh;
    public DSACH_CHI_TIET_DIEN_BIEN_BENH(){
        ds_chi_tiet_dien_bien_benh=new ArrayList<>();
    }
}
