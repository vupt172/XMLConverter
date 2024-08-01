package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack;

import com.vupt.application.model.common.DoubleAdapter;
import com.vupt.application.model.common.IntegerAdapter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
// XML3
public class CHI_TIET_DVKT {
    @Size(max = 100)
    public String MA_LK;
    @Max(value = Integer.MAX_VALUE)
    public int STT;
    @Size(max = 50)
    public String MA_DICH_VU;
    @Size(max = 255)
    public String MA_PTTT_QT;
    @Size(max = 255)
    public String MA_VAT_TU;
    @Max(value = 99)
    public int MA_NHOM;
    @Size(max = 3)
    public String GOI_VTYT;
    @Size(max = 1024)
    public String TEN_VAT_TU;
    @Size(max = 1024)
    public String TEN_DICH_VU;
    @Size(max = 20)
    public String MA_XANG_DAU;
    @Size(max = 50)
    public String DON_VI_TINH;
    @Max(3)
    public int PHAM_VI;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double SO_LUONG;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double DON_GIA_BV;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double DON_GIA_BH;
    @Size(max = 25)
    public String TT_THAU;
    @Max(value = 100)
    public int TYLE_TT_DV;
    @Max(value = 100)
    public int TYLE_TT_BH;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double THANH_TIEN_BV;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double THANH_TIEN_BH;
    @Size(max = 15)
    public String T_TRANTT;
    @Max(value = 100)
    public int MUC_HUONG;
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
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BNTT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BNCCT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BHTT;
    @Size(max = 50)
    public String MA_KHOA;
    @Size(max = 50)
    public String MA_GIUONG;
    @Size(max = 255)
    public String MA_BAC_SI;
    @Size(max = 255)
    public String NGUOI_THUC_HIEN;
    @Size(max = 100)
    public String MA_BENH;
    @Size(max = 255)
    public String MA_BENH_YHCT;
    @Size(max = 12)
    public String NGAY_YL;
    @Size(max = 12)
    public String NGAY_TH_YL;
    @Size(max = 12)
    public String NGAY_KQ;
    @Max(3)
    public int MA_PTTT;
    @Max(1)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer VET_THUONG_TP;
    @Max(4)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer PP_VO_CAM;
    @Max(value = 999)
    public int VI_TRI_TH_DVKT;
    @Size(max = 1024)
    public String MA_MAY;
    @Size(max = 255)
    public String MA_HIEU_SP;
    @Max(value = 1)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer TAI_SU_DUNG;

    public String DU_PHONG;

}

