package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML7Pack;

import com.vupt.application.model.common.IntegerAdapter;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "CHI_TIEU_DU_LIEU_GIAY_RA_VIEN")
public class XML7 implements XMLDETAIL {
    @Size(max = 100)
    public String MA_LK;
    @Size(max = 200)
    public String SO_LUU_TRU;
    @Size(max = 200)
    public String MA_YTE;
    @Size(max = 200)
    public String MA_KHOA_RV;
    @Size(max = 12)
    public String NGAY_VAO;
    @Size(max = 12)
    public String NGAY_RA;
    @Max(value = 1)
    public int MA_DINH_CHI_THAI;
    public String NGUYENNHAN_DINHCHI;
    @Size(max = 12)
    public String THOIGIAN_DINHCHI;
    @Max(value = 42)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer TUOI_THAI;
    @Size(max = 1500)
    public String CHAN_DOAN_RV;
    @Size(max = 1500)
    public String PP_DIEUTRI;
    @Size(max = 1500)
    public String GHI_CHU;
    @Size(max = 10)
    public String MA_TTDV;
    @Size(max = 200)
    public String MA_BS;
    @Size(max = 255)
    public String TEN_BS;
    @Size(max = 8)
    public String NGAY_CT;
    @Size(max = 10)
    public String MA_CHA;
    @Size(max = 10)
    public String MA_ME;
    @Size(max = 15)
    public String MA_THE_TAM;
    @Size(max = 255)
    public String HO_TEN_CHA;
    @Size(max = 255)
    public String HO_TEN_ME;

    @Max(value = 99)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer SO_NGAY_NGHI;
    @Size(max = 8)
    public String NGOAITRU_TUNGAY;
    @Size(max = 8)
    public String NGOAITRU_DENNGAY;
    public String DU_PHONG;




}
