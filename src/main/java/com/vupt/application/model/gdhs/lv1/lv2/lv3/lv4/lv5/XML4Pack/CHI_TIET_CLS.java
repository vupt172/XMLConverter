package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
//XML4
public class CHI_TIET_CLS {
    @Size(max = 100)
    public String MA_LK;
    @Max(value = Integer.MAX_VALUE)
    public int STT;
    @Size(max = 15)
    public String MA_DICH_VU;
    @Size(max = 50)
    public String MA_CHI_SO;
    @Size(max = 255)
    public String TEN_CHI_SO;
    @Size(max = 50)
    public String GIA_TRI;
    @Size(max = 50)
    public String DON_VI_DO;
    public String MO_TA;
    public String KET_LUAN;
    @Size(max = 12)
    public String NGAY_KQ;
    @Size(max = 255)
    public String MA_BS_DOC_KQ;
    public String DU_PHONG;

    public void doFormat() {
       this.TEN_CHI_SO= this.TEN_CHI_SO.trim();
    }
}
