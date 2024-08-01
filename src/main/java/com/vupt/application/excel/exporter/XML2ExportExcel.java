package com.vupt.application.excel.exporter;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.CHI_TIET_THUOC;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.XML2;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.List;

public class XML2ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_MA_THUOC = 2;
    public static final int COLUMN_INDEX_MA_PP_CHEBIEN = 3;
    public static final int COLUMN_INDEX_MA_CSKCB_THUOC = 4;
    public static final int COLUMN_INDEX_MA_NHOM = 5;
    public static final int COLUMN_INDEX_TEN_THUOC = 6;
    public static final int COLUMN_INDEX_DON_VI_TINH = 7;
    public static final int COLUMN_INDEX_HAM_LUONG = 8;
    public static final int COLUMN_INDEX_DUONG_DUNG = 9;
    public static final int COLUMN_INDEX_DANG_BAO_CHE = 10;
    public static final int COLUMN_INDEX_LIEU_DUNG = 11;
    public static final int COLUMN_INDEX_CACH_DUNG = 12;
    public static final int COLUMN_INDEX_SO_DANG_KY = 13;
    public static final int COLUMN_INDEX_TT_THAU = 14;
    public static final int COLUMN_INDEX_PHAM_VI = 15;
    public static final int COLUMN_INDEX_TYLE_TT_BH = 16;
    public static final int COLUMN_INDEX_SO_LUONG = 17;
    public static final int COLUMN_INDEX_DON_GIA = 18;
    public static final int COLUMN_INDEX_THANH_TIEN_BV = 19;
    public static final int COLUMN_INDEX_THANH_TIEN_BH = 20;
    public static final int COLUMN_INDEX_T_NGUONKHAC_NSNN = 21;
    public static final int COLUMN_INDEX_T_NGUONKHAC_VTNN = 22;
    public static final int COLUMN_INDEX_T_NGUONKHAC_VTTN = 23;
    public static final int COLUMN_INDEX_T_NGUONKHAC_CL = 24;
    public static final int COLUMN_INDEX_T_NGUONKHAC = 25;
    public static final int COLUMN_INDEX_MUC_HUONG = 26;
    public static final int COLUMN_INDEX_T_BNTT = 27;
    public static final int COLUMN_INDEX_T_BNCCT = 28;
    public static final int COLUMN_INDEX_T_BHTT = 29;
    public static final int COLUMN_INDEX_T_MA_KHOA = 30;
    public static final int COLUMN_INDEX_MA_BAC_SI = 31;
    public static final int COLUMN_INDEX_MA_DICH_VU = 32;
    public static final int COLUMN_INDEX_NGAY_YL = 33;
    public static final int COLUMN_INDEX_NGAY_TH_YL = 34;
    public static final int COLUMN_INDEX_MA_PTTT = 35;
    public static final int COLUMN_INDEX_NGUON_CTRA = 36;
    public static final int COLUMN_INDEX_VET_THUONG_TP = 37;
    public static final int COLUMN_INDEX_DU_PHONG = 38;


    private Workbook workbook;
    private Sheet sheet;

    public XML2ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML2 xml2) throws IOException {

        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        List<CHI_TIET_THUOC> ds_chi_tiet_thuoc = xml2.dsach_chi_tiet_thuoc.ds_chi_tiet_thuoc;
        for (CHI_TIET_THUOC chi_tiet_thuoc : ds_chi_tiet_thuoc) {
            // Create row
            Row row = sheet.createRow(rowIndex++);
            // Write data on row
            writeData(chi_tiet_thuoc, row);
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

        cell = row.createCell(COLUMN_INDEX_MA_THUOC);
        cell.setCellValue("MA_THUOC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PP_CHEBIEN);
        cell.setCellValue("MA_PP_CHEBIEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CSKCB_THUOC);
        cell.setCellValue("MA_CSKCB_THUOC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NHOM);
        cell.setCellValue("MA_NHOM");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_THUOC);
        cell.setCellValue("TEN_THUOC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI_TINH);
        cell.setCellValue("DON_VI_TINH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HAM_LUONG);
        cell.setCellValue("HAM_LUONG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DUONG_DUNG);
        cell.setCellValue("DUONG_DUNG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DANG_BAO_CHE);
        cell.setCellValue("DANG_BAO_CHE");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LIEU_DUNG);
        cell.setCellValue("LIEU_DUNG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CACH_DUNG);
        cell.setCellValue("CACH_DUNG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_DANG_KY);
        cell.setCellValue("SO_DANG_KY");
        cell.setCellStyle(cellStyle);


        cell = row.createCell(COLUMN_INDEX_TT_THAU);
        cell.setCellValue("TT_THAU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PHAM_VI);
        cell.setCellValue("PHAM_VI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TYLE_TT_BH);
        cell.setCellValue("TYLE_TT_BH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_LUONG);
        cell.setCellValue("SO_LUONG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_GIA);
        cell.setCellValue("DON_GIA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BV);
        cell.setCellValue("THANH_TIEN_BV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BH);
        cell.setCellValue("THANH_TIEN_BH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_NSNN);
        cell.setCellValue("T_NGUONKHAC_NSNN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_VTNN);
        cell.setCellValue("T_NGUONKHAC_VTNN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_VTTN);
        cell.setCellValue("T_NGUONKHAC_VTTN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_CL);
        cell.setCellValue("T_NGUONKHAC_CL");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC);
        cell.setCellValue("T_NGUONKHAC");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MUC_HUONG);
        cell.setCellValue("MUC_HUONG");
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

        cell = row.createCell(COLUMN_INDEX_T_MA_KHOA);
        cell.setCellValue("MA_KHOA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BAC_SI);
        cell.setCellValue("MA_BAC_SI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DICH_VU);
        cell.setCellValue("MA_DICH_VU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_YL);
        cell.setCellValue("NGAY_YL");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TH_YL);
        cell.setCellValue("NGAY_TH_YL");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PTTT);
        cell.setCellValue("MA_PTTT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUON_CTRA);
        cell.setCellValue("NGUON_CTRA");
        cell.setCellStyle(cellStyle);
        cell = row.createCell(COLUMN_INDEX_VET_THUONG_TP);
        cell.setCellValue("VET_THUONG_TP");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);

    }

    private void writeData(CHI_TIET_THUOC chi_tiet_thuoc, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(chi_tiet_thuoc.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue(chi_tiet_thuoc.STT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_THUOC);
        cell.setCellValue(chi_tiet_thuoc.MA_THUOC);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PP_CHEBIEN);
        cell.setCellValue(chi_tiet_thuoc.MA_PP_CHEBIEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_CSKCB_THUOC);
        cell.setCellValue(chi_tiet_thuoc.MA_CSKCB_THUOC);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NHOM);
        cell.setCellValue(chi_tiet_thuoc.MA_NHOM);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_THUOC);
        cell.setCellValue(chi_tiet_thuoc.TEN_THUOC);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI_TINH);
        cell.setCellValue(chi_tiet_thuoc.DON_VI_TINH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_HAM_LUONG);
        cell.setCellValue(chi_tiet_thuoc.HAM_LUONG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DUONG_DUNG);
        cell.setCellValue(chi_tiet_thuoc.DUONG_DUNG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DANG_BAO_CHE);
        cell.setCellValue(chi_tiet_thuoc.DANG_BAO_CHE);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_LIEU_DUNG);
        cell.setCellValue(chi_tiet_thuoc.LIEU_DUNG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_CACH_DUNG);
        cell.setCellValue(chi_tiet_thuoc.CACH_DUNG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_DANG_KY);
        cell.setCellValue(chi_tiet_thuoc.SO_DANG_KY);
        cell.setCellStyle(cellStyle);


        cell = row.createCell(COLUMN_INDEX_TT_THAU);
        cell.setCellValue(chi_tiet_thuoc.TT_THAU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PHAM_VI);
        cell.setCellValue(chi_tiet_thuoc.PHAM_VI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TYLE_TT_BH);
        cell.setCellValue(chi_tiet_thuoc.TYLE_TT_BH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_LUONG);
        cell.setCellValue(chi_tiet_thuoc.SO_LUONG);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_GIA);
        cell.setCellValue(chi_tiet_thuoc.DON_GIA);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BV);
        cell.setCellValue(chi_tiet_thuoc.THANH_TIEN_BV);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BH);
        cell.setCellValue(chi_tiet_thuoc.THANH_TIEN_BH);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_NSNN);
        cell.setCellValue(chi_tiet_thuoc.T_NGUONKHAC_NSNN);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_VTNN);
        cell.setCellValue(chi_tiet_thuoc.T_NGUONKHAC_VTNN);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_VTTN);
        cell.setCellValue(chi_tiet_thuoc.T_NGUONKHAC_VTTN);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_CL);
        cell.setCellValue(chi_tiet_thuoc.T_NGUONKHAC_CL);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC);
        cell.setCellValue(chi_tiet_thuoc.T_NGUONKHAC);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_MUC_HUONG);
        cell.setCellValue(chi_tiet_thuoc.MUC_HUONG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNTT);
        cell.setCellValue(chi_tiet_thuoc.T_BNTT);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNCCT);
        cell.setCellValue(chi_tiet_thuoc.T_BNCCT);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BHTT);
        cell.setCellValue(chi_tiet_thuoc.T_BHTT);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);

        cell = row.createCell(COLUMN_INDEX_T_MA_KHOA);
        cell.setCellValue(chi_tiet_thuoc.MA_KHOA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BAC_SI);
        cell.setCellValue(chi_tiet_thuoc.MA_BAC_SI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DICH_VU);
        cell.setCellValue(chi_tiet_thuoc.MA_DICH_VU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_YL);
        cell.setCellValue(chi_tiet_thuoc.NGAY_YL);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TH_YL);
        cell.setCellValue(chi_tiet_thuoc.NGAY_TH_YL);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PTTT);
        cell.setCellValue(chi_tiet_thuoc.MA_PTTT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUON_CTRA);
        cell.setCellValue(chi_tiet_thuoc.NGUON_CTRA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_VET_THUONG_TP);
        if (chi_tiet_thuoc.VET_THUONG_TP != null) {
            cell.setCellValue(chi_tiet_thuoc.VET_THUONG_TP);
        }
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(chi_tiet_thuoc.DU_PHONG);
        cell.setCellStyle(cellStyle);
    }


}
