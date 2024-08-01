package com.vupt.application.excel.exporter;

import com.vupt.application.excel.exporter.ExcelSheetDesigner;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML11Pack.XML11;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;

public class XML11ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_SO_CT = 1;
    public static final int COLUMN_INDEX_SO_SERI = 2;
    public static final int COLUMN_INDEX_SO_KCB = 3;
    public static final int COLUMN_INDEX_DON_VI = 4;
    public static final int COLUMN_INDEX_MA_BHXH = 5;
    public static final int COLUMN_INDEX_MA_THE_BHYT = 6;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 7;
    public static final int COLUMN_INDEX_PP_DIEUTRI = 8;
    public static final int COLUMN_INDEX_MA_DINH_CHI_THAI = 9;
    public static final int COLUMN_INDEX_NGUYENNHAN_DINHCHI = 10;
    public static final int COLUMN_INDEX_TUOI_THAI = 11;
    public static final int COLUMN_INDEX_SO_NGAY_NGHI = 12;
    public static final int COLUMN_INDEX_TU_NGAY = 13;
    public static final int COLUMN_INDEX_DEN_NGAY = 14;
    public static final int COLUMN_INDEX_HO_TEN_CHA = 15;
    public static final int COLUMN_INDEX_HO_TEN_ME = 16;
    public static final int COLUMN_INDEX_MA_TTDV = 17;
    public static final int COLUMN_INDEX_MA_BS = 18;
    public static final int COLUMN_INDEX_NGAY_CT = 19;
    public static final int COLUMN_INDEX_MA_THE_TAM = 20;
    public static final int COLUMN_INDEX_MAU_SO = 21;
    public static final int COLUMN_INDEX_DU_PHONG = 22;

    private Workbook workbook;
    private Sheet sheet;

    public XML11ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML11 xml11) throws IOException {
        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        // Create row
        Row row = sheet.createRow(rowIndex++);
        // Write data on row
        writeData(xml11, row);

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

        cell = row.createCell(COLUMN_INDEX_SO_CT);
        cell.setCellValue("SO_CT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_SERI);
        cell.setCellValue("SO_SERI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_KCB);
        cell.setCellValue("SO_KCB");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI);
        cell.setCellValue("DON_VI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BHXH);
        cell.setCellValue("MA_BHXH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_BHYT);
        cell.setCellValue("MA_THE_BHYT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue("CHAN_DOAN_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEUTRI);
        cell.setCellValue("PP_DIEUTRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DINH_CHI_THAI);
        cell.setCellValue("MA_DINH_CHI_THAI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUYENNHAN_DINHCHI);
        cell.setCellValue("NGUYENNHAN_DINHCHI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TUOI_THAI);
        cell.setCellValue("TUOI_THAI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_NGHI);
        cell.setCellValue("SO_NGAY_NGHI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TU_NGAY);
        cell.setCellValue("TU_NGAY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DEN_NGAY);
        cell.setCellValue("DEN_NGAY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue("HO_TEN_CHA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_ME);
        cell.setCellValue("HO_TEN_ME");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue("MA_TTDV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS);
        cell.setCellValue("MA_BS");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue("NGAY_CT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue("MA_THE_TAM");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MAU_SO);
        cell.setCellValue("MAU_SO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);
    }

    private void writeData(XML11 xml11, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(xml11.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CT);
        cell.setCellValue(xml11.SO_CT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_SERI);
        cell.setCellValue(xml11.SO_SERI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_KCB);
        cell.setCellValue(xml11.SO_KCB);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI);
        cell.setCellValue(xml11.DON_VI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BHXH);
        cell.setCellValue(xml11.MA_BHXH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_BHYT);
        cell.setCellValue(xml11.MA_THE_BHYT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue(xml11.CHAN_DOAN_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_DIEUTRI);
        cell.setCellValue(xml11.PP_DIEUTRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DINH_CHI_THAI);
        cell.setCellValue(xml11.MA_DINH_CHI_THAI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUYENNHAN_DINHCHI);
        cell.setCellValue(xml11.NGUYENNHAN_DINHCHI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TUOI_THAI);
        if (xml11.TUOI_THAI != null) cell.setCellValue(xml11.TUOI_THAI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY_NGHI);
        cell.setCellValue(xml11.SO_NGAY_NGHI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TU_NGAY);
        cell.setCellValue(xml11.TU_NGAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DEN_NGAY);
        cell.setCellValue(xml11.DEN_NGAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_CHA);
        cell.setCellValue(xml11.HO_TEN_CHA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HO_TEN_ME);
        cell.setCellValue(xml11.HO_TEN_ME);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue(xml11.MA_TTDV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS);
        cell.setCellValue(xml11.MA_BS);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue(xml11.NGAY_CT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THE_TAM);
        cell.setCellValue(xml11.MA_THE_TAM);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MAU_SO);
        cell.setCellValue(xml11.MAU_SO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(xml11.DU_PHONG);
        cell.setCellStyle(cellStyle);

    }
}
