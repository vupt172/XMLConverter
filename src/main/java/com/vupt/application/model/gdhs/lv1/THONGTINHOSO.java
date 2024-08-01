package com.vupt.application.model.gdhs.lv1;

import com.vupt.application.model.gdhs.lv1.lv2.DANHSACHHOSO;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;


public class THONGTINHOSO {
    public String NGAYLAP;
    public int SOLUONGHOSO;
    @XmlElement(name = "DANHSACHHOSO")
    public DANHSACHHOSO danhsachhoso;
    public THONGTINHOSO(){
        danhsachhoso=new DANHSACHHOSO();
    }

}
