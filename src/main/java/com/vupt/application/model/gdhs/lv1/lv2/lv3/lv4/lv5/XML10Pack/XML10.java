package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML10Pack;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CHI_TIEU_DU_LIEU_GIAY_NGHI_DUONG_THAI")
public class XML10 implements XMLDETAIL {
    @Size(max = 100)
    public String MA_LK;
    @Size(max = 200)
    public String SO_SERI;
    @Size(max = 200)
    public String SO_CT;
    @Max(value = 999)
    public int SO_NGAY;
    @Size(max = 1024)
    public String DON_VI;
    public String CHAN_DOAN_RV;
    @Size(max = 8)
    public String TU_NGAY;
    @Size(max = 8)
    public String DEN_NGAY;
    @Size(max = 10)
    public String MA_TTDV;
    @Size(max = 255)
    public String TEN_BS;
    @Size(max = 200)
    public String MA_BS;
    @Size(max = 8)
    public String NGAY_CT;
    public String DU_PHONG;

}
