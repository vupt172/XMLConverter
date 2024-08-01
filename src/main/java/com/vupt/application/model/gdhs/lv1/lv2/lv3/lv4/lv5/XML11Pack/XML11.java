package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML11Pack;

import com.vupt.application.model.common.IntegerAdapter;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "CHI_TIEU_DU_LIEU_GIAY_CHUNG_NHAN_NGHI_VIEC_HUONG_BAO_HIEM_XA_HOI")
public class XML11 implements XMLDETAIL {
    @Size(max = 100)
    public String MA_LK;
    @Size(max = 200)
    public String SO_CT;
    @Size(max = 200)
    public String SO_SERI;
    @Size(max = 200)
    public String SO_KCB;
    @Size(max = 1024)
    public String DON_VI;
    @Size(max = 10)
    public String MA_BHXH;
    public String MA_THE_BHYT;
    public String CHAN_DOAN_RV;
    public String PP_DIEUTRI;
    @Max(value = 1)
    public int MA_DINH_CHI_THAI;
    public String NGUYENNHAN_DINHCHI;
    @Max(value = 42)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer TUOI_THAI;
    @Max(value = 999)
    public int SO_NGAY_NGHI;
    @Size(max = 8)
    public String TU_NGAY;
    @Size(max = 8)
    public String DEN_NGAY;
    @Size(max = 255)
    public String HO_TEN_CHA;
    @Size(max = 255)
    public String HO_TEN_ME;
    @Size(max = 10)
    public String MA_TTDV;
    @Size(max = 200)
    public String MA_BS;
    @Size(max = 8)
    public String NGAY_CT;
    @Size(max = 15)
    public String MA_THE_TAM;
    @Size(max = 5)
    public String MAU_SO;
    public String DU_PHONG;
}
