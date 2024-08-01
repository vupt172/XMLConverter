package com.vupt.application.excel.exporter;

import com.vupt.application.excel.exporter.ExcelSheetDesigner;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.CHI_TIET_DIEN_BIEN_BENH;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML5Pack.XML5;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.List;

public class XML5ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_DIEN_BIEN_LS = 2;
    public static final int COLUMN_INDEX_GIAI_DOAN_BENH = 3;
    public static final int COLUMN_INDEX_HOI_CHAN = 4;
    public static final int COLUMN_INDEX_PHAU_THUAT = 5;
    public static final int COLUMN_INDEX_THOI_DIEM_DBLS = 6;
    public static final int COLUMN_INDEX_NGUOI_THUC_HIEN = 7;
    public static final int COLUMN_INDEX_DU_PHONG = 8;
    private Workbook workbook;
    private Sheet sheet;

    public XML5ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML5 xml5) throws IOException {

        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        List<CHI_TIET_DIEN_BIEN_BENH> ds_chi_tiet_dien_bien_benh = xml5.dsach_chi_tiet_dien_bien_benh.ds_chi_tiet_dien_bien_benh;
        for (CHI_TIET_DIEN_BIEN_BENH chi_tiet_dien_bien_benh : ds_chi_tiet_dien_bien_benh) {
            // Create row
            Row row = sheet.createRow(rowIndex++);
            // Write data on row
            writeData(chi_tiet_dien_bien_benh, row);
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

        cell = row.createCell(COLUMN_INDEX_DIEN_BIEN_LS);
        cell.setCellValue("DIEN_BIEN_LS");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIAI_DOAN_BENH);
        cell.setCellValue("GIAI_DOAN_BENH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HOI_CHAN);
        cell.setCellValue("HOI_CHAN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PHAU_THUAT);
        cell.setCellValue("PHAU_THUAT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THOI_DIEM_DBLS);
        cell.setCellValue("THOI_DIEM_DBLS");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_THUC_HIEN);
        cell.setCellValue("NGUOI_THUC_HIEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);

    }

    private void writeData(CHI_TIET_DIEN_BIEN_BENH chi_tiet_dien_bien_benh, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);
        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(chi_tiet_dien_bien_benh.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue(chi_tiet_dien_bien_benh.STT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DIEN_BIEN_LS);
        cell.setCellValue(chi_tiet_dien_bien_benh.DIEN_BIEN_LS);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GIAI_DOAN_BENH);
        cell.setCellValue(chi_tiet_dien_bien_benh.GIAI_DOAN_BENH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HOI_CHAN);
        cell.setCellValue(chi_tiet_dien_bien_benh.HOI_CHAN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PHAU_THUAT);
        cell.setCellValue(chi_tiet_dien_bien_benh.PHAU_THUAT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THOI_DIEM_DBLS);
        cell.setCellValue(chi_tiet_dien_bien_benh.THOI_DIEM_DBLS);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_THUC_HIEN);
        cell.setCellValue(chi_tiet_dien_bien_benh.NGUOI_THUC_HIEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(chi_tiet_dien_bien_benh.DU_PHONG);
        cell.setCellStyle(cellStyle);

    }

}
