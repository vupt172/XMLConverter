package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class DSACH_GIAYCHUNGSINH {
    @XmlElement(name="DU_LIEU_GIAY_CHUNG_SINH")
   public List<DU_LIEU_GIAY_CHUNG_SINH> ds_du_lieu_giay_chung_sinh;
    public DSACH_GIAYCHUNGSINH(){
        ds_du_lieu_giay_chung_sinh=new ArrayList<>();
    }
}
