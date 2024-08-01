package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML8Pack;

import com.vupt.application.model.common.IntegerAdapter;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XMLDETAIL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "CHI_TIEU_DU_LIEU_TOM_TAT_HO_SO_BENH_AN")
public class XML8 implements XMLDETAIL {
    @Size(max = 100)
    public String MA_LK;
    @Size(max = 2)
    public String MA_LOAI_KCB;
    @Size(max = 255)
    public String HO_TEN_CHA;
    @Size(max = 255)
    public String HO_TEN_ME;
    @Size(max = 255)
    public String NGUOI_GIAM_HO;
    @Size(max = 1024)
    public String DON_VI;
    @Size(max = 12)
    public String NGAY_VAO;
    @Size(max = 12)
    public String NGAY_RA;
    public String CHAN_DOAN_VAO;
    public String CHAN_DOAN_RV;
    public String QT_BENHLY;
    public String TOMTAT_KQ;
    public String PP_DIEUTRI;
    @Size(max = 8)
    public String NGAY_SINHCON;
    @Size(max = 8)
    public String NGAY_CONCHET;

    @Max(value = 99)
    @XmlElement(nillable = true)
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    public Integer SO_CONCHET;

    @Max(value = 8)
    public int KET_QUA_DTRI;
    public String GHI_CHU;
    @Size(max = 10)
    public String MA_TTDV;
    @Size(max = 8)
    public String NGAY_CT;
    @Size(max = 15)
    public String MA_THE_TAM;
    public String DU_PHONG;

}
