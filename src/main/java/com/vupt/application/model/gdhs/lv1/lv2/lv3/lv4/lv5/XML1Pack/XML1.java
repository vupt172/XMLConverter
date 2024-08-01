package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack;

import com.vupt.application.model.common.DoubleAdapter;
import com.vupt.application.model.common.IntegerAdapter;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;
import lombok.Data;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement(name = "TONG_HOP")
@XmlAccessorType(XmlAccessType.FIELD)
public class XML1 implements XMLDETAIL {
    @Size(max = 100)
    public String MA_LK;
    @Max(value=Integer.MAX_VALUE)
    public int STT;
    @Size(max = 100)
    public String MA_BN;
    @Size(max = 255)
    public String HO_TEN;
    @Size(max = 15)
    public String SO_CCCD;
    @Size(max = 12)
    public String NGAY_SINH;
    @Max(value = 3)
    public int GIOI_TINH;
    @Size(max = 5)
    public String NHOM_MAU;
    @Size(max = 3)
    public String MA_QUOCTICH;
    @Size(max = 2)
    public String MA_DANTOC;
    @Size( max = 5)
    public String MA_NGHE_NGHIEP;
    @Size(max = 1024)
    public String DIA_CHI;
    @Size(max = 3)
    public String MATINH_CU_TRU;
    @Size(max = 3)
    public String MAHUYEN_CU_TRU;
    @Size(max = 5)
    public String MAXA_CU_TRU;
    @Size(max = 15)
    public String DIEN_THOAI;
    public String MA_THE_BHYT;
    public String MA_DKBD;
    public String GT_THE_TU;
    public String GT_THE_DEN;
    @Size(max = 12)
    public String NGAY_MIEN_CCT;
    public String LY_DO_VV;
    public String LY_DO_VNT;
    @Size(max = 5)
    public String MA_LY_DO_VNT;
    public String CHAN_DOAN_VAO;
    public String CHAN_DOAN_RV;
    @Size(max = 7)
    public String MA_BENH_CHINH;
    @Size(max = 100)
    public String MA_BENH_KT;
    @Size(max = 255)
    public String MA_BENH_YHCT;
    @Size(max = 125)
    public String MA_PTTT_QT;
    @Size(max = 4)
    public String MA_DOITUONG_KCB;
    @Size(max = 5)
    public String MA_NOI_DI;
    @Size(max = 5)
    public String MA_NOI_DEN;
    @Max(value = 9)
    public int MA_TAI_NAN;
    @Size(max = 12)
    public String NGAY_VAO;
    @Size(max = 12)
    public String NGAY_VAO_NOI_TRU;
    @Size(max = 12)
    public String NGAY_RA;
    @Size(max = 50)
    public String GIAY_CHUYEN_TUYEN;
    @Max(value = 999)
    public int SO_NGAY_DTRI;
    public String PP_DIEU_TRI;
    @Max(value = 7)
    public int KET_QUA_DTRI;
    @Max(value = 5)
    public int MA_LOAI_RV;

    public String GHI_CHU;
    @Size(max = 12)
    public String NGAY_TTOAN;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_THUOC;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_VTYT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_TONGCHI_BV;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_TONGCHI_BH;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BNTT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BNCCT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BHTT;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_NGUONKHAC;
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double T_BHTT_GDV;
    @Max(value = 9999)
    public int NAM_QT;
    @Max(value = 12)
    public int THANG_QT;
    @Size(max = 2)
    public String MA_LOAI_KCB;
    @Size(max = 50)
    public String MA_KHOA;
    @Size(max = 5)
    public String MA_CSKCB;
    @Size(max = 2)
    public String MA_KHUVUC;
    public double CAN_NANG;
    @Size(max=100)
    public String CAN_NANG_CON;
    @Size(max=8)
    public String NAM_NAM_LIEN_TUC;
    @Size(max=50)
    public String NGAY_TAI_KHAM;
    @Size(max = 100)
    public String MA_HSBA;
    @Size(max = 10)
    public String MA_TTDV;
    public String DU_PHONG;
}
