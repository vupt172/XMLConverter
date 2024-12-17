package com.vupt.application.excel.importer;

import com.vupt.application.exception.AppException;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML1Pack.XML1;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.CHI_TIET_THUOC;
import com.vupt.application.model.gdhs.lv1.lv2.lv3.lv4.lv5.XML2Pack.XML2;
import com.vupt.application.utils.DataUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XML2ImportExcel {
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

    public XML2ImportExcel(Workbook workbook, Sheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    public XML2 readExcel() throws IOException {
        DataFormatter fmt = DataUtils.getExcelDataFormatter();
        Iterator<Row> iterator = sheet.iterator();
        Row firstRow = iterator.next();

        XML2 xml2 = new XML2();
        List<CHI_TIET_THUOC> ds_chi_tiet_thuoc = new ArrayList<>();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            CHI_TIET_THUOC chi_tiet_thuoc=getValueFromRow(currentRow);
            ds_chi_tiet_thuoc.add(chi_tiet_thuoc);
        }
        xml2.dsach_chi_tiet_thuoc.ds_chi_tiet_thuoc = ds_chi_tiet_thuoc;
        return xml2;
    }

    private CHI_TIET_THUOC getValueFromRow(Row currentRow) {
        try {
            DataFormatter fmt = DataUtils.getExcelDataFormatter();
            CHI_TIET_THUOC chi_tiet_thuoc = new CHI_TIET_THUOC();

            chi_tiet_thuoc.MA_LK = currentRow.getCell(COLUMN_INDEX_MA_LK).getStringCellValue();

            chi_tiet_thuoc.STT = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_STT)));

            chi_tiet_thuoc.MA_THUOC = currentRow.getCell(COLUMN_INDEX_MA_THUOC).getStringCellValue();

            chi_tiet_thuoc.MA_PP_CHEBIEN = currentRow.getCell(COLUMN_INDEX_MA_PP_CHEBIEN).getStringCellValue();

            chi_tiet_thuoc.MA_CSKCB_THUOC = currentRow.getCell(COLUMN_INDEX_MA_CSKCB_THUOC).getStringCellValue();

            chi_tiet_thuoc.MA_NHOM = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MA_NHOM)));

            chi_tiet_thuoc.TEN_THUOC = currentRow.getCell(COLUMN_INDEX_TEN_THUOC).getStringCellValue();

            chi_tiet_thuoc.DON_VI_TINH = currentRow.getCell(COLUMN_INDEX_DON_VI_TINH).getStringCellValue();

            chi_tiet_thuoc.HAM_LUONG = currentRow.getCell(COLUMN_INDEX_HAM_LUONG).getStringCellValue();
            chi_tiet_thuoc.DUONG_DUNG = currentRow.getCell(COLUMN_INDEX_DUONG_DUNG).getStringCellValue();

            chi_tiet_thuoc.DANG_BAO_CHE = currentRow.getCell(COLUMN_INDEX_DANG_BAO_CHE).getStringCellValue();

            chi_tiet_thuoc.LIEU_DUNG = currentRow.getCell(COLUMN_INDEX_LIEU_DUNG).getStringCellValue();

            chi_tiet_thuoc.CACH_DUNG = currentRow.getCell(COLUMN_INDEX_CACH_DUNG).getStringCellValue();

            chi_tiet_thuoc.SO_DANG_KY = currentRow.getCell(COLUMN_INDEX_SO_DANG_KY).getStringCellValue();

            chi_tiet_thuoc.TT_THAU = currentRow.getCell(COLUMN_INDEX_TT_THAU).getStringCellValue();

            chi_tiet_thuoc.PHAM_VI = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_PHAM_VI)));

            chi_tiet_thuoc.TYLE_TT_BH = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_TYLE_TT_BH)));

            chi_tiet_thuoc.SO_LUONG = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_SO_LUONG)));

            chi_tiet_thuoc.DON_GIA = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_DON_GIA)));

            chi_tiet_thuoc.THANH_TIEN_BV = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_THANH_TIEN_BV)));

            chi_tiet_thuoc.THANH_TIEN_BH = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_THANH_TIEN_BH)));

            chi_tiet_thuoc.T_NGUONKHAC_NSNN = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_NSNN)));

            chi_tiet_thuoc.T_NGUONKHAC_VTNN = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_VTNN)));

            chi_tiet_thuoc.T_NGUONKHAC_VTTN = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_VTTN)));

            chi_tiet_thuoc.T_NGUONKHAC_CL = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC_CL)));

            chi_tiet_thuoc.T_NGUONKHAC = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_NGUONKHAC)));

            chi_tiet_thuoc.MUC_HUONG = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MUC_HUONG)));

            chi_tiet_thuoc.T_BNTT = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_BNTT)));

            chi_tiet_thuoc.T_BNCCT = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_BNCCT)));

            chi_tiet_thuoc.T_BHTT = Double.parseDouble(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_T_BHTT)));

            chi_tiet_thuoc.MA_KHOA = currentRow.getCell(COLUMN_INDEX_T_MA_KHOA).getStringCellValue();

            chi_tiet_thuoc.MA_BAC_SI = currentRow.getCell(COLUMN_INDEX_MA_BAC_SI).getStringCellValue();

            chi_tiet_thuoc.MA_DICH_VU = currentRow.getCell(COLUMN_INDEX_MA_DICH_VU).getStringCellValue();

            chi_tiet_thuoc.NGAY_YL = currentRow.getCell(COLUMN_INDEX_NGAY_YL).getStringCellValue();

            chi_tiet_thuoc.NGAY_TH_YL = currentRow.getCell(COLUMN_INDEX_NGAY_TH_YL).getStringCellValue();

            chi_tiet_thuoc.MA_PTTT = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_MA_PTTT)));

            chi_tiet_thuoc.NGUON_CTRA = Integer.parseInt(fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_NGUON_CTRA)));

            String VET_THUONG_TP_STR = fmt.formatCellValue(currentRow.getCell(COLUMN_INDEX_VET_THUONG_TP));
            if (!VET_THUONG_TP_STR.trim().isEmpty()) {
                chi_tiet_thuoc.VET_THUONG_TP = Integer.parseInt(VET_THUONG_TP_STR);
            }

            chi_tiet_thuoc.DU_PHONG = currentRow.getCell(COLUMN_INDEX_DU_PHONG).getStringCellValue();

            return chi_tiet_thuoc;
        }        catch (Exception e){
            throw new AppException("Đã có lỗi xảy ra khi truy xuất dữ liệu từ Excel bảng XML2 hàng thứ "+currentRow.getRowNum() + "\n"+e.toString()+": "+e.getMessage(), e.getStackTrace());
        }
    }
}
