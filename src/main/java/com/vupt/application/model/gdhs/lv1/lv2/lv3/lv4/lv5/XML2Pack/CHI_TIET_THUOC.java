package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack;

import com.vupt.application.model.common.DoubleAdapter;
import com.vupt.application.model.common.IntegerAdapter;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//XML2
public class CHI_TIET_THUOC {
    @Size(max = 100)
    public String MA_LK;
    @Max(value = Integer.MAX_VALUE)
    public int STT;
    @Size(max = 255)
    public String MA_THUOC;
    @Size(max = 255)
    public String MA_PP_CHEBIEN;
    @Size(max = 10)
    public String MA_CSKCB_THUOC;
    @Max(value = 99)
    public int MA_NHOM;
    @Size(max = 1024)
    public String TEN_THUOC;
    @Size(max = 50)
    public String DON_VI_TINH;
    @Size(max = 1024)
    public String HAM_LUONG;
    @Size(max = 4)
    public String DUONG_DUNG;
    @Size(max = 1024)
    public String DANG_BAO_CHE;
    @Size(max = 1024)
    public String LIEU_DUNG;
    @Size(max = 1024)
    public String CACH_DUNG;
    @Size(max = 255)
    public String SO_DANG_KY;
    @Size(max = 50)
    public String TT_THAU;
    @Max(value = 3)
    public int PHAM_VI;
    @Max(value = 100)
    public int TYLE_TT_BH;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double SO_LUONG;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double DON_GIA;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double THANH_TIEN_BV;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double THANH_TIEN_BH;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_NGUONKHAC_NSNN;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_NGUONKHAC_VTNN;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_NGUONKHAC_VTTN;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_NGUONKHAC_CL;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_NGUONKHAC;
    @Max(100)
    public int MUC_HUONG;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BNTT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BNCCT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BHTT;
    @Size(max = 50)
    public String MA_KHOA;
    @Size(max = 255)
    public String MA_BAC_SI;
    @Size(max = 255)
    public String MA_DICH_VU;
    @Size(max = 12)
    public String NGAY_YL;
    @Size(max = 12)
    public String NGAY_TH_YL;
    @Max(3)
    public int MA_PTTT;
    @Max(4)
    public int NGUON_CTRA;
    @Max(1)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer VET_THUONG_TP;
    public String DU_PHONG;


}
