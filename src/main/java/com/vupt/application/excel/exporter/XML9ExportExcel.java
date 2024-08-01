package com.vupt.application.excel.exporter;

import com.vupt.application.excel.exporter.ExcelSheetDesigner;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.DU_LIEU_GIAY_CHUNG_SINH;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML9Pack.XML9;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.List;

public class XML9ExportExcel {
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

    public XML9ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML9 xml9) throws IOException {
        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        List<DU_LIEU_GIAY_CHUNG_SINH> ds_du_lieu_giay_chung_sinh = xml9.dsach_giaychungsinh.ds_du_lieu_giay_chung_sinh;
        for (DU_LIEU_GIAY_CHUNG_SINH du_lieu_giay_chung_sinh : ds_du_lieu_giay_chung_sinh) {
            // Create row
            Row row = sheet.createRow(rowIndex++);
            // Write data on row
            writeData(du_lieu_giay_chung_sinh, row);
        }
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


        cell = row.createCell(COLUMN_INDEX_MA_BHXH_NND);
        cell.setCellValue("MA_BHXH_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_NND);
        cell.setCellValue("MA_THE_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_NND);
        cell.setCellValue("HO_TEN_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAYSINH_NND);
        cell.setCellValue("NGAYSINH_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DANTOC_NND);
        cell.setCellValue("MA_DANTOC_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CCCD_NND);
        cell.setCellValue("SO_CCCD_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAYCAP_CCCD_NND);
        cell.setCellValue("NGAYCAP_CCCD_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NOICAP_CCCD_NND);
        cell.setCellValue("NOICAP_CCCD_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NOI_CU_TRU_NND);
        cell.setCellValue("NOI_CU_TRU_NND");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_QUOCTICH);
        cell.setCellValue("MA_QUOCTICH");
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

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue("HO_TEN_CHA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue("MA_THE_TAM");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CON);
        cell.setCellValue("HO_TEN_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIOI_TINH_CON);
        cell.setCellValue("GIOI_TINH_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CON);
        cell.setCellValue("SO_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LAN_SINH);
        cell.setCellValue("LAN_SINH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CON_SONG);
        cell.setCellValue("SO_CON_SONG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CAN_NANG_CON);
        cell.setCellValue("CAN_NANG_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_SINH_CON);
        cell.setCellValue("NGAY_SINH_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NOI_SINH_CON);
        cell.setCellValue("NOI_SINH_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TINH_TRANG_CON);
        cell.setCellValue("TINH_TRANG_CON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SINHCON_PHAUTHUAT);
        cell.setCellValue("SINHCON_PHAUTHUAT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SINHCON_DUOI32TUAN);
        cell.setCellValue("SINHCON_DUOI32TUAN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue("GHI_CHU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_DO_DE);
        cell.setCellValue("NGUOI_DO_DE");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_GHI_PHIEU);
        cell.setCellValue("NGUOI_GHI_PHIEU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue("NGAY_CT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO);
        cell.setCellValue("SO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_QUYEN_SO);
        cell.setCellValue("QUYEN_SO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue("MA_TTDV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);
    }

    private void writeData(DU_LIEU_GIAY_CHUNG_SINH du_lieu_giay_chung_sinh, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(du_lieu_giay_chung_sinh.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BHXH_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.MA_BHXH_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.MA_THE_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.HO_TEN_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAYSINH_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.NGAYSINH_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DANTOC_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.MA_DANTOC_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CCCD_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.SO_CCCD_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAYCAP_CCCD_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.NGAYCAP_CCCD_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NOICAP_CCCD_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.NOICAP_CCCD_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NOI_CU_TRU_NND);
        cell.setCellValue(du_lieu_giay_chung_sinh.NOI_CU_TRU_NND);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_QUOCTICH);
        cell.setCellValue(du_lieu_giay_chung_sinh.MA_QUOCTICH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MATINH_CU_TRU);
        cell.setCellValue(du_lieu_giay_chung_sinh.MATINH_CU_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MAHUYEN_CU_TRU);
        cell.setCellValue(du_lieu_giay_chung_sinh.MAHUYEN_CU_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MAXA_CU_TRU);
        cell.setCellValue(du_lieu_giay_chung_sinh.MAXA_CU_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue(du_lieu_giay_chung_sinh.HO_TEN_CHA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue(du_lieu_giay_chung_sinh.MA_THE_TAM);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CON);
        cell.setCellValue(du_lieu_giay_chung_sinh.HO_TEN_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIOI_TINH_CON);
        cell.setCellValue(du_lieu_giay_chung_sinh.GIOI_TINH_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CON);
        cell.setCellValue(du_lieu_giay_chung_sinh.SO_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LAN_SINH);
        cell.setCellValue(du_lieu_giay_chung_sinh.LAN_SINH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CON_SONG);
        cell.setCellValue(du_lieu_giay_chung_sinh.SO_CON_SONG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CAN_NANG_CON);
        cell.setCellValue(du_lieu_giay_chung_sinh.CAN_NANG_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_SINH_CON);
        cell.setCellValue(du_lieu_giay_chung_sinh.NGAY_SINH_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NOI_SINH_CON);
        cell.setCellValue(du_lieu_giay_chung_sinh.NOI_SINH_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TINH_TRANG_CON);
        cell.setCellValue(du_lieu_giay_chung_sinh.TINH_TRANG_CON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SINHCON_PHAUTHUAT);
        cell.setCellValue(du_lieu_giay_chung_sinh.SINHCON_PHAUTHUAT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SINHCON_DUOI32TUAN);
        cell.setCellValue(du_lieu_giay_chung_sinh.SINHCON_DUOI32TUAN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue(du_lieu_giay_chung_sinh.GHI_CHU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_DO_DE);
        cell.setCellValue(du_lieu_giay_chung_sinh.NGUOI_DO_DE);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_GHI_PHIEU);
        cell.setCellValue(du_lieu_giay_chung_sinh.NGUOI_GHI_PHIEU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue(du_lieu_giay_chung_sinh.NGAY_CT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO);
        cell.setCellValue(du_lieu_giay_chung_sinh.SO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_QUYEN_SO);
        cell.setCellValue(du_lieu_giay_chung_sinh.QUYEN_SO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue(du_lieu_giay_chung_sinh.MA_TTDV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(du_lieu_giay_chung_sinh.DU_PHONG);
        cell.setCellStyle(cellStyle);
    }
}


