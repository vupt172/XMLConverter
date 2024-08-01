package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CHI_TIEU_DU_LIEU_GIAY_CHUNG_SINH")
public class XML9 implements XMLDETAIL {
    @XmlElement(name = "DSACH_GIAYCHUNGSINH")
   public DSACH_GIAYCHUNGSINH dsach_giaychungsinh;
    public XML9(){
        dsach_giaychungsinh=new DSACH_GIAYCHUNGSINH();
    }
}
