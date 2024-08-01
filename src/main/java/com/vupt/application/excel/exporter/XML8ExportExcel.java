package com.vupt.application.excel.exporter;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML8Pack.XML8;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;

public class XML8ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_MA_LOAI_KCB = 1;
    public static final int COLUMN_INDEX_HO_TEN_CHA = 2;
    public static final int COLUMN_INDEX_HO_TEN_ME = 3;
    public static final int COLUMN_INDEX_NGUOI_GIAM_HO = 4;
    public static final int COLUMN_INDEX_DON_VI = 5;
    public static final int COLUMN_INDEX_NGAY_VAO = 6;
    public static final int COLUMN_INDEX_NGAY_RA = 7;
    public static final int COLUMN_INDEX_CHAN_DOAN_VAO = 8;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 9;
    public static final int COLUMN_INDEX_QT_BENHLY = 10;
    public static final int COLUMN_INDEX_TOMTAT_KQ = 11;
    public static final int COLUMN_INDEX_PP_DIEUTRI = 12;
    public static final int COLUMN_INDEX_NGAY_SINHCON = 13;
    public static final int COLUMN_INDEX_NGAY_CONCHET = 14;
    public static final int COLUMN_INDEX_SO_CONCHET = 15;
    public static final int COLUMN_INDEX_KET_QUA_DTRI = 16;
    public static final int COLUMN_INDEX_GHI_CHU = 17;
    public static final int COLUMN_INDEX_MA_TTDV = 18;
    public static final int COLUMN_INDEX_NGAY_CT = 19;
    public static final int COLUMN_INDEX_MA_THE_TAM = 20;
    public static final int COLUMN_INDEX_DU_PHONG = 21;


    private Workbook workbook;
    private Sheet sheet;

    public XML8ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML8 xml8) throws IOException {
        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        // Create row
        Row row = sheet.createRow(rowIndex++);
        // Write data on row
        writeData(xml8, row);

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

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_KCB);
        cell.setCellValue("MA_LOAI_KCB");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue("HO_TEN_CHA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_ME);
        cell.setCellValue("HO_TEN_ME");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_GIAM_HO);
        cell.setCellValue("NGUOI_GIAM_HO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI);
        cell.setCellValue("DON_VI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue("NGAY_VAO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue("NGAY_RA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_VAO);
        cell.setCellValue("CHAN_DOAN_VAO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue("CHAN_DOAN_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_QT_BENHLY);
        cell.setCellValue("QT_BENHLY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TOMTAT_KQ);
        cell.setCellValue("TOMTAT_KQ");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEUTRI);
        cell.setCellValue("PP_DIEUTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_SINHCON);
        cell.setCellValue("NGAY_SINHCON");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CONCHET);
        cell.setCellValue("NGAY_CONCHET");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CONCHET);
        cell.setCellValue("SO_CONCHET");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_QUA_DTRI);
        cell.setCellValue("KET_QUA_DTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue("GHI_CHU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue("MA_TTDV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue("NGAY_CT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue("MA_THE_TAM");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);

    }

    private void writeData(XML8 xml8, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(xml8.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_LOAI_KCB);
        cell.setCellValue(xml8.MA_LOAI_KCB);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue(xml8.HO_TEN_CHA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_ME);
        cell.setCellValue(xml8.HO_TEN_ME);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_GIAM_HO);
        cell.setCellValue(xml8.NGUOI_GIAM_HO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI);
        cell.setCellValue(xml8.DON_VI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_VAO);
        cell.setCellValue(xml8.NGAY_VAO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_RA);
        cell.setCellValue(xml8.NGAY_RA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_VAO);
        cell.setCellValue(xml8.CHAN_DOAN_VAO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue(xml8.CHAN_DOAN_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_QT_BENHLY);
        cell.setCellValue(xml8.QT_BENHLY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TOMTAT_KQ);
        cell.setCellValue(xml8.TOMTAT_KQ);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEUTRI);
        cell.setCellValue(xml8.PP_DIEUTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_SINHCON);
        cell.setCellValue(xml8.NGAY_SINHCON);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CONCHET);
        cell.setCellValue(xml8.NGAY_CONCHET);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CONCHET);
        if (xml8.SO_CONCHET != null) cell.setCellValue(xml8.SO_CONCHET);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_QUA_DTRI);
        cell.setCellValue(xml8.KET_QUA_DTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GHI_CHU);
        cell.setCellValue(xml8.GHI_CHU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue(xml8.MA_TTDV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue(xml8.NGAY_CT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue(xml8.MA_THE_TAM);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(xml8.DU_PHONG);
        cell.setCellStyle(cellStyle);
    }
}
