package com.vupt.application.excel.exporter;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.CHI_TIET_CLS;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML4Pack.XML4;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.List;

public class XML4ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_MA_DICH_VU = 2;
    public static final int COLUMN_INDEX_MA_CHI_SO = 3;
    public static final int COLUMN_INDEX_TEN_CHI_SO = 4;
    public static final int COLUMN_INDEX_GIA_TRI = 5;
    public static final int COLUMN_INDEX_DON_VI_DO = 6;
    public static final int COLUMN_INDEX_MO_TA = 7;
    public static final int COLUMN_INDEX_KET_LUAN = 8;
    public static final int COLUMN_INDEX_NGAY_KQ = 9;
    public static final int COLUMN_INDEX_MA_BS_DOC_KQ = 10;
    public static final int COLUMN_INDEX_DU_PHONG = 11;

    private Workbook workbook;
    private Sheet sheet;

    public XML4ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML4 xml4) throws IOException {

        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        List<CHI_TIET_CLS> ds_chi_tiet_cls = xml4.dsach_chi_tiet_cls.ds_chi_tiet_cls;
        for (CHI_TIET_CLS chi_tiet_cls : ds_chi_tiet_cls) {
            // Create row
            Row row = sheet.createRow(rowIndex++);
            // Write data on row
            writeData(chi_tiet_cls, row);
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

        cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue("STT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DICH_VU);
        cell.setCellValue("MA_DICH_VU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CHI_SO);
        cell.setCellValue("MA_CHI_SO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_CHI_SO);
        cell.setCellValue("TEN_CHI_SO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIA_TRI);
        cell.setCellValue("GIA_TRI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI_DO);
        cell.setCellValue("DON_VI_DO");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MO_TA);
        cell.setCellValue("MO_TA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_LUAN);
        cell.setCellValue("KET_LUAN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_KQ);
        cell.setCellValue("NGAY_KQ");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS_DOC_KQ);
        cell.setCellValue("MA_BS_DOC_KQ");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);
    }

    private void writeData(CHI_TIET_CLS chi_tiet_cls, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(chi_tiet_cls.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue(chi_tiet_cls.STT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DICH_VU);
        cell.setCellValue(chi_tiet_cls.MA_DICH_VU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CHI_SO);
        cell.setCellValue(chi_tiet_cls.MA_CHI_SO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_CHI_SO);
        cell.setCellValue(chi_tiet_cls.TEN_CHI_SO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIA_TRI);
        cell.setCellValue(chi_tiet_cls.GIA_TRI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI_DO);
        cell.setCellValue(chi_tiet_cls.DON_VI_DO);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MO_TA);
        cell.setCellValue(chi_tiet_cls.MO_TA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_KET_LUAN);
        cell.setCellValue(chi_tiet_cls.KET_LUAN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_KQ);
        cell.setCellValue(chi_tiet_cls.NGAY_KQ);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BS_DOC_KQ);
        cell.setCellValue(chi_tiet_cls.MA_BS_DOC_KQ);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(chi_tiet_cls.DU_PHONG);
        cell.setCellStyle(cellStyle);
    }
}
