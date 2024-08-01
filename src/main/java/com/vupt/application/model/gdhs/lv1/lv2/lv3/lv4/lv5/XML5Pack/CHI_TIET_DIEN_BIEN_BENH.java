package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
//XML5
public class CHI_TIET_DIEN_BIEN_BENH {
    @Size(max = 100)
    public String MA_LK;
    @Max(value = Integer.MAX_VALUE)
    public int STT;
    public String DIEN_BIEN_LS;
    public String GIAI_DOAN_BENH;
    public String HOI_CHAN;
    public String PHAU_THUAT;
    @Size(max = 12)
    public String THOI_DIEM_DBLS;
    @Size(max = 255)
    public String NGUOI_THUC_HIEN;
    public String DU_PHONG;
}
