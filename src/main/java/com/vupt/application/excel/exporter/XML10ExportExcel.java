package com.vupt.application.excel.exporter;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML10Pack.XML10;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML11Pack.XML11;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;

public class XML10ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_SO_SERI = 1;
    public static final int COLUMN_INDEX_SO_CT = 2;
    public static final int COLUMN_INDEX_SO_NGAY = 3;
    public static final int COLUMN_INDEX_DON_VI = 4;
    public static final int COLUMN_INDEX_CHAN_DOAN_RV = 5;
    public static final int COLUMN_INDEX_TU_NGAY = 6;
    public static final int COLUMN_INDEX_DEN_NGAY = 7;
    public static final int COLUMN_INDEX_MA_TTDV = 8;
    public static final int COLUMN_INDEX_TEN_BS = 9;
    public static final int COLUMN_INDEX_MA_BS = 10;
    public static final int COLUMN_INDEX_NGAY_CT = 11;
    public static final int COLUMN_INDEX_DU_PHONG = 12;


    private Workbook workbook;
    private Sheet sheet;

    public XML10ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML10 xml10) throws IOException {
        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        // Create row
        Row row = sheet.createRow(rowIndex++);
        // Write data on row
        writeData(xml10, row);

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

        cell = row.createCell(COLUMN_INDEX_SO_SERI);
        cell.setCellValue("SO_SERI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CT);
        cell.setCellValue("SO_CT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY);
        cell.setCellValue("SO_NGAY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI);
        cell.setCellValue("DON_VI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue("CHAN_DOAN_RV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TU_NGAY);
        cell.setCellValue("TU_NGAY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DEN_NGAY);
        cell.setCellValue("DEN_NGAY");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue("MA_TTDV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_BS);
        cell.setCellValue("TEN_BS");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS);
        cell.setCellValue("MA_BS");
        cell.setCellStyle(cellStyle);


        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue("NGAY_CT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);


    }

    private void writeData(XML10 xml10, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(xml10.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_SERI);
        cell.setCellValue(xml10.SO_SERI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_CT);
        cell.setCellValue(xml10.SO_CT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_NGAY);
        cell.setCellValue(xml10.SO_NGAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI);
        cell.setCellValue(xml10.DON_VI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CHAN_DOAN_RV);
        cell.setCellValue(xml10.CHAN_DOAN_RV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TU_NGAY);
        cell.setCellValue(xml10.TU_NGAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DEN_NGAY);
        cell.setCellValue(xml10.DEN_NGAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_TTDV);
        cell.setCellValue(xml10.MA_TTDV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_BS);
        cell.setCellValue(xml10.TEN_BS);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS);
        cell.setCellValue(xml10.MA_BS);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_CT);
        cell.setCellValue(xml10.NGAY_CT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(xml10.DU_PHONG);
        cell.setCellStyle(cellStyle);


    }
}