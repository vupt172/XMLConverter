package com.vupt.application.model.gdhs.lv1.lv2;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class DANHSACHHOSO {
    @XmlElement(name = "HOSO")
    public List<HOSO> dshoso;
    public DANHSACHHOSO(){
        dshoso=new ArrayList();
    }
}
