package com.vupt.application.builder;

import com.vupt.application.model.gdhs.GIAMDINHHS;
import com.vupt.application.model.gdhs.lv1.THONGTINDONVI;
import com.vupt.application.model.gdhs.lv1.THONGTINHOSO;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.HOSO;

/*
 * Class GDHSBuilder tạo một đối tượng GIAMDINHHS bằng cách truyền vào các thông tin cần thiết,
 * thường sử dụng khi xuất từ excel sang file xml
 * */
public class GDHSBuilder {
    private GIAMDINHHS giamdinhhs;

    public GDHSBuilder() {
        giamdinhhs = new GIAMDINHHS();
        giamdinhhs.thongtinhoso = new THONGTINHOSO();
        giamdinhhs.thongtindonvi = new THONGTINDONVI();

    }

    public static GDHSBuilder getInstance() {
        return new GDHSBuilder();
    }

    public GDHSBuilder setMACSKCB(String MACSKCB) {
        giamdinhhs.thongtindonvi.MACSKCB = MACSKCB;
        return this;
    }

    public GDHSBuilder setNGAYLAP(String NGAYLAP) {
        giamdinhhs.thongtinhoso.NGAYLAP = NGAYLAP;
        return this;
    }

    public GDHSBuilder setSOLUONGHOSO(int SOLUONGHOSO) {
        giamdinhhs.thongtinhoso.SOLUONGHOSO = SOLUONGHOSO;
        return this;
    }

    public GDHSBuilder addHOSO(HOSO hoso) {
        giamdinhhs.thongtinhoso.danhsachhoso.dshoso.add(hoso);
        return this;
    }

    public GIAMDINHHS getResult() {
        return giamdinhhs;
    }


}
