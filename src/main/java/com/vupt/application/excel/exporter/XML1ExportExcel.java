package com.vupt.application.excel.exporter;


import com.vupt.application.excel.exporter.ExcelSheetDesigner;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import org.apache.poi.ss.usermodel.*;

import java.io.*;


public class XML1ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_MA_BN = 2;
    public static final int COLUMN_INDEX_HO_TEN = 3;
    public static final int COLUMN_INDEX_SO_CCCD = 4;
    public static final int COLUMN_INDEX_NGAY_SINH = 5;
    public static final int COLUMN_INDEX_GIOI_TINH = 6;
    public static final int COLUMN_INDEX_NHOM_MAU = 7;
    public static final int COLUMN_INDEX_MA_QUOC_TICH = 8;
    public static final int COLUMN_INDEX_MA_DAN_TOC = 9;
    public static final int COLUMN_INDEX_MA_NGHE_NGHIEP = 10;
    public static final int COLUMN_INDEX_DIA_CHI = 11;
    public static final int COLUMN_INDEX_MATINH_CU_TRU = 12;
    public static final int COLUMN_INDEX_MAHUYEN_CU_TRU = 13;
    public static final int COLUMN_INDEX_MAXA_CU_TRU = 14;
    public static final int COLUMN_INDEX_DIEN_THOAI = 15;
    public static final int COLUMN_INDEX_MA_THE_BHYT = 16;
    public static final int COLUMN_INDEX_MA_DKBD = 17;
    public static final int COLUMN_INDEX_GT_THE_TU = 18;
    public static final int COLUMN_INDEX_GT_THE_DEN = 19;
    public static final int COLUMN_INDEX_NGAY_MIEN_CCT = 20;
    public static final int COLUMN_INDEX_LY_DO_VV = 21;
    public static final int COLUMN_INDEX_LY_DO_VNT = 22;
    public static final int COLUMN_INDEX_MA_LY_DO_VNT = 23;
    public static final int COLUMN_INDEX_CHAN_DOAN_VAO = 24;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 25;
    public static final int COLUMN_INDEX_MA_BENH_CHINH = 26;
    public static final int COLUMN_INDEX_MA_BENH_KT = 27;
    public static final int COLUMN_INDEX_MA_BENH_YHCT = 28;
    public static final int COLUMN_INDEX_MA_PTTT_QT = 29;
    public static final int COLUMN_INDEX_MA_DOITUONG_KCB = 30;
    public static final int COLUMN_INDEX_MA_NOI_DI = 31;
    public static final int COLUMN_INDEX_MA_NOI_DEN = 32;
    public static final int COLUMN_INDEX_MA_TAI_NAN = 33;
    public static final int COLUMN_INDEX_NGAY_VAO = 34;
    public static final int COLUMN_INDEX_NGAY_VAO_NOI_TRU = 35;
    public static final int COLUMN_INDEX_NGAY_RA = 36;
    public static final int COLUMN_INDEX_GIAY_CHUYEN_TUYEN = 37;
    public static final int COLUMN_INDEX_SO_NGAY_DTRI = 38;
    public static final int COLUMN_INDEX_PP_DIEU_TRI = 39;
    public static final int COLUMN_INDEX_KET_QUA_DTRI = 40;
    public static final int COLUMN_INDEX_MA_LOAI_RV = 41;
    public static final int COLUMN_INDEX_GHI_CHU = 42;
    public static final int COLUMN_INDEX_NGAY_TTOAN = 43;
    public static final int COLUMN_INDEX_T_THUOC = 44;
    public static final int COLUMN_INDEX_T_VTYT = 45;
    public static final int COLUMN_INDEX_T_TONGCHI_BV = 46;
    public static final int COLUMN_INDEX_T_TONGCHI_BH = 47;
    public static final int COLUMN_INDEX_T_BNTT = 48;
    public static final int COLUMN_INDEX_T_BNCCT = 49;
    public static final int COLUMN_INDEX_T_BHTT = 50;
    public static final int COLUMN_INDEX_T_NGUONKHAC = 51;
    public static final int COLUMN_INDEX_T_BHTT_GDV = 52;
    public static final int COLUMN_INDEX_NAM_QT = 53;
    public static final int COLUMN_INDEX_THANG_QT = 54;
    public static final int COLUMN_INDEX_MA_LOAI_KCB = 55;
    public static final int COLUMN_INDEX_MA_KHOA = 56;
    public static final int COLUMN_INDEX_MA_CSKCB = 57;
    public static final int COLUMN_INDEX_MA_KHUVUC = 58;
    public static final int COLUMN_INDEX_CAN_NANG = 59;
    public static final int COLUMN_INDEX_CAN_NANG_CON = 60;
    public static final int COLUMN_INDEX_NAM_NAM_LIEN_TUC = 61;
    public static final int COLUMN_INDEX_NGAY_TAI_KHAM = 62;
    public static final int COLUMN_INDEX_MA_HSBA = 63;
    public static final int COLUMN_INDEX_MA_TTDV = 64;
    public static final int COLUMN_INDEX_DU_PHONG = 65;

    private Workbook workbook;
    private Sheet sheet;

    public XML1ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML1 xml1) throws IOException {

        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);
        //Write data
        Row row = sheet.createRow(rowIndex++);
        writeData(xml1, row);

        //Auto size
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        ExcelSheetDesigner.autosizeColumn(sheet, numberOfColumn);

    }


    private void writeHeader(int rowIndex) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForHeader(workbook);
        Row row = sheet.createRow(rowIndex);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue("MA_LK");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue("STT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BN);
        cell.setCellValue("MA_BN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN);
        cell.setCellValue("HO_TEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CCCD);
        cell.setCellValue("SO_CCCD");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_SINH);
        cell.setCellValue("NGAY_SINH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIOI_TINH);
        cell.setCellValue("GIOI_TINH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NHOM_MAU);
        cell.setCellValue("NHOM_MAU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_QUOC_TICH);
        cell.setCellValue("MA_QUOC_TICH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DAN_TOC);
        cell.setCellValue("MA_DAN_TOC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NGHE_NGHIEP);
        cell.setCellValue("MA_NGHE_NGHIEP");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DIA_CHI);
        cell.setCellValue("DIA_CHI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MATINH_CU_TRU);
        cell.setCellValue("MATINH_CU_TRU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MAHUYEN_CU_TRU);
        cell.setCellValue("MAHUYEN_CU_TRU");
        cell.setCellStyle(cellStyle);


        cell = row.createCell(COLUMN_INDEX_MAXA_CU_TRU);
        cell.setCellValue("MAXA_CU_TRU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DIEN_THOAI);
        cell.setCellValue("DIEN_THOAI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_BHYT);
        cell.setCellValue("MA_THE_BHYT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DKBD);
        cell.setCellValue("MA_DKBD");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GT_THE_TU);
        cell.setCellValue("GT_THE_TU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GT_THE_DEN);
        cell.setCellValue("GT_THE_DEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_MIEN_CCT);
        cell.setCellValue("NGAY_MIEN_CCT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LY_DO_VV);
        cell.setCellValue("LY_DO_VV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LY_DO_VNT);
        cell.setCellValue("LY_DO_VNT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LY_DO_VNT);
        cell.setCellValue("MA_LY_DO_VNT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_VAO);
        cell.setCellValue("CHAN_DOAN_VAO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue("CHAN_DOAN_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_CHINH);
        cell.setCellValue("MA_BENH_CHINH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_KT);
        cell.setCellValue("MA_BENH_KT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_YHCT);
        cell.setCellValue("MA_BENH_YHCT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PTTT_QT);
        cell.setCellValue("MA_PTTT_QT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DOITUONG_KCB);
        cell.setCellValue("MA_DOITUONG_KCB");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DI);
        cell.setCellValue("MA_NOI_DI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DEN);
        cell.setCellValue("MA_NOI_DEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TAI_NAN);
        cell.setCellValue("MA_TAI_NAN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue("NGAY_VAO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO_NOI_TRU);
        cell.setCellValue("NGAY_VAO_NOI_TRU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue("NGAY_RA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIAY_CHUYEN_TUYEN);
        cell.setCellValue("GIAY_CHUYEN_TUYEB");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_DTRI);
        cell.setCellValue("SO_NGAY_DTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEU_TRI);
        cell.setCellValue("PP_DIEU_TRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_QUA_DTRI);
        cell.setCellValue("KET_QUA_DTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_RV);
        cell.setCellValue("MA_LOAI_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue("GHI_CHU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TTOAN);
        cell.setCellValue("NGAY_TTOAN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DI);
        cell.setCellValue("MA_NOI_DI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DEN);
        cell.setCellValue("MA_NOI_DEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TAI_NAN);
        cell.setCellValue("MA_TAI_NAN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue("NGAY_VAO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO_NOI_TRU);
        cell.setCellValue("NGAY_VAO_NOI_TRU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue("NGAY_RA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIAY_CHUYEN_TUYEN);
        cell.setCellValue("GIAY_CHUYEN_TUYEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_DTRI);
        cell.setCellValue("SO_NGAY_DTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEU_TRI);
        cell.setCellValue("PP_DIEU_TRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_QUA_DTRI);
        cell.setCellValue("KET_QUA_DTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_RV);
        cell.setCellValue("MA_LOAI_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue("GHI_CHU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TTOAN);
        cell.setCellValue("NGAY_TTOAN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_THUOC);
        cell.setCellValue("T_THUOC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_VTYT);
        cell.setCellValue("T_VTYT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_TONGCHI_BV);
        cell.setCellValue("T_TONG_CHI_BV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_TONGCHI_BH);
        cell.setCellValue("TONGCHI_BH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNTT);
        cell.setCellValue("T_BNTT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNCCT);
        cell.setCellValue("T_BNCCT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BHTT);
        cell.setCellValue("T_BHTT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC);
        cell.setCellValue("T_NGUONKHAC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BHTT_GDV);
        cell.setCellValue("T_BHTT_GDV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NAM_QT);
        cell.setCellValue("NAM_QT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANG_QT);
        cell.setCellValue("THANG_QT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_KCB);
        cell.setCellValue("MA_LOAI_KCB");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHOA);
        cell.setCellValue("MA_KHOA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CSKCB);
        cell.setCellValue("MA_CSKCB");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHUVUC);
        cell.setCellValue("MA_KHUVUC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CAN_NANG);
        cell.setCellValue("CAN_NANG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CAN_NANG_CON);
        cell.setCellValue("CAN_NANG_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NAM_NAM_LIEN_TUC);
        cell.setCellValue("NAM_NAM_LIEN_TUC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TAI_KHAM);
        cell.setCellValue("NGAY_TAI_KHAM");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_HSBA);
        cell.setCellValue("MA_HSBA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue("MA_TTDV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);


    }

    private void writeData(XML1 xml1, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(xml1.MA_LK);
        cell.setCellStyle(cellStyle);
        cell.setCellType(CellType.STRING);

        cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue(xml1.STT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BN);
        cell.setCellValue(xml1.MA_BN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN);
        cell.setCellValue(xml1.HO_TEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CCCD);
        cell.setCellValue(xml1.SO_CCCD);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_SINH);
        cell.setCellValue(xml1.NGAY_SINH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIOI_TINH);
        cell.setCellValue(xml1.GIOI_TINH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NHOM_MAU);
        cell.setCellValue(xml1.NHOM_MAU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_QUOC_TICH);
        cell.setCellValue(xml1.MA_QUOCTICH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DAN_TOC);
        cell.setCellValue(xml1.MA_DANTOC);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NGHE_NGHIEP);
        cell.setCellValue(xml1.MA_NGHE_NGHIEP);
        cell.setCellStyle(cellStyle);


        cell = row.createCell(COLUMN_INDEX_DIA_CHI);
        cell.setCellValue(xml1.DIA_CHI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MATINH_CU_TRU);
        cell.setCellValue(xml1.MATINH_CU_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MAHUYEN_CU_TRU);
        cell.setCellValue(xml1.MAHUYEN_CU_TRU);
        cell.setCellStyle(cellStyle);


        cell = row.createCell(COLUMN_INDEX_MAXA_CU_TRU);
        cell.setCellValue(xml1.MAXA_CU_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DIEN_THOAI);
        cell.setCellValue(xml1.DIEN_THOAI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_BHYT);
        cell.setCellValue(xml1.MA_THE_BHYT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DKBD);
        cell.setCellValue(xml1.MA_DKBD);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GT_THE_TU);
        cell.setCellValue(xml1.GT_THE_TU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GT_THE_DEN);
        cell.setCellValue(xml1.GT_THE_DEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_MIEN_CCT);
        cell.setCellValue(xml1.NGAY_MIEN_CCT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LY_DO_VV);
        cell.setCellValue(xml1.LY_DO_VV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LY_DO_VNT);
        cell.setCellValue(xml1.LY_DO_VNT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LY_DO_VNT);
        cell.setCellValue(xml1.MA_LY_DO_VNT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_VAO);
        cell.setCellValue(xml1.CHAN_DOAN_VAO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue(xml1.CHAN_DOAN_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_CHINH);
        cell.setCellValue(xml1.MA_BENH_CHINH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_KT);
        cell.setCellValue(xml1.MA_BENH_KT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_YHCT);
        cell.setCellValue(xml1.MA_BENH_YHCT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PTTT_QT);
        cell.setCellValue(xml1.MA_PTTT_QT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DOITUONG_KCB);
        cell.setCellValue(xml1.MA_DOITUONG_KCB);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DI);
        cell.setCellValue(xml1.MA_NOI_DI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DEN);
        cell.setCellValue(xml1.MA_NOI_DEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TAI_NAN);
        cell.setCellValue(xml1.MA_TAI_NAN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue(xml1.NGAY_VAO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO_NOI_TRU);
        cell.setCellValue(xml1.NGAY_VAO_NOI_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue(xml1.NGAY_RA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIAY_CHUYEN_TUYEN);
        cell.setCellValue(xml1.GIAY_CHUYEN_TUYEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_DTRI);
        cell.setCellValue(xml1.SO_NGAY_DTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEU_TRI);
        cell.setCellValue(xml1.PP_DIEU_TRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_QUA_DTRI);
        cell.setCellValue(xml1.KET_QUA_DTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_RV);
        cell.setCellValue(xml1.MA_LOAI_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue(xml1.GHI_CHU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TTOAN);
        cell.setCellValue(xml1.NGAY_TTOAN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DI);
        cell.setCellValue(xml1.MA_NOI_DI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NOI_DEN);
        cell.setCellValue(xml1.MA_NOI_DEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TAI_NAN);
        cell.setCellValue(xml1.MA_TAI_NAN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue(xml1.NGAY_VAO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO_NOI_TRU);
        cell.setCellValue(xml1.NGAY_VAO_NOI_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue(xml1.NGAY_RA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIAY_CHUYEN_TUYEN);
        cell.setCellValue(xml1.GIAY_CHUYEN_TUYEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_DTRI);
        cell.setCellValue(xml1.SO_NGAY_DTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEU_TRI);
        cell.setCellValue(xml1.PP_DIEU_TRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_QUA_DTRI);
        cell.setCellValue(xml1.KET_QUA_DTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_RV);
        cell.setCellValue(xml1.MA_LOAI_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue(xml1.GHI_CHU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TTOAN);
        cell.setCellValue(xml1.NGAY_TTOAN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_THUOC);
        cell.setCellValue(xml1.T_THUOC);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_VTYT);
        cell.setCellValue(xml1.T_VTYT);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_TONGCHI_BV);
        cell.setCellValue(xml1.T_TONGCHI_BV);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_TONGCHI_BH);
        cell.setCellValue(xml1.T_TONGCHI_BH);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNTT);
        cell.setCellValue(xml1.T_BNTT);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNCCT);
        cell.setCellValue(xml1.T_BNCCT);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BHTT);
        cell.setCellValue(xml1.T_BHTT);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC);
        cell.setCellValue(xml1.T_NGUONKHAC);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BHTT_GDV);
        cell.setCellValue(xml1.T_BHTT_GDV);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_NAM_QT);
        cell.setCellValue(xml1.NAM_QT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANG_QT);
        cell.setCellValue(xml1.THANG_QT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_KCB);
        cell.setCellValue(xml1.MA_LOAI_KCB);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHOA);
        cell.setCellValue(xml1.MA_KHOA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CSKCB);
        cell.setCellValue(xml1.MA_CSKCB);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHUVUC);
        cell.setCellValue(xml1.MA_KHUVUC);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CAN_NANG);
        cell.setCellValue(xml1.CAN_NANG);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_CAN_NANG_CON);
        cell.setCellValue(xml1.CAN_NANG_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NAM_NAM_LIEN_TUC);
        cell.setCellValue(xml1.NAM_NAM_LIEN_TUC);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TAI_KHAM);
        cell.setCellValue(xml1.NGAY_TAI_KHAM);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_HSBA);
        cell.setCellValue(xml1.MA_HSBA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue(xml1.MA_TTDV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(xml1.DU_PHONG);
        cell.setCellStyle(cellStyle);
    }




    /* private static void setColumnWidth(Sheet sheet){
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_ID,2000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_NAME,8000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_YEAR,3000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_STATUS,4000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_COUNT,2000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_PRICE,3000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_CATEGORY,4000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_EQUIPMENT_GROUP,4000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_DEPARTMENT,6000);
         sheet.setColumnWidth(AppConstants.ExcelEquipmentConfig.COLUMN_INDEX_NOTE,8000);


     }*/

}
