package com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
//XML9
public class DU_LIEU_GIAY_CHUNG_SINH {
    @Size(max = 100)
    public String MA_LK;
    @Size(max = 10)
    public String MA_BHXH_NND;
    @Size(max = 15)
    public String MA_THE_NND;
    @Size(max = 255)
    public String HO_TEN_NND;
    @Size(max = 8)
    public String NGAYSINH_NND;
    @Size(max = 2)
    public String MA_DANTOC_NND;
    @Size(max = 15)
    public String SO_CCCD_NND ;
    @Size(max = 8)
    public String NGAYCAP_CCCD_NND;
    @Size(max = 1024)
    public String NOICAP_CCCD_NND;
    @Size(max = 1024)
    public String NOI_CU_TRU_NND;
    @Size(max = 3)
    public String MA_QUOCTICH;
    @Size(max = 3)
    public String MATINH_CU_TRU;
    @Size(max = 3)
    public String MAHUYEN_CU_TRU;
    @Size(max = 5)
    public String MAXA_CU_TRU;
    @Size(max = 255)
    public String HO_TEN_CHA;
    @Size(max = 15)
    public String MA_THE_TAM;
    @Size(max = 255)
    public String HO_TEN_CON;
    @Max(value = 3)
    public int GIOI_TINH_CON;
    @Max(value = 99)
    public int SO_CON;
    @Max(value = 99)
    public int LAN_SINH ;
    @Max(value = 99)
    public int SO_CON_SONG;
    public int CAN_NANG_CON;
    @Size(max = 12)
    public String NGAY_SINH_CON;
    @Size(max = 1024)
    public String NOI_SINH_CON;
    public String TINH_TRANG_CON;
    @Max(value = 1)
    public int SINHCON_PHAUTHUAT;
    @Max(value = 1)
    public int SINHCON_DUOI32TUAN;
    public String GHI_CHU;
    @Size(max = 255)
    public String NGUOI_DO_DE;
    @Size(max = 255)
    public String NGUOI_GHI_PHIEU;
    @Size(max = 8)
    public String NGAY_CT;
    @Size(max = 200)
    public String SO;
    @Size(max = 200)
    public String QUYEN_SO;
    @Size(max = 10)
    public String MA_TTDV;
    public String DU_PHONG;

}
