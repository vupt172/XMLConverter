package com.vupt.application.excel.importer;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML8Pack.XML8;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.DU_LIEU_GIAY_CHUNG_SINH;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.XML9;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XML9ImportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_MA_BHXH_NND = 1;
    public static final int COLUMN_INDEX_MA_THE_NND = 2;
    public static final int COLUMN_INDEX_HO_TEN_NND = 3;
    public static final int COLUMN_INDEX_NGAYSINH_NND = 4;
    public static final int COLUMN_INDEX_MA_DANTOC_NND = 5;
    public static final int COLUMN_INDEX_SO_CCCD_NND = 6;
    public static final int COLUMN_INDEX_NGAYCAP_CCCD_NND = 7;
    public static final int COLUMN_INDEX_NOICAP_CCCD_NND = 8;
    public static final int COLUMN_INDEX_NOI_CU_TRU_NND = 9;
    public static final int COLUMN_INDEX_MA_QUOCTICH = 10;
    public static final int COLUMN_INDEX_MATINH_CU_TRU = 11;
    public static final int COLUMN_INDEX_MAHUYEN_CU_TRU = 12;
    public static final int COLUMN_INDEX_MAXA_CU_TRU = 13;
    public static final int COLUMN_INDEX_HO_TEN_CHA = 14;
    public static final int COLUMN_INDEX_MA_THE_TAM = 15;
    public static final int COLUMN_INDEX_HO_TEN_CON = 16;
    public static final int COLUMN_INDEX_GIOI_TINH_CON = 17;
    public static final int COLUMN_INDEX_SO_CON = 18;
    public static final int COLUMN_INDEX_LAN_SINH = 19;
    public static final int COLUMN_INDEX_SO_CON_SONG = 20;
    public static final int COLUMN_INDEX_CAN_NANG_CON = 21;
    public static final int COLUMN_INDEX_NGAY_SINH_CON = 22;
    public static final int COLUMN_INDEX_NOI_SINH_CON = 23;
    public static final int COLUMN_INDEX_TINH_TRANG_CON = 24;
    public static final int COLUMN_INDEX_SINHCON_PHAUTHUAT = 25;
    public static final int COLUMN_INDEX_SINHCON_DUOI32TUAN = 26;
    public static final int COLUMN_INDEX_GHI_CHU = 27;
    public static final int COLUMN_INDEX_NGUOI_DO_DE = 28;
    public static final int COLUMN_INDEX_NGUOI_GHI_PHIEU = 29;
    public static final int COLUMN_INDEX_NGAY_CT = 30;
    public static final int COLUMN_INDEX_SO = 31;
    public static final int COLUMN_INDEX_QUYEN_SO = 32;
    public static final int COLUMN_INDEX_MA_TTDV = 33;
    public static final int COLUMN_INDEX_DU_PHONG = 34;

    private Workbook workbook;
    private Sheet sheet;

    public XML9ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public XML9 readExcel() throws IOException {

        DataFormatter fmt = new DataFormatter();
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();

        XML9 xml9 = new XML9();
        List<DU_LIEU_GIAY_CHUNG_SINH>  ds_du_lieu_giay_chung_sinh=new ArrayList<>();
        while (iterator.hasNext()){
            Row currentRow=iterator.next();
            DU_LIEU_GIAY_CHUNG_SINH du_lieu_giay_chung_sinh=new DU_LIEU_GIAY_CHUNG_SINH();

            du_lieu_giay_chung_sinh.MA_LK=currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();
            du_lieu_giay_chung_sinh.MA_BHXH_NND=currentRow.getCell(COLUMN_INDEX_MA_BHXH_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.MA_THE_NND=currentRow.getCell(COLUMN_INDEX_MA_THE_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.HO_TEN_NND=currentRow.getCell(COLUMN_INDEX_HO_TEN_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.NGAYSINH_NND=currentRow.getCell(COLUMN_INDEX_NGAYSINH_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.MA_DANTOC_NND=currentRow.getCell(COLUMN_INDEX_MA_DANTOC_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.SO_CCCD_NND=currentRow.getCell(COLUMN_INDEX_SO_CCCD_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.NGAYCAP_CCCD_NND=currentRow.getCell(COLUMN_INDEX_NGAYCAP_CCCD_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.NOICAP_CCCD_NND=currentRow.getCell(COLUMN_INDEX_NOICAP_CCCD_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.NOI_CU_TRU_NND=currentRow.getCell(COLUMN_INDEX_NOI_CU_TRU_NND).getStringCellValue();
            du_lieu_giay_chung_sinh.MA_QUOCTICH=currentRow.getCell(COLUMN_INDEX_MA_QUOCTICH).getStringCellValue();
            du_lieu_giay_chung_sinh.MATINH_CU_TRU=currentRow.getCell(COLUMN_INDEX_MATINH_CU_TRU).getStringCellValue();
            du_lieu_giay_chung_sinh.MAHUYEN_CU_TRU=currentRow.getCell(COLUMN_INDEX_MAHUYEN_CU_TRU).getStringCellValue();
            du_lieu_giay_chung_sinh.MAXA_CU_TRU=currentRow.getCell(COLUMN_INDEX_MAXA_CU_TRU).getStringCellValue();
            du_lieu_giay_chung_sinh.HO_TEN_CHA=currentRow.getCell(COLUMN_INDEX_HO_TEN_CHA).getStringCellValue();
            du_lieu_giay_chung_sinh.MA_THE_TAM=currentRow.getCell(COLUMN_INDEX_MA_THE_TAM).getStringCellValue();
            du_lieu_giay_chung_sinh.HO_TEN_CON=currentRow.getCell(COLUMN_INDEX_HO_TEN_CON).getStringCellValue();
            du_lieu_giay_chung_sinh.GIOI_TINH_CON= Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_GIOI_TINH_CON)));
            du_lieu_giay_chung_sinh.SO_CON= Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_CON)));
            du_lieu_giay_chung_sinh.LAN_SINH= Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_LAN_SINH)));
            du_lieu_giay_chung_sinh.SO_CON_SONG= Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_CON_SONG)));
            du_lieu_giay_chung_sinh.CAN_NANG_CON= Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_CAN_NANG_CON)));
            du_lieu_giay_chung_sinh.NGAY_SINH_CON=currentRow.getCell(COLUMN_INDEX_NGAY_SINH_CON).getStringCellValue();
            du_lieu_giay_chung_sinh.NOI_SINH_CON=currentRow.getCell(COLUMN_INDEX_NOI_SINH_CON).getStringCellValue();
            du_lieu_giay_chung_sinh.TINH_TRANG_CON=currentRow.getCell(COLUMN_INDEX_TINH_TRANG_CON).getStringCellValue();
            du_lieu_giay_chung_sinh.SINHCON_PHAUTHUAT= Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SINHCON_PHAUTHUAT)));
            du_lieu_giay_chung_sinh.SINHCON_DUOI32TUAN=Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SINHCON_DUOI32TUAN)));
            du_lieu_giay_chung_sinh.GHI_CHU=currentRow.getCell(COLUMN_INDEX_GHI_CHU).getStringCellValue();
            du_lieu_giay_chung_sinh.NGUOI_DO_DE=currentRow.getCell(COLUMN_INDEX_NGUOI_DO_DE).getStringCellValue();
            du_lieu_giay_chung_sinh.NGUOI_GHI_PHIEU=currentRow.getCell(COLUMN_INDEX_NGUOI_GHI_PHIEU).getStringCellValue();
            du_lieu_giay_chung_sinh.NGAY_CT=currentRow.getCell(COLUMN_INDEX_NGAY_CT).getStringCellValue();
            du_lieu_giay_chung_sinh.SO=currentRow.getCell(COLUMN_INDEX_SO).getStringCellValue();
            du_lieu_giay_chung_sinh.QUYEN_SO=currentRow.getCell(COLUMN_INDEX_QUYEN_SO).getStringCellValue();
            du_lieu_giay_chung_sinh.MA_TTDV=currentRow.getCell(COLUMN_INDEX_MA_TTDV).getStringCellValue();
            du_lieu_giay_chung_sinh.DU_PHONG=currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();


            ds_du_lieu_giay_chung_sinh.add(du_lieu_giay_chung_sinh);
        }
        xml9.dsach_giaychungsinh.ds_du_lieu_giay_chung_sinh=ds_du_lieu_giay_chung_sinh;
        return xml9;
    }
}
