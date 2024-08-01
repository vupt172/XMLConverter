package com.vupt.application.excel.exporter;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML7Pack.XML7;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;

public class XML7ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_SO_LUU_TRU = 1;
    public static final int COLUMN_INDEX_MA_YTE = 2;
    public static final int COLUMN_INDEX_MA_KHOA_RV = 3;
    public static final int COLUMN_INDEX_NGAY_VAO = 4;
    public static final int COLUMN_INDEX_NGAY_RA = 5;
    public static final int COLUMN_INDEX_MA_DINH_CHI_THAI = 6;
    public static final int COLUMN_INDEX_NGUYENNHAN_DINHCHI = 7;
    public static final int COLUMN_INDEX_THOIGIAN_DINHCHI = 8;
    public static final int COLUMN_INDEX_TUOI_THAI = 9;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 10;
    public static final int COLUMN_INDEX_PP_DIEUTRI = 11;
    public static final int COLUMN_INDEX_GHI_CHU = 12;
    public static final int COLUMN_INDEX_MA_TTDV = 13;
    public static final int COLUMN_INDEX_MA_BS = 14;
    public static final int COLUMN_INDEX_TEN_BS = 15;
    public static final int COLUMN_INDEX_NGAY_CT = 16;
    public static final int COLUMN_INDEX_MA_CHA = 17;
    public static final int COLUMN_INDEX_MA_ME = 18;
    public static final int COLUMN_INDEX_MA_THE_TAM = 19;
    public static final int COLUMN_INDEX_HO_TEN_CHA = 20;
    public static final int COLUMN_INDEX_HO_TEN_ME = 21;
    public static final int COLUMN_INDEX_SO_NGAY_NGHI = 22;
    public static final int COLUMN_INDEX_NGOAITRU_TUNGAY = 23;
    public static final int COLUMN_INDEX_NGOAITRU_DENNGAY = 24;
    public static final int COLUMN_INDEX_DU_PHONG = 25;

    private Workbook workbook;
    private Sheet sheet;

    public XML7ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML7 xml7) throws IOException {
        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        // Create row
        Row row = sheet.createRow(rowIndex++);
        // Write data on row
        writeData(xml7, row);

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

        cell = row.createCell(COLUMN_INDEX_SO_LUU_TRU);
        cell.setCellValue("SO_LUU_TRU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_YTE);
        cell.setCellValue("MA_YTE");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHOA_RV);
        cell.setCellValue("MA_KHOA_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue("NGAY_VAO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue("NGAY_RA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DINH_CHI_THAI);
        cell.setCellValue("MA_DINH_CHI_THAI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUYENNHAN_DINHCHI);
        cell.setCellValue("NGUYENNHAN_DINHCHI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THOIGIAN_DINHCHI);
        cell.setCellValue("THOIGIAN_DINHCHI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TUOI_THAI);
        cell.setCellValue("TUOI_THAI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue("CHAN_DOAN_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEUTRI);
        cell.setCellValue("PP_DIEUTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue("GHI_CHU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue("MA_TTDV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS);
        cell.setCellValue("MA_BS");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_BS);
        cell.setCellValue("TEN_BS");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue("NGAY_CT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CHA);
        cell.setCellValue("MA_CHA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_ME);
        cell.setCellValue("MA_ME");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue("MA_THE_TAM");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue("HO_TEN_CHA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_ME);
        cell.setCellValue("HO_TEN_ME");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_NGHI);
        cell.setCellValue("SO_NGAY_NGHI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGOAITRU_TUNGAY);
        cell.setCellValue("NGOAITRU_TUNGAY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGOAITRU_DENNGAY);
        cell.setCellValue("NGOAITRU_DENNGAY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);

    }

    private void writeData(XML7 xml7, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(xml7.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_LUU_TRU);
        cell.setCellValue(xml7.SO_LUU_TRU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_YTE);
        cell.setCellValue(xml7.MA_YTE);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHOA_RV);
        cell.setCellValue(xml7.MA_KHOA_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue(xml7.NGAY_VAO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue(xml7.NGAY_RA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DINH_CHI_THAI);
        cell.setCellValue(xml7.MA_DINH_CHI_THAI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUYENNHAN_DINHCHI);
        cell.setCellValue(xml7.NGUYENNHAN_DINHCHI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THOIGIAN_DINHCHI);
        cell.setCellValue(xml7.THOIGIAN_DINHCHI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TUOI_THAI);
        if (xml7.TUOI_THAI != null) cell.setCellValue(xml7.TUOI_THAI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue(xml7.CHAN_DOAN_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEUTRI);
        cell.setCellValue(xml7.PP_DIEUTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue(xml7.GHI_CHU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue(xml7.MA_TTDV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS);
        cell.setCellValue(xml7.MA_BS);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_BS);
        cell.setCellValue(xml7.TEN_BS);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue(xml7.NGAY_CT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CHA);
        cell.setCellValue(xml7.MA_CHA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_ME);
        cell.setCellValue(xml7.MA_ME);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue(xml7.MA_THE_TAM);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue(xml7.HO_TEN_CHA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_ME);
        cell.setCellValue(xml7.HO_TEN_ME);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_NGHI);
        if (xml7.SO_NGAY_NGHI != null) cell.setCellValue(xml7.SO_NGAY_NGHI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGOAITRU_TUNGAY);
        cell.setCellValue(xml7.NGOAITRU_TUNGAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGOAITRU_DENNGAY);
        cell.setCellValue(xml7.NGOAITRU_DENNGAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(xml7.DU_PHONG);
        cell.setCellStyle(cellStyle);
    }
}
