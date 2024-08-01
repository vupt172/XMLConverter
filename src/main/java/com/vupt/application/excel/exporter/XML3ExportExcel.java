package com.vupt.application.excel.exporter;

import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.CHI_TIET_DVKT;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML3Pack.XML3;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.List;

public class XML3ExportExcel {
    public static final int COLUMN_INDEX_MA_LK = 0;
    public static final int COLUMN_INDEX_STT = 1;
    public static final int COLUMN_INDEX_MA_DICH_VU = 2;
    public static final int COLUMN_INDEX_MA_PTTT_QT = 3;
    public static final int COLUMN_INDEX_MA_VAT_TU = 4;
    public static final int COLUMN_INDEX_MA_NHOM = 5;
    public static final int COLUMN_INDEX_GOI_VTYT = 6;
    public static final int COLUMN_INDEX_TEN_VAT_TU = 7;
    public static final int COLUMN_INDEX_TEN_DICH_VU = 8;
    public static final int COLUMN_INDEX_MA_XANG_DAU = 9;
    public static final int COLUMN_INDEX_DON_VI_TINH = 10;
    public static final int COLUMN_INDEX_PHAM_VI = 11;
    public static final int COLUMN_INDEX_SO_LUONG = 12;
    public static final int COLUMN_INDEX_DON_GIA_BV = 13;
    public static final int COLUMN_INDEX_DON_GIA_BH = 14;
    public static final int COLUMN_INDEX_TT_THAU = 15;
    public static final int COLUMN_INDEX_TYLE_TT_DV = 16;
    public static final int COLUMN_INDEX_TYLE_TT_BH = 17;
    public static final int COLUMN_INDEX_THANH_TIEN_BV = 18;
    public static final int COLUMN_INDEX_THANH_TIEN_BH = 19;
    public static final int COLUMN_INDEX_T_TRANTT = 20;
    public static final int COLUMN_INDEX_MUC_HUONG = 21;
    public static final int COLUMN_INDEX_T_NGUONKHAC_NSNN = 22;
    public static final int COLUMN_INDEX_T_NGUONKHAC_VTNN = 23;
    public static final int COLUMN_INDEX_T_NGUONKHAC_VTTN = 24;
    public static final int COLUMN_INDEX_T_NGUONKHAC_CL = 25;
    public static final int COLUMN_INDEX_T_NGUONKHAC = 26;
    public static final int COLUMN_INDEX_T_BNTT = 27;
    public static final int COLUMN_INDEX_T_BNCCT = 28;
    public static final int COLUMN_INDEX_T_BHTT = 29;
    public static final int COLUMN_INDEX_MA_KHOA = 30;
    public static final int COLUMN_INDEX_MA_GIUONG = 31;
    public static final int COLUMN_INDEX_MA_BAC_SI = 32;
    public static final int COLUMN_INDEX_NGUOI_THUC_HIEN = 33;
    public static final int COLUMN_INDEX_MA_BENH = 34;
    public static final int COLUMN_INDEX_MA_BENH_YHCT = 35;
    public static final int COLUMN_INDEX_NGAY_YL = 36;
    public static final int COLUMN_INDEX_NGAY_TH_YL = 37;
    public static final int COLUMN_INDEX_NGAY_KQ = 38;
    public static final int COLUMN_INDEX_MA_PTTT = 39;
    public static final int COLUMN_INDEX_VET_THUONG_TP = 40;
    public static final int COLUMN_INDEX_PP_VO_CAM = 41;
    public static final int COLUMN_INDEX_VI_TRI_TH_DVKT = 42;
    public static final int COLUMN_INDEX_MA_MAY = 43;
    public static final int COLUMN_INDEX_MA_HIEU_SP = 44;
    public static final int COLUMN_INDEX_TAI_SU_DUNG = 45;
    public static final int COLUMN_INDEX_DU_PHONG = 46;
    private Workbook workbook;
    private Sheet sheet;

    public XML3ExportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public void writeExcel(XML3 xml3) throws IOException {

        //Write header
        int rowIndex = 0;
        writeHeader(rowIndex++);

        //Write data
        List<CHI_TIET_DVKT> ds_chi_tiet_dvkt = xml3.dsach_chi_tiet_dvkt.ds_chi_tiet_dvkt;
        for (CHI_TIET_DVKT chi_tiet_dvkt : ds_chi_tiet_dvkt) {
            // Create row
            Row row = sheet.createRow(rowIndex++);
            // Write data on row
            writeData(chi_tiet_dvkt, row);
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

        cell = row.createCell(COLUMN_INDEX_MA_PTTT_QT);
        cell.setCellValue("MA_PTTT_QT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_VAT_TU);
        cell.setCellValue("MA_VAT_TU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NHOM);
        cell.setCellValue("MA_NHOM");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GOI_VTYT);
        cell.setCellValue("GOI_VTYT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_VAT_TU);
        cell.setCellValue("TEN_VAT_TU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_DICH_VU);
        cell.setCellValue("TEN_DICH_VU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_XANG_DAU);
        cell.setCellValue("MA_XANG_DAU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI_TINH);
        cell.setCellValue("DON_VI_TINH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PHAM_VI);
        cell.setCellValue("PHAM_VI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_LUONG);
        cell.setCellValue("SO_LUONG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_GIA_BV);
        cell.setCellValue("DON_GIA_BV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_GIA_BH);
        cell.setCellValue("DON_GIA_BH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TT_THAU);
        cell.setCellValue("TT_THAU");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TYLE_TT_DV);
        cell.setCellValue("TYLE_TT_DV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TYLE_TT_BH);
        cell.setCellValue("TYLE_TT_BH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BV);
        cell.setCellValue("THANH_TIEN_BV");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BH);
        cell.setCellValue("THANH_TIEN_BH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_TRANTT);
        cell.setCellValue("T_TRANTT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MUC_HUONG);
        cell.setCellValue("MUC_HUONG");
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

        cell = row.createCell(COLUMN_INDEX_T_BNTT);
        cell.setCellValue("T_BNTT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNCCT);
        cell.setCellValue("T_BNCCT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BHTT);
        cell.setCellValue("T_BHTT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHOA);
        cell.setCellValue("MA_KHOA");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_GIUONG);
        cell.setCellValue("MA_GIUONG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BAC_SI);
        cell.setCellValue("MA_BAC_SI");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_THUC_HIEN);
        cell.setCellValue("NGUOI_THUC_HIEN");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH);
        cell.setCellValue("MA_BENH");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_YHCT);
        cell.setCellValue("MA_BENH_YHCT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_YL);
        cell.setCellValue("NGAY_YL");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TH_YL);
        cell.setCellValue("NGAY_TH_YL");
        cell.setCellStyle(cellStyle);
        cell = row.createCell(COLUMN_INDEX_NGAY_KQ);
        cell.setCellValue("NGAY_KQ");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PTTT);
        cell.setCellValue("MA_PTTT");
        cell.setCellStyle(cellStyle);
        cell = row.createCell(COLUMN_INDEX_VET_THUONG_TP);
        cell.setCellValue("VET_THUONG_TP");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_VO_CAM);
        cell.setCellValue("PP_VO_CAM");
        cell.setCellStyle(cellStyle);
        cell = row.createCell(COLUMN_INDEX_VI_TRI_TH_DVKT);
        cell.setCellValue("VI_TRI_TH_DVKT");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_MAY);
        cell.setCellValue("MA_MAY");
        cell.setCellStyle(cellStyle);
        cell = row.createCell(COLUMN_INDEX_MA_HIEU_SP);
        cell.setCellValue("MA_HIEU_SP");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TAI_SU_DUNG);
        cell.setCellValue("TAI_SU_DUNG");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue("DU_PHONG");
        cell.setCellStyle(cellStyle);


    }

    private void writeData(CHI_TIET_DVKT chi_tiet_dvkt, Row row) {
        CellStyle cellStyle = ExcelSheetDesigner.createStyleForData(workbook);

        Cell cell = row.createCell(COLUMN_INDEX_MA_LK);
        cell.setCellValue(chi_tiet_dvkt.MA_LK);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue(chi_tiet_dvkt.STT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_DICH_VU);
        cell.setCellValue(chi_tiet_dvkt.MA_DICH_VU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PTTT_QT);
        cell.setCellValue(chi_tiet_dvkt.MA_PTTT_QT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_VAT_TU);
        cell.setCellValue(chi_tiet_dvkt.MA_VAT_TU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_NHOM);
        cell.setCellValue(chi_tiet_dvkt.MA_NHOM);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_GOI_VTYT);
        cell.setCellValue(chi_tiet_dvkt.GOI_VTYT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_VAT_TU);
        cell.setCellValue(chi_tiet_dvkt.TEN_VAT_TU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TEN_DICH_VU);
        cell.setCellValue(chi_tiet_dvkt.TEN_DICH_VU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_XANG_DAU);
        cell.setCellValue(chi_tiet_dvkt.MA_XANG_DAU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_VI_TINH);
        cell.setCellValue(chi_tiet_dvkt.DON_VI_TINH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PHAM_VI);
        cell.setCellValue(chi_tiet_dvkt.PHAM_VI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_SO_LUONG);
        cell.setCellValue(chi_tiet_dvkt.SO_LUONG);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);


        cell = row.createCell(COLUMN_INDEX_DON_GIA_BV);
        cell.setCellValue(chi_tiet_dvkt.DON_GIA_BV);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);
        //  cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DON_GIA_BH);
        cell.setCellValue(chi_tiet_dvkt.DON_GIA_BH);
        cell.setCellStyle(GDHSExportExcel.formatNumberCellStyle);
        //  cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TT_THAU);
        cell.setCellValue(chi_tiet_dvkt.TT_THAU);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TYLE_TT_DV);
        cell.setCellValue(chi_tiet_dvkt.TYLE_TT_DV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TYLE_TT_BH);
        cell.setCellValue(chi_tiet_dvkt.TYLE_TT_BH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BV);
        cell.setCellValue(chi_tiet_dvkt.THANH_TIEN_BV);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_THANH_TIEN_BH);
        cell.setCellValue(chi_tiet_dvkt.THANH_TIEN_BH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_TRANTT);
        cell.setCellValue(chi_tiet_dvkt.T_TRANTT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MUC_HUONG);
        cell.setCellValue(chi_tiet_dvkt.MUC_HUONG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_NSNN);
        cell.setCellValue(chi_tiet_dvkt.T_NGUONKHAC_NSNN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_VTNN);
        cell.setCellValue(chi_tiet_dvkt.T_NGUONKHAC_VTNN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_VTTN);
        cell.setCellValue(chi_tiet_dvkt.T_NGUONKHAC_VTTN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC_CL);
        cell.setCellValue(chi_tiet_dvkt.T_NGUONKHAC_CL);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_NGUONKHAC);
        cell.setCellValue(chi_tiet_dvkt.T_NGUONKHAC);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNTT);
        cell.setCellValue(chi_tiet_dvkt.T_BNTT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BNCCT);
        cell.setCellValue(chi_tiet_dvkt.T_BNCCT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_T_BHTT);
        cell.setCellValue(chi_tiet_dvkt.T_BHTT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_KHOA);
        cell.setCellValue(chi_tiet_dvkt.MA_KHOA);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_GIUONG);
        cell.setCellValue(chi_tiet_dvkt.MA_GIUONG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BAC_SI);
        cell.setCellValue(chi_tiet_dvkt.MA_BAC_SI);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGUOI_THUC_HIEN);
        cell.setCellValue(chi_tiet_dvkt.NGUOI_THUC_HIEN);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH);
        cell.setCellValue(chi_tiet_dvkt.MA_BENH);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_BENH_YHCT);
        cell.setCellValue(chi_tiet_dvkt.MA_BENH_YHCT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_YL);
        cell.setCellValue(chi_tiet_dvkt.NGAY_YL);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_NGAY_TH_YL);
        cell.setCellValue(chi_tiet_dvkt.NGAY_TH_YL);
        cell.setCellStyle(cellStyle);
        cell = row.createCell(COLUMN_INDEX_NGAY_KQ);
        cell.setCellValue(chi_tiet_dvkt.NGAY_KQ);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_PTTT);
        cell.setCellValue(chi_tiet_dvkt.MA_PTTT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_VET_THUONG_TP);
        if (chi_tiet_dvkt.VET_THUONG_TP != null) {
            cell.setCellValue(chi_tiet_dvkt.VET_THUONG_TP);
        }
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_PP_VO_CAM);
        if (chi_tiet_dvkt.PP_VO_CAM != null) {
            cell.setCellValue(chi_tiet_dvkt.PP_VO_CAM);
        }
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_VI_TRI_TH_DVKT);
        cell.setCellValue(chi_tiet_dvkt.VI_TRI_TH_DVKT);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_MAY);
        cell.setCellValue(chi_tiet_dvkt.MA_MAY);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_MA_HIEU_SP);
        cell.setCellValue(chi_tiet_dvkt.MA_HIEU_SP);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_TAI_SU_DUNG);
        if (chi_tiet_dvkt.TAI_SU_DUNG != null) cell.setCellValue(chi_tiet_dvkt.TAI_SU_DUNG);
        cell.setCellStyle(cellStyle);

        cell = row.createCell(COLUMN_INDEX_DU_PHONG);
        cell.setCellValue(chi_tiet_dvkt.DU_PHONG);
        cell.setCellStyle(cellStyle);

    }
}
